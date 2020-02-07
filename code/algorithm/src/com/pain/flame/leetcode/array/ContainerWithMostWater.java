package com.pain.flame.leetcode.array;

public class ContainerWithMostWater {

    public int maxArea1(int[] height) {
        int max = -1;

        for (int i = 0; i < height.length; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                int curArea = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, curArea);
            }
        }

        return max;
    }

    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = -1;

        while (left < right) {
            int curHeight = (Math.min(height[left], height[right]));
            int curArea = curHeight * (right - left);
            max = Math.max(max, curArea);

            if (curHeight == height[left]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
