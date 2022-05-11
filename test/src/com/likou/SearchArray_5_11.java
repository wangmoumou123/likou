package com.likou;

import java.util.Arrays;

public class SearchArray_5_11 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchArray_5_11().searchRange(new int[]{2,2}, 2)));
    }

    public int[] searchRange(int[] nums, int target) {
//        List<Integer> result = new ArrayList<>();
        int[] result = {-1, -1};
        int length = nums.length;
        if (length == 0) return result;
        if (length == 1) return target == nums[0] ? new int[]{0, 0} : result;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                int i = mid;
                while (i>=0 &&nums[i] == target) {

                    i--;
                }
                result[0] = i + 1;
                i = mid;
                while (i<=length-1 &&nums[i] == target ) {

                    i++;
                }
                result[1] = i - 1;
                break;

            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return result;
    }

}
