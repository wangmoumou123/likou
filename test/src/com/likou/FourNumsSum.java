package com.likou;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumsSum {
    public static void main(String[] args) {
//        System.out.println(new FourNumsSum().fourSum(new int[]{-5, -4, -3, -2, 1, 3, 3, 5}, -11));
        System.out.println(new FourNumsSum().fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;

        Arrays.sort(nums);
        for (int i = 0; i < length - 3; i++) {
            if ((target >= 0 && nums[i] > target) || (target < 0 && nums[i] > 0)) return result;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if ((target >= 0 && nums[i] + nums[j] > target) || (target < 0 && nums[i] + nums[j] > 0)) break;
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int thisTime = nums[i] + nums[j] + nums[left] + nums[right];
                    if (left > j + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    if (right < length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    if (thisTime < target) left++;
                    else if (thisTime > target) right--;
                    else {
                        ArrayList<Integer> thisResult = new ArrayList<>();
                        thisResult.add(nums[i]);
                        thisResult.add(nums[j]);
                        thisResult.add(nums[left]);
                        thisResult.add(nums[right]);
                        result.add(thisResult);
                        left++;
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
