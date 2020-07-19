package com.pain.flame.lab;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        testSingleton();
    }

    public static void testSingleton() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println(String.format("thread: %s, instance: %s", Thread.currentThread().getId(), singleton.hashCode()));
        });

        Thread thread2 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println(String.format("thread: %s, instance: %s", Thread.currentThread().getId(), singleton.hashCode()));
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    public static void testCount() throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            counter.add10K();
        });
        Thread thread2 = new Thread(() -> {
            counter.add10K();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter.getCount());
    }


}
