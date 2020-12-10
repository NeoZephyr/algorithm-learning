package com.pain.flame.structure.lookup;

public class BinarySearch {

    /**
     * 时间复杂度：
     * O(logn)
     *
     * 局限性：
     * 1. 依赖顺序表结构
     * 2. 只针对有序数据
     * 3. 数据量太小不适合二分查找：顺序遍历就足够了
     * 4. 数据量太大不适合二分查找：二分查找的底层依赖数组结构，而数组要求内存空间连续，对内存的要求比较苛刻
     *
     * @param data
     * @param target
     * @return
     */
    public int nonRecursionSearch(int[] data, int target) {
        if (data == null || data.length == 0) {
            return -1;
        }

        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (data[mid] == target) {
                return mid;
            } else if (data[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int recursionSearch(int[] data, int target) {
        if (data == null || data.length == 0) {
            return -1;
        }

        return search(data, 0, data.length - 1, target);
    }

    private int search(int[] data, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        // 注意运算符的优先级问题
        int mid = left + ((right - left) >> 1);

        if (data[mid] == target) {
            return mid;
        } else if (data[mid] > target) {
            return search(data, left, mid - 1, target);
        } else {
            return search(data, mid + 1, right, target);
        }
    }
}
