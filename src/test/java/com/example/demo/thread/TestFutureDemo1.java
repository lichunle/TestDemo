package com.example.demo.thread;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestFutureDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        FutureTask<String> task = new FutureTask<String>(new Runnable() {
//
//            @Override
//            public void run() {
//                System.out.println("==============running man==========");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"go");
//
//        new Thread(task).start();
//        boolean isDone = task.isDone();
//        String result = task.get();
//        boolean isDone1 = task.isDone();
//        System.out.println("result:" + isDone + "," + isDone1 + "execRes=" + result);

//        try {
//            int i = 3/0;
//            ConcurrentHashMap map = new ConcurrentHashMap();
//            Map<String,Object> map1 = new HashMap<>();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        JSONObject jsonObj = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject o1 = new JSONObject();
        o1.put("name", "joe");
        array.add(o1);
        jsonObj.put("list", array);
        System.out.println("origin:" + jsonObj.toJSONString());

        JSONArray reArr = jsonObj.getJSONArray("list");
        buildObj(reArr);
        System.out.println("return:" + jsonObj.toJSONString());
    }
    public static void buildObj(JSONArray arr) {
        JSONObject o1 = new JSONObject();
        o1.put("name", "bob");
        arr.add(o1);
    }

}
