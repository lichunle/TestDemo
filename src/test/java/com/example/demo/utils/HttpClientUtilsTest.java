package com.example.demo.utils;

import com.example.demo.common.utils.HttpClientUtils;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName HttpClientUtilsTest
 * @Description
 * @Author ian
 * @Date 2021/7/20 23:38
 * @Version 1.0.0
 **/
public class HttpClientUtilsTest {
    private AtomicInteger counter = new AtomicInteger(0);
    private String url = "http://www.baidu.com/";

    public static void main(String[] args) {
        new HttpClientUtilsTest().test();
    }

    // 执行测试
    private void test() {
        int number = 100000; // 总请求数
        int concurrent = 50; // 每次并发请求数
        CountDownLatch countDownLatch = new CountDownLatch(number); // 计数器
        ExecutorService threadPool = Executors.newFixedThreadPool(concurrent); // 线程池
        int concurrentPer = concurrent;
        boolean over = false;
        while(!over) {
            number = number - concurrent;
            if(number <= 0) {
                concurrentPer = number + concurrent;
                over = true;
            }

            // 线程池批量提交
            for(int i = 0; i < concurrentPer; i++) {
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            request(url);
                            Thread.sleep(100);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            countDownLatch.countDown();
                        }
                    }
                });
            }
        }
        try {
            countDownLatch.await();
            threadPool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 访问指定地址
    private void request(String url) throws Exception {
//        HttpGet httpGet = new HttpGet(url);

        commnicate(url);
    }

    // 负责底层通信处理
    private void commnicate(String url) throws Exception {
//        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//            @Override
//            public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
//                return EntityUtils.toString(response.getEntity());
//            }
//        };
//
//        HttpClient client = HttpClients.createDefault();
//        String body = client.execute(request, responseHandler); // 线程可能会在这里被阻塞

        String body = new HttpClientUtils().doGetToString(url, "UTF-8", null);
        System.out.println(String.format("body size: %s, counter: %s", body.length(), counter.incrementAndGet()));
    }
}
