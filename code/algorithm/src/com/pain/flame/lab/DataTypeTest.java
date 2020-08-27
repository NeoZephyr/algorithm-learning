package com.pain.flame.lab;

import sun.misc.Unsafe;

public class DataTypeTest {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(100));
        System.out.println(Float.floatToIntBits(3.14f));
        float v1 = Float.intBitsToFloat(0x8000000);
        float v2 = Float.intBitsToFloat(0x7F800000);
        float v3 = Float.intBitsToFloat(0x7F800001);
        System.out.println(-0.0f == +0.0f);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        booleanTest();
    }

    private static void booleanTest() {
        boolean boolValue;
        boolValue = true;

        if (boolValue) {
            System.out.println("Hello, Java!");
        }

        if (boolValue == true) {
            System.out.println("Hello, JVM!");
        }
    }
}
