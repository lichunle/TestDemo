package com.example.demo.common.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

import javax.net.ssl.SSLContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * DESCRIPTION : http client 工具类
 * AUTHOR : 李毅
 * DATE : 2016/12/3.
 */
public class HttpClientUtils {

    private static final Logger logger = LogManager.getLogger(HttpClientUtils.class);
    public static final String HTTPS_SCHEME = "https";
    public static final String HTTP_SCHEME = "http";
    public static final String DEFAULT_ENCODING = "UTF-8";

    private String proxyHost;

    private int proxyPort;

    private int soTimeout;

    private int connectTimeout;

    private byte[] encryptKey;
    private String encryptMethod;
    private char[] encryptPassword;
    private String proxySwitch;


    private enum ProxySwitch {
        ON, OFF;
    }

    public HttpClientUtils() {
        this(5000, 5000);
    }

    public HttpClientUtils(int soTimeout, int connectTimeout) {
        this(null, -1, soTimeout, connectTimeout, "OFF");
    }

    public HttpClientUtils(String proxyHost, int proxyPort, int soTimeout, int connectTimeout, String proxySwitch) {
        this(proxyHost, proxyPort, soTimeout, connectTimeout, proxySwitch, null, null, null);
    }

    public HttpClientUtils(String proxyHost, int proxyPort, int soTimeout, int connectTimeout, String proxySwitch,
                           byte[] encryptKey, String encryptMethod, char[] encryptPassword) {
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.soTimeout = soTimeout;
        this.proxySwitch = proxySwitch;
        this.connectTimeout = connectTimeout;
        this.encryptKey = encryptKey;
        this.encryptMethod = encryptMethod;
        this.encryptPassword = encryptPassword;
    }

    private RequestConfig createRequestConfig() {
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setBufferSize(4128)
                .build();
        if (ProxySwitch.ON.name().equals(proxySwitch)) {
            HttpHost proxy = new HttpHost(this.proxyHost, this.proxyPort);
            return RequestConfig.custom().setSocketTimeout(soTimeout)
                    .setConnectTimeout(connectTimeout).setProxy(proxy).build();//设置请求和传输超时时间
        }
        return RequestConfig.custom().setSocketTimeout(soTimeout)
                .setConnectTimeout(connectTimeout).build();//设置请求和传输超时时间
    }

    /**
     * @return
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    private CloseableHttpClient createSSLClientDefault() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException, IOException, CertificateException, UnrecoverableKeyException {
        long start = System.currentTimeMillis();
        try {
            logger.info("创建 createSSLClientDefault [BEGIN]");
            KeyStore keyStore = null;
            if (StringUtils.isNotBlank(this.encryptMethod) && this.encryptKey != null) {
                ByteArrayInputStream inputStream = new ByteArrayInputStream(encryptKey);
                keyStore = KeyStore.getInstance(encryptMethod);
                keyStore.load(inputStream, encryptPassword);
            }
            if (keyStore == null) {
                logger.debug("HttpClient create SSL client by keystore is null");
            }
            SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, encryptPassword).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            logger.debug("[ssl step3]创建httpClient对象===>");

            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } finally {
            logger.info("创建 createSSLClientDefault [END] Elapsed Time: {}ms", System.currentTimeMillis() - start);
        }
    }

    /**
     * 普通的Http请求
     *
     * @return
     */
    private CloseableHttpClient createClientDefault(String scheme) throws KeyStoreException, NoSuchAlgorithmException,
            KeyManagementException, IOException, CertificateException, UnrecoverableKeyException {
        long start = System.currentTimeMillis();
        try {
            logger.info("创建 CloseableHttpClient [BEGIN]");
            if (HTTP_SCHEME.equals(scheme)) {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                return httpClient;
            } else {
                return createSSLClientDefault();
            }
        } finally {
            logger.info("创建 CloseableHttpClient [END] Elapsed Time: {}ms", System.currentTimeMillis() - start);
        }
    }

    /**
     * @param url
     * @param charset
     * @param params
     * @return
     * @throws Exception
     */
    public String doPostToString(String url, String charset, Map<String, String> params) throws Exception {
        return this.doPostToString(url, charset, params, null);
    }

    /**
     * @param url
     * @param charset
     * @param params
     * @return
     * @throws Exception
     */
    public String doPostToString(String url, String charset, Map<String, String> params, Map<String, String> headers) throws Exception {
        InputStream inputStream = doPost(url, charset, params, headers);
        return IOUtils.toString(inputStream);
    }

    /**
     * post url 统一入口
     *
     * @param url
     * @param charset
     * @param params
     * @return
     * @throws Exception
     */
    public InputStream doPost(String url, String charset, Map<String, String> params) throws Exception {
        return doPost(url, charset, params, null);
    }

    /**
     * post url 统一入口
     *
     * @param url
     * @param charset
     * @param params
     * @return
     * @throws Exception
     */
    public InputStream doPost(String url, String charset, Map<String, String> params, Map<String, String> headers) throws Exception {
        try {
            String httpScheme = HTTP_SCHEME;
            if (url.startsWith(HTTPS_SCHEME)) {
                httpScheme = HTTPS_SCHEME;
            }
            charset = StringUtils.isBlank(charset) ? DEFAULT_ENCODING : charset;
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(createRequestConfig());
            if (headers != null && headers.size() != 0) {
                for (String key : headers.keySet()) {
                    httpPost.addHeader(key, headers.get(key));
                }
            }
            List<NameValuePair> pairList = getPostNameValuePairs(params);
            if (CollectionUtils.isNotEmpty(pairList)) {
                httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName(charset)));
            }
            HttpResponse response = createClientDefault(httpScheme).execute(httpPost);
            responseStatus(response);
            HttpEntity httpEntity = response.getEntity();
            return httpEntity.getContent();
        } catch (IOException e) {
            logger.error("http client doPost error", e);
            throw new Exception(e);
        }
    }

    /**
     * 返回字符串类型
     *
     * @param url
     * @param charset
     * @param params
     * @param content
     * @param contentType
     * @return
     * @throws Exception
     */
    public String doBodyPostToString(String url, String charset, Map<String, String> params, String content, ContentType contentType) throws Exception {
        InputStream inputStream = this.doBodyPost(url, charset, params, content, contentType);
        return IOUtils.toString(inputStream);
    }

    /**
     * @param url
     * @param charset
     * @param params
     * @param content
     * @param contentType
     * @return
     * @throws Exception
     */
    public String doBodyPostToString(String url, String charset, Map<String, String> params, byte[] content, ContentType contentType) throws Exception {
        InputStream inputStream = this.doBodyPost(url, charset, params, content, contentType);
        return IOUtils.toString(inputStream);
    }

    /**
     * post  body 统一入口
     *
     * @param url
     * @param charset
     * @param params
     * @param contentType
     * @return
     * @throws Exception
     */
    public InputStream doBodyPost(String url, String charset, Map<String, String> params, byte[] content, ContentType contentType) throws Exception {
        try {
            String httpScheme = HTTP_SCHEME;
            if (url.startsWith(HTTPS_SCHEME)) {
                httpScheme = HTTPS_SCHEME;
            }
            charset = StringUtils.isNotBlank(charset) ? charset : DEFAULT_ENCODING;
            HttpPost httpPost = new HttpPost(url);
            if (contentType == null) {
                contentType = ContentType.APPLICATION_JSON;
            }
            List<NameValuePair> pairList = getPostNameValuePairs(params);
            if (CollectionUtils.isNotEmpty(pairList)) {
                httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName(charset)));
            }
            if (content != null && content.length > 0) {
                HttpEntity entity = new ByteArrayEntity(content);
                httpPost.setEntity(entity);
            }
            httpPost.setConfig(createRequestConfig());

            HttpResponse response = createClientDefault(httpScheme).execute(httpPost);
            responseStatus(response);
            HttpEntity httpEntity = response.getEntity();
            return httpEntity.getContent();
        } catch (IOException e) {
            logger.error("http client doBodyPost error", e);
            throw new Exception(e);
        }
    }

    /**
     * post  body 统一入口
     *
     * @param url
     * @param charset
     * @param params
     * @param contentType
     * @return
     * @throws Exception
     */
    public InputStream doBodyPost(String url, String charset, Map<String, String> params, byte[] content, ContentType contentType, Map<String, String> headers) throws Exception {
        try {
            String httpScheme = HTTP_SCHEME;
            if (url.startsWith(HTTPS_SCHEME)) {
                httpScheme = HTTPS_SCHEME;
            }
            charset = StringUtils.isNotBlank(charset) ? charset : DEFAULT_ENCODING;
            HttpPost httpPost = new HttpPost(url);
            if (contentType == null) {
                contentType = ContentType.APPLICATION_JSON;
            }
            List<NameValuePair> pairList = getPostNameValuePairs(params);
            if (CollectionUtils.isNotEmpty(pairList)) {
                httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName(charset)));
            }
            if (content != null && content.length > 0) {
                HttpEntity entity = new ByteArrayEntity(content);
                httpPost.setEntity(entity);
            }
            httpPost.setConfig(createRequestConfig());
            if (headers != null && headers.size() != 0) {
                for (String key : headers.keySet()) {
                    httpPost.addHeader(key, headers.get(key));
                }
            }
            HttpResponse response = createClientDefault(httpScheme).execute(httpPost);
            responseStatus(response);
            HttpEntity httpEntity = response.getEntity();
            return httpEntity.getContent();
        } catch (IOException e) {
            logger.error("http client doBodyPost error", e);
            throw new Exception(e);
        }
    }

    /**
     * post  body 统一入口
     *
     * @param url
     * @param charset
     * @param params
     * @param contentType
     * @return
     * @throws Exception
     */
    public InputStream doBodyPost(String url, String charset, Map<String, String> params, String content, ContentType contentType) throws Exception {
        return this.doBodyPost(url, charset, params, content, contentType, null);
    }

    /**
     * post  body 统一入口
     *
     * @param url
     * @param charset
     * @param params
     * @param contentType
     * @return
     * @throws Exception
     */
    public InputStream doBodyPost(String url, String charset, Map<String, String> params, String content, ContentType contentType, Map<String, String> headers) throws Exception {

        try {
            String httpScheme = HTTP_SCHEME;
            if (url.startsWith(HTTPS_SCHEME)) {
                httpScheme = HTTPS_SCHEME;
            }
            charset = StringUtils.isNotBlank(charset) ? charset : DEFAULT_ENCODING;
            HttpPost httpPost = new HttpPost(url);
            if (contentType == null) {
                contentType = ContentType.APPLICATION_JSON;
            }
            List<NameValuePair> pairList = getPostNameValuePairs(params);
            if (CollectionUtils.isNotEmpty(pairList)) {
                httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName(charset)));
            }
            if (StringUtils.isNotBlank(content)) {
                //HttpEntity entity = new ByteArrayEntity(content.getBytes(charset), contentType);
                //httpPost.setEntity(entity);
                StringEntity entity = new StringEntity(content, contentType);
                httpPost.setEntity(entity);
            }
            httpPost.setConfig(createRequestConfig());
            if (headers != null && headers.size() != 0) {
                for (String key : headers.keySet()) {
                    httpPost.addHeader(key, headers.get(key));
                }
            }

            HttpResponse response = createClientDefault(httpScheme).execute(httpPost);
            responseStatus(response);
            HttpEntity httpEntity = response.getEntity();
            return httpEntity.getContent();
        } catch (IOException e) {
            logger.error("http client doBodyPost error", e);
            throw new Exception(e);
        }
    }

    /**
     * @param response
     */
    private void responseStatus(HttpResponse response) throws Exception {
        if (HttpStatus.NOT_FOUND.value() == response.getStatusLine().getStatusCode()) {
            throw new Exception();
        } else if (HttpStatus.INTERNAL_SERVER_ERROR.value() == response.getStatusLine().getStatusCode()) {
            logger.error("http request status internal error", response.getStatusLine().getStatusCode());
            throw new Exception();
        } else if (HttpStatus.OK.value() != response.getStatusLine().getStatusCode()) {
            logger.error("http request status error", response.getStatusLine().getStatusCode());
            throw new Exception();
        }
    }

    /**
     * 构造POST参数
     *
     * @param params
     * @return
     */
    private List<NameValuePair> getPostNameValuePairs(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return null;
        }
        List<NameValuePair> pairList = new ArrayList<>(params.size());
        if (!params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry
                        .getValue());
                pairList.add(pair);
            }
        }
        return pairList;
    }

    /**
     * 返回字符串类型
     *
     * @param url
     * @param charset
     * @param args
     * @return
     * @throws Exception
     */
    public String doGetToString(String url, String charset, Map<String, String> args) throws Exception {
        return this.doGetToString(url, charset, args, null);
    }

    /**
     * 返回字符串类型
     *
     * @param url
     * @param charset
     * @param args
     * @return
     * @throws Exception
     */
    public String doGetToString(String url, String charset, Map<String, String> args, Map<String, String> headers) throws Exception {
        InputStream inputStream = doGet(url, charset, args, headers);
        return IOUtils.toString(inputStream);
    }

    /**
     * get 统一入口
     *
     * @param url
     * @return
     * @throws Exception
     */
    public InputStream doGet(String url, String charset, Map<String, String> args) throws Exception {
        return this.doGet(url, charset, args, null);
    }

    /**
     * get 统一入口
     *
     * @param url
     * @return
     * @throws Exception
     */
    public InputStream doGet(String url, String charset, Map<String, String> args, Map<String, String> headers) throws Exception {
        try {
            String httpScheme = HTTP_SCHEME;
            if (url.startsWith(HTTPS_SCHEME)) {
                httpScheme = HTTPS_SCHEME;
            }
            HttpGet httpget = new HttpGet(url);
            httpget.setConfig(createRequestConfig());
            if (headers != null && headers.size() != 0) {
                for (String key : headers.keySet()) {
                    httpget.addHeader(key, headers.get(key));
                }
            }
            HttpResponse response = createClientDefault(httpScheme).execute(httpget);
            responseStatus(response);
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            return is;
        } catch (Exception e) {
            logger.error("http client doGet error", e);
            throw new Exception(e);
        }
    }

}
