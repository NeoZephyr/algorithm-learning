package com.pain.flame.structure.array;

public class Sentinel {

    static int find1(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int i = 0;

        // 这里有两个比较操作：i < n 和 a[i] == key
        while (i < arr.length) {
            if (arr[i] == key) {
                return i;
            }
            ++i;
        }

        return -1;
    }

    static int find2(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr[arr.length - 1] == key) {
            return arr.length - 1;
        }

        int tmp = arr[arr.length - 1];
        arr[arr.length - 1] = key;

        int i = 0;

        // 少了 i < n 这个比较操作
        while (arr[i] != key) {
            ++i;
        }

        arr[arr.length - 1] = tmp;

        if (i == arr.length - 1) {
            return -1;
        } else {
            return i;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 5, 9, 6};
        System.out.println(find1(arr, 6));
        System.out.println(find2(arr, 6));
        System.out.println(find1(arr, 7));
        System.out.println(find2(arr, 7));
    }
}
