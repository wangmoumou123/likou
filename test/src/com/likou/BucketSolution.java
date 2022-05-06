package com.likou;

import javax.management.MXBean;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BucketSolution {
    public static void main(String[] args) {
        BucketSolution bucketSolution = new BucketSolution();
//        int[] data = {1, 8, 6, 2, 5, 4, 8, 3, 7,5654,8484,66,646,116,4161,7845};
        int[] data = {1, 8, 6, 2, 5, 4, 8, 25, 7};
//        int data = {0,1,2,3,4,5,6,07,8};

        System.out.println(bucketSolution.maxArea(data));
        System.out.println(bucketSolution.maxArea1(data));
        System.out.println(bucketSolution.maxArea3(data));
        System.out.println(bucketSolution.maxArea4(data));
//        System.out.println(bucketSolution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));


    }


    private int maxArea4(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            max = height[i] < height[j] ? Math.max(max, (j - i) * height[i++]) : Math.max(max, (j - i) * height[j--]);

        }
        return max;
    }


    public int maxArea3(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(res, (j - i) * height[i++]);
            } else {
                res = Math.max(res, (j - i) * height[j--]);
            }
        }
        return res;
    }


    public int maxArea(int[] height) {
        int currentMax = 0;
        int currentI = 0;
        int len = height.length;
        int sum = 0;
        int middle = 0;

        if (len < 2 || len > 100000) {
            return 0;
        }
        for (int i = 0; i < height.length; i++) {
            sum += height[i];
            int max = len - i - 1 > i ? height[i] * (len - i - 1) : height[i] * i;
            if (max > currentMax) {
                currentMax = max;
                currentI = i;
            }
        }
        middle = sum / len;
        System.out.println(middle);
        currentMax = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < 0 || height[i] > 10000) return 0;
            int max = height[i] < height[currentI] ? Math.abs(i - currentI) * height[i] : Math.abs(i - currentI) * height[currentI];
            if (max > currentMax) {
                currentMax = max;
            }
        }

        return currentMax;
    }


    public int maxArea1(int[] height) {
        int currentMax = 0;
        int len = height.length;
        if (len < 2 || len > 100000) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (height[i] < 0 || height[i] > 10000) return 0;
                if (height[j] < 0 || height[j] > 10000) return 0;
                int max = height[i] < height[j] ? (j - i) * height[i] : (j - i) * height[j];
                if (max > currentMax) {
                    currentMax = max;
                }
            }

        }

        return currentMax;

    }

}
