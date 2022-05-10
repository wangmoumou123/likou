package com.likou;

import java.nio.channels.MulticastChannel;
import java.util.Arrays;

public class NextQueue_5_9 {

    public static void main(String[] args) {
//        new NextQueue_5_9().nextPermutation(new int[]{2, 3, 1});
//        new NextQueue_5_9().nextPermutation(new int[]{1, 3, 2});
        int[] ints = {2,3,1,3,3};
//        new NextQueue_5_9().swap(2,3, ints);
//        new NextQueue_5_9().reverse(ints, 0);
        new NextQueue_5_9().nextPermutation(ints);

        System.out.println(Arrays.toString(ints));

    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int temp;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int small = i;
                for (int j = length-1; j >i-1 ; j--) {
                    if ( nums[j]>nums[i-1] ) {
                        small = j;
                        break;

                    }
                }
//                System.out.println(small);
                swap(i-1, small, nums);
                reverse(nums, i);
                return;
            }

        }
        reverse(nums, 0);

    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length -1;
        while (left < right) {
            swap(left, right, nums);
            left++;
            right--;
        }

    }
}
