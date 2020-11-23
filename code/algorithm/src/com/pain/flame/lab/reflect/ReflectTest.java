package com.pain.flame.lab.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> klass = Class.forName("com.pain.flame.lab.reflect.ReflectTest");
        Method method = klass.getMethod("trace", int.class);
        method.setAccessible(true);
        polluteProfile();
        long current = System.currentTimeMillis();

        Integer arg = 128;
        Object[] argArr = new Object[1];
        argArr[0] = 128;

        for (int i = 1; i < 2000000000; ++i) {
            if (i % 100000000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, argArr);
        }
    }

    public static void polluteProfile() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method1 = ReflectTest.class.getMethod("trace", int.class);
        Method method2 = ReflectTest.class.getMethod("trace", int.class);

        System.out.println(method1.equals(method2));

        for (int i = 0; i < 2000; ++i) {
            method1.invoke(null, 0);
            method2.invoke(null, 0);
        }
    }

    public static void trace(int i) {
    }

    public static void trace1(int i) {}

    public static void trace2(int i) {}
}
