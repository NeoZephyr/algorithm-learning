package com.pain.flame.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class<?> helloClazz = new HelloClassLoader("/Users/pain/Documents/algorithm-learning/code/algorithm/meta/Hello.xlass").findClass("Hello");
            Method helloMethod = helloClazz.getMethod("hello");
            Object hello = helloClazz.newInstance();
            helloMethod.invoke(hello);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private String classPath;

    public HelloClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(classPath);
            byte[] buf = new byte[1024];
            int len = fis.read(buf, 0, 1024);
            for (int i = 0; i < len; ++i) {
                buf[i] = (byte) (255 - buf[i]);
            }
            return defineClass(name, buf, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
