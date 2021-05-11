package com.example.demo;

import net.minidev.json.JSONObject;
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
    public static void main(String[] args) throws ParseException {
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
        double time = (double)112 / 60;
        DecimalFormat df = new DecimalFormat("0.0");
//        return time > 0 ? df.format(time)+"小时" : "";
        String avgTime = time > 0 ? df.format(time)+"小时" : "";
        long mins = 50 % 60;
        String costString = avgTime +"小时"+mins+"分钟";
        StringBuilder sb = new StringBuilder();
//        sb.append(avgTime > 0 ? avgTime +"小时" : "");
        sb.append(mins > 0 ? mins +"分钟" : "");

        System.out.println(avgTime);
        System.out.println(System.currentTimeMillis());
    }

}
