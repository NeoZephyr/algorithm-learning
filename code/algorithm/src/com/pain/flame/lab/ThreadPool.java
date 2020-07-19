package com.pain.flame.lab;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) throws InterruptedException {
        CollectService collectService = new CollectService();
        collectService.start();

        Thread.sleep(2 * 1000);
        collectService.shutdown();
        boolean result = collectService.pool.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("main thread: " + result);

        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        System.out.println(queue.size());

//        Thread.currentThread().interrupt();
//
//        if (Thread.interrupted()) {
//            System.out.println("ok");
//        } else {
//            System.out.println("not ok");
//        }
//
//        if (Thread.interrupted()) {
//            System.out.println("ok");
//        } else {
//            System.out.println("not ok");
//        }
    }

    static class CollectService {
        ExecutorService pool;
        LinkedBlockingQueue queue;
        volatile boolean running = false;

        CollectService() {
            pool = Executors.newFixedThreadPool(10);
            queue = new LinkedBlockingQueue();
            running = true;
        }

        void start() {
            for (int i = 0; i < 10; ++i) {
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        while (running) {
                            System.out.println(String.format("%s begin", Thread.currentThread().getId()));
                            try {
                                Object o = queue.take();
                            } catch (InterruptedException e) {
                                System.out.println(String.format("%s interrupt", Thread.currentThread().getId()));
                                continue;
                            }

                            System.out.println(String.format("%s end", Thread.currentThread().getId()));
                        }

                        System.out.println("========");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }

        void shutdown() {
            running = false;
            pool.shutdownNow();
        }
    }
}
