package com.pain.flame.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; ++i) {
            int left = target - nums[i];

            if (map.containsKey(left) && !map.get(left).equals(i)) {
                return new int[]{i, map.get(left)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; ++i) {
            int left = target - nums[i];

            if (map.containsKey(left)) {
                return new int[]{i, map.get(left)};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
