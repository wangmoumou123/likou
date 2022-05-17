package com.likou;

public class JumpSolution_5_16 {
    public static void main(String[] args) {
        System.out.println(new JumpSolution_5_16().jump(new int[]{1, 5, 5, 2, 3, 4, 1}));
    }

    public int jump(int[] nums) {

        int length = nums.length;
        int step = 0, end = 0, maxEnd = 0;
        for (int i = 0; i < length - 1; i++) {
            maxEnd = maxEnd > i + nums[i] ? maxEnd : i + nums[i];
            if (i == end) {
                end = maxEnd;
                step++;
            }

        }
        return step;

    }


    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}


