package com.pain.flame.lab;

public class Singleton {
    private static Singleton instance;

    static {
        System.out.println("loading class Singleton");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public static Singleton getAnotherInstance() {
        return Holder.instance;
    }

    static class Holder {
        static {
            System.out.println("loading class Holder");
        }

        private static Singleton instance = new Singleton();
    }
}
