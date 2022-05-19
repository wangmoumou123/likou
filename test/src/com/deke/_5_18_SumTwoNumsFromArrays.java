package com.deke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _5_18_SumTwoNumsFromArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = parse(scanner.nextLine());
        int[] b = parse(scanner.nextLine());
        int c = scanner.nextInt();

//        System.out.println(new _5_18_SumTwoNumsFromArrays().Sum(new int[]{1, 23, 4, 5, 6}, new int[]{7, 5, 3, 1, 6}, 3));
        System.out.println(new _5_18_SumTwoNumsFromArrays().Sum(a, b, c));
        solution(a, b, c);


    }

    private static int[] parse(String s) {
        String[] s1 = s.split(" ");
        int[] ints = new int[s1.length];

        for (int i = 0; i < s1.length; i++) {
            ints[i] = Integer.parseInt(s1[i]);

        }
        return ints;
    }

    private int Sum(int[] a, int[] b, int k) {
        int result = 0;
        if (a.length != b.length) {
            return 0;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int i1 : b) {
                nums.add(a[i] + i1);
            }


        }
        nums.sort(Integer::compareTo);
        for (int i = 0; i < k; i++) {
            result += nums.get(i);
        }
        return result;
    }


    private static void solution(int[] arr1, int[] arr2, int k) {
        int initialCapacity = arr1.length * arr1.length;
        List<Integer> sums = new ArrayList<>(initialCapacity);
        for (int x : arr1) {
            for (int y : arr2) {
                sums.add(x + y);
            }
        }
        sums.sort(Integer::compareTo);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += sums.get(i);
        }
        System.out.println(res);
    }

    private static int[] parseArray(String line) {
        String[] split = line.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }
}


