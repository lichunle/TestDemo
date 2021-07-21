package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.BaseResult;
import com.example.demo.bean.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
public class TestDemo {

    @Test
    public void mapTest() {
        System.out.println(StringUtils.isEmpty("  "));
        System.out.println(StringUtils.isBlank("  "));
        System.out.println("===========");
    }

    @Test
    public void test() {
        BigDecimal num1 = new BigDecimal("1.9");
        System.out.println("num1:\t" + num1);
    }

    @Test
    public void countDownTest() {
        String url = "https://api.haigeek.com/ddc/modelType/apptypeInfo/A177";
        try {
            URL urlObj = new URL(url);
            url = urlObj.getPath();
            System.out.println("====:{}" + url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jsonArrTest() {
        String result = "{\"data\":[{\"code\":\"A168\",\"enName\":\"Rouller Washer\",\"hotspotName\":\"U-WMT\",\"icon\n" +
                "\":\"https://resource.haigeek.com:443/download/resource/selfService//hardware/modeltypeimg/5120b9648b8f416ba544a6095ac0dd09.png\",\"name\":\"滚筒洗衣机\"}],\"retCode\":\"00000\",\"\n" +
                "retInfo\":\"操作成功\"}";



    }
    public static void main(String[] args) throws ParseException, MalformedURLException {
//        System.out.println(Charset.defaultCharset());
//        Integer a = 127;
//        Integer b = 127;
//        System.out.println(a.equals(b));
//        Integer c = 128;
//        Integer d = 128;
//        System.out.println(c.equals(d));
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getTime());
//        calendar.add(Calendar.MONTH, -1);
//        System.out.println(calendar.getTime());
//        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date = SDF.format(new Date());
//        System.out.println(date);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse("2021-04-27 00:00:00");
//        System.out.println(date);
//        System.out.println(sdf.format(date));
//        System.out.println(sdf.format("2021-04-27 00:00:00"));
//        double time = (double)112 / 60;
//        DecimalFormat df = new DecimalFormat("0.0");
////        return time > 0 ? df.format(time)+"小时" : "";
//        String avgTime = time > 0 ? df.format(time)+"小时" : "";
//        long mins = 50 % 60;
//        String costString = avgTime +"小时"+mins+"分钟";
//        StringBuilder sb = new StringBuilder();
////        sb.append(avgTime > 0 ? avgTime +"小时" : "");
//        sb.append(mins > 0 ? mins +"分钟" : "");
//
//        System.out.println(avgTime);
//        System.out.println(System.currentTimeMillis());
//        SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateStr = "2021-3-25 21:51:11";
//        try {
//            Date date = SDF.parse(dateStr);
//            System.out.println(SDF.format(date));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        BaseResult result = new BaseResult();
//
//        System.out.println(JSONObject.toJSONString(result));
//        try {
//            testException();
//        } catch (ServiceException e) {
//            System.out.println("========" + e);
////            e.printStackTrace();
//        }
//        String keyWords = "uChannelCode";
////        URL url = new URL("http://www.baidu.com?uChannelCode=push");
////        URL url = new URL("mpaas://vipTrialCenter?needAuthLogin=1&id=2751556660413792258#/trialDetail");
////        String url = "mpaas://vipTrialCenter?needAuthLogin=1&id=2751556660413792258#/trialDetail";
////        String url = "mpaas://vipTrialCenter";
//        String url = "mpaas://vipTrialCenter#/trialDetail";
////        String url = "http://www.baidu.com?uChannelCode=push";
//
//        System.out.println("OLD url:\t" + url);
////        String path = url.getPath();
////        String queryStr = url.getQuery();
////        System.out.println(path);
////        System.out.println(queryStr);
////        System.out.println(queryStr.indexOf(keyWords));
//        if(url.indexOf(keyWords) >= 0) {
//            System.out.println("exist");
//            return;
//        }
//        if(url.indexOf("?") < 0) {
//            if(url.indexOf("#") >= 0) {
//                String[] arr = url.split("\\#");
//                StringBuilder sBuilder = new StringBuilder("");
//                for(int i = 0;i < arr.length;i++) {
//                    if(i == 1) {
//                        sBuilder.append("?uChannelCode=push#");
//                    }
//                    sBuilder.append(arr[i]);
//                }
//                url = sBuilder.toString();
//            } else {
//                url += "?uChannelCode=push";
//            }
//            System.out.println("NEW url:\t" + url);
//            return;
//        }
//        // not exist
//        String[] arr = url.split("\\?");
//
//        StringBuilder sBuilder = new StringBuilder("");
//        for(int i = 0;i < arr.length;i++) {
//            if(i == 1) {
//                sBuilder.append("?uChannelCode=push&");
//            }
//            sBuilder.append(arr[i]);
//        }
//        System.out.println("NEW url:\t" + sBuilder.toString());
        testChannelCode();
    }


    public static void testChannelCode() {
        String jumpUrl = "mpaas://vipTrialCenter?needAuthLogin=1&id=2751556660413792258#/trialDetail";
//        String url = "mpaas://vipTrialCenter";
//        String url = "mpaas://vipTrialCenter#/trialDetail";
//        String url = "http://www.baidu.com#/trialDetail";
        System.out.println(jumpUrl);
        String keyWords = "uChannelCode";

        if(jumpUrl.indexOf(keyWords) >= 0) {
            return;
        }
        if(jumpUrl.indexOf("?") < 0) {
            if(jumpUrl.indexOf("#") >= 0) {
                String[] arr = jumpUrl.split("\\#");
                StringBuilder sBuilder = new StringBuilder("");
                for(int i = 0;i < arr.length;i++) {
                    if(i == 1) {
                        sBuilder.append("?uChannelCode=push#");
                    }
                    sBuilder.append(arr[i]);
                }
                jumpUrl = sBuilder.toString();
            } else {
                jumpUrl += "?uChannelCode=push";
            }
            System.out.println(jumpUrl);
            return;
        }
        // not exist
        String[] arr = jumpUrl.split("\\?");
        StringBuilder sBuilder = new StringBuilder("");
        for(int i = 0;i < arr.length;i++) {
            if(i == 1) {
                sBuilder.append("?uChannelCode=push&");
            }
            sBuilder.append(arr[i]);
        }
        jumpUrl = sBuilder.toString();
        System.out.println(jumpUrl);
    }
    public static void testException() throws ServiceException {


        try {
            int i = 1/0;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

}
