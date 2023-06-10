package com.example.demo.thread;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Classname Demo1
 * @Description
 * @Date 2021/6/8 18:44
 * @Created by lichunle
 */
public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);
//
//
//        Callable<List<Integer>> callable = () -> {
//            List<Integer> list = new ArrayList<>();
//            list.add(1);
//            return list;
//        };
//        Future<List<Integer>> futureList = threadPoolExecutor.submit(callable);
//        threadPoolExecutor.shutdown();
//
//        try {
//            Thread.sleep(2000);
//            System.out.println("The main thread performs other tasks");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        FutureTask<List<Integer>> futureList = new FutureTask<>(callable);
////        threadPoolExecutor.execute(futureList);
//        List<Integer> resList = futureList.get();
//        if(resList != null) {
//            System.out.println(JSONObject.toJSONString(resList));
//        } else {
//            System.out.println("can not get result");
//        }
//        System.out.println("主线程执行完成");
////        Runnable
////        Callable
////        FutureTask
//
//        Thread t1 = new Thread();



        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS,  new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());

        List<FutureTask> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
//            Callable task = () -> {
//                System.out.println(Thread.currentThread().getName());
//                return null;
//            };
//            list.add(task);
            int tI = i;
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\ttask:" + tI);
            });
        }
//        list.parallelStream().forEach();

//        threadPool.execute();

//        Map<String, <T>> map = new HashMap<>();
    }

//    public static List<Integer> buildList() {
//
//    }
}
