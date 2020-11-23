package com.pain.flame.lab;

public class StaticVarTest {

    private static int var1 = 100;

    static {
        var1 = 200;
        var2 = 2000;
    }

    private static int var2 = 1000;

    private int var3 = 300;

    StaticVarTest() {
        var3 = 3000;
    }

    StaticVarTest(int var) {
        var3 = var;
    }

    public static void main(String[] args) {
        // 200
        System.out.println(StaticVarTest.var1);

        // 1000
        System.out.println(StaticVarTest.var2);
    }
}
