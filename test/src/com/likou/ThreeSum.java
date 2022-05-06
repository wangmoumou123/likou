package com.likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSumClosest(new int[]{-3, 0, 2, 1}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int finalSum = nums[0] + nums[1] + nums[2];
        int minDisc = Math.abs(nums[0] + nums[1] + nums[2] - target);
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    int thisDisc = target - sum;
                    if (thisDisc < minDisc) {
                        finalSum = sum;
                        minDisc = thisDisc;
                    }
                    left++;
                } else if (sum > target) {
                    int thisDisc = sum - target;
                    if (thisDisc < minDisc) {
                        finalSum = sum;
                        minDisc = thisDisc;
                    }
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return finalSum;
    }

    public int threeSumClosest1(int[] nums, int target) {

        int result = Math.abs(target - (nums[0] + nums[1] + nums[2]));
        int real = target - (nums[0] + nums[1] + nums[2]);
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int this_real = target - nums[i] - nums[left] - nums[right];
                int thisResult = Math.abs(this_real);
                if (thisResult < result) {
                    result = thisResult;
                    real = this_real;
                }
                right--;
                if (right == left) {
                    left++;
                    right = len - 1;
                }

            }
        }

        return target - real;
//        ArrayList<Integer> ints = new ArrayList<>();
//        List<String> chars = new ArrayList<>();
////        ints.stream().collect()
//        Stream<Double> stream3 = Stream.generate(Math::random).limit(5);
//        stream3.forEach(System.out::println);
//        System.out.println(Math.random());
//
//        Pattern pattern = Pattern.compile(",");
//        Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");
//        stringStream.forEach(chars::add);
////        stringStream.forEach(chars::add);
////        stringStream.forEach(chars::add);
//        System.out.println(chars);


    }
}
