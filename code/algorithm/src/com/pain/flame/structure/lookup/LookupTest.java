package com.pain.flame.structure.lookup;

import com.pain.flame.structure.common.ArrayUtils;

import java.util.Arrays;

public class LookupTest {

    public static void main(String[] args) {
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

        System.out.println("Complete");
    }
}
