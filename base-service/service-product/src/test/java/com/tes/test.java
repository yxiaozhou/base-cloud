package com.tes;

import java.util.concurrent.*;

public class test {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //创建一个线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(()-> {
            //System.out.println("CallableTest");
            TimeUnit.SECONDS.sleep(5);
            return "CallableTest";
        });
        System.out.println(future.get());
    }
}
