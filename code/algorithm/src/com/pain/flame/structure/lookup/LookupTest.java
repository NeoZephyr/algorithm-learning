package com.pain.flame.structure.lookup;

import com.pain.flame.structure.common.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;

public class LookupTest {

    public static void main(String[] args) {
        // testSearch();
        // testSearchFirstEqual();
        // testSearchLastEqual();
        // testSearchFirstGreatOrEqual();
        testSearchLastLessOrEqual();
        System.out.println("Complete");
    }

    private static void testSearch() {
        BinarySearch binarySearch = new BinarySearch();
        boolean failed = false;

        for (int i = 0; i < 1000; ++i) {
            int[] data = ArrayUtils.genDistinctIntArray(1000, 0, 1000);
            Arrays.sort(data);

            for (int j = 0; j < data.length; ++j) {
                int target = data[j];
                // int pos = binarySearch.recursionSearch(data, target);
                int pos = binarySearch.nonRecursionSearch(data, target);

                if (pos != j) {
                    failed = true;
                    System.out.println("ERROR");
                    System.out.printf("data: %s\n", Arrays.toString(data));
                    System.out.printf("target: %d, actual position: %d, expect position: %d\n", target, pos, j);
                    break;
                }
            }

            if (failed) {
                break;
            }
        }
    }

    private static void testSearchFirstEqual() {
        BinarySearch binarySearch = new BinarySearch();
        boolean failed = false;

        for (int i = 0; i < 1000; ++i) {
            int[] data = ArrayUtils.genIntArray(1000, 0, 100);
            Arrays.sort(data);
            HashMap<Integer, Integer> dataToPos = new HashMap<>();

            for (int j = 0; j < data.length; ++j) {
                int target = data[j];
                if (!dataToPos.containsKey(target)) {
                    dataToPos.put(target, j);
                }

                int expectPos = dataToPos.get(target);
                int actualPos = binarySearch.searchFirstEqual(data, target);

                if (actualPos != expectPos) {
                    failed = true;
                    System.out.println("ERROR");
                    System.out.printf("data: %s\n", Arrays.toString(data));
                    System.out.printf("target: %d, actual position: %d, expect position: %d\n", target, actualPos, expectPos);
                    break;
                }
            }

            if (failed) {
                break;
            }
        }
    }

    private static void testSearchLastEqual() {
        BinarySearch binarySearch = new BinarySearch();
        boolean failed = false;

        for (int i = 0; i < 1000; ++i) {
            int[] data = ArrayUtils.genIntArray(1000, 0, 100);
            Arrays.sort(data);
            HashMap<Integer, Integer> dataToPos = new HashMap<>();

            for (int j = 0; j < data.length; ++j) {
                dataToPos.put(data[j], j);
            }

            for (int j = 0; j < data.length; ++j) {
                int target = data[j];
                int expectPos = dataToPos.get(target);
                int actualPos = binarySearch.searchLastEqual(data, target);

                if (actualPos != expectPos) {
                    failed = true;
                    System.out.println("ERROR");
                    System.out.printf("data: %s\n", Arrays.toString(data));
                    System.out.printf("target: %d, actual position: %d, expect position: %d\n", target, actualPos, expectPos);
                    break;
                }
            }

            if (failed) {
                break;
            }
        }
    }

    private static void testSearchFirstGreatOrEqual() {
        BinarySearch binarySearch = new BinarySearch();
        int[] constArr = {1, 1, 1, 2, 2, 2, 2, 4, 5, 10, 10, 10, 10, 10, 200, 300, 400, 400};

        System.out.println(binarySearch.searchFirstGreatOrEqual(constArr, 1));
        System.out.println(binarySearch.searchFirstGreatOrEqual(constArr, 3));
        System.out.println(binarySearch.searchFirstGreatOrEqual(constArr, 5));
        System.out.println(binarySearch.searchFirstGreatOrEqual(constArr, 9));
        System.out.println(binarySearch.searchFirstGreatOrEqual(constArr, 10));
        System.out.println(binarySearch.searchFirstGreatOrEqual(constArr, 399));
        System.out.println(binarySearch.searchFirstGreatOrEqual(constArr, 400));
        System.out.println(binarySearch.searchFirstGreatOrEqual(constArr, 499));
    }

    private static void testSearchLastLessOrEqual() {
        BinarySearch binarySearch = new BinarySearch();
        int[] constArr = {1, 1, 1, 2, 2, 2, 2, 4, 5, 10, 10, 10, 10, 10, 200, 300, 400, 400};

        System.out.println(binarySearch.searchLastLessOrEqual(constArr, 1));
        System.out.println(binarySearch.searchLastLessOrEqual(constArr, 3));
        System.out.println(binarySearch.searchLastLessOrEqual(constArr, 5));
        System.out.println(binarySearch.searchLastLessOrEqual(constArr, 9));
        System.out.println(binarySearch.searchLastLessOrEqual(constArr, 10));
        System.out.println(binarySearch.searchLastLessOrEqual(constArr, 399));
        System.out.println(binarySearch.searchLastLessOrEqual(constArr, 400));
        System.out.println(binarySearch.searchLastLessOrEqual(constArr, 499));
    }
}
