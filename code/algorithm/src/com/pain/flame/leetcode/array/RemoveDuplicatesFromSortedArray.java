package com.pain.flame.leetcode.array;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int noRepeatPos = 0;
        int pos = 1;

        while (pos < nums.length) {
            if (nums[pos] != nums[noRepeatPos]) {
                nums[++noRepeatPos] = nums[pos];
            }

            ++pos;
        }

        return noRepeatPos + 1;
    }
}
