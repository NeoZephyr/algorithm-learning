package com.pain.flame.lab;

public class ClassLoaderTest {
    public static void main(String[] args) {
        Singleton.getInstance();
        new Singleton();
        Singleton.getAnotherInstance();
    }
}
