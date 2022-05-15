package com.likou;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main0(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int i = 0;
        while (i < nums) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
            i++;
        }
    }


    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int nums = sc.nextInt();
            if (nums == 0) return;
            int i = 0, result = 0;
            while (i < nums) {
                result += sc.nextInt();
                i++;
            }
            System.out.println(result);
        }
    }


    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNext()) {
                int nums = sc.nextInt();
                int i = 0, result = 0;
                while (i < nums) {
                    result += sc.nextInt();
                    i++;
                }
                System.out.println(result);
            } else {
                break;
            }
        }
    }


    public static void main5(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {

        }
        while (sc.hasNext()) {
            int result = 0;
            while (sc.hasNextInt()) {
                result += sc.nextInt();
            }
            System.out.println(result);
        }


    }

    public static void main6(String[] args) {
        Scanner sc = new Scanner(System.in);
        int j = 0, nums = Integer.parseInt(sc.nextLine());
        List<String> result = new ArrayList<>();
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        Arrays.sort(s1);
        for (int i = 0; i < nums; i++) {
            System.out.print(s1[i] + " ");

        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long result = 0L;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] nums = str.split(" ");
            for (int i = 0; i < nums.length; i++) {
                result += Long.parseLong(nums[i]);
            }
            System.out.println(result);
        }


    }

}


