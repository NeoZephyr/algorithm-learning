package com.pain.flame.structure.common;

import java.util.Arrays;

public class ArrayUtils {

    public static int[] genIntArray(int size, int start, int end) {
        int[] arr = new int[size];

        for (int i = 0; i < size; ++i) {
            arr[i] = RandomUtils.randomInt(start, end);
        }

        return arr;
    }

    public static boolean compare(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }

        if (arr1 == null || arr2 == null) {
            return false;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        int n = arr1.length;

        for (int i = 0; i < n; ++i) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; ++i) {
            Thread.sleep(1);
            int[] arr = genIntArray(10, 0, 100);
            System.out.println(Arrays.toString(arr));
        }
    }
}
