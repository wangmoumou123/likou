package com.deke;

import java.util.Arrays;
import java.util.Scanner;

public class _5_19_cart_compute {


    /**
     * Created with IntelliJ IDEA.
     * Author: Amos
     * E-mail: amos@amoscloud.com
     * Date: 2021/12/22
     * Time: 9:07
     * Description:  95%
     */
        /*
        小组中每位都有一张卡片
        卡片是6位以内的正整数
        将卡片连起来可以组成多种数字
        计算组成的最大数字

        输入描述：
          ","分割的多个正整数字符串
          不需要考虑非数字异常情况
          小组种最多25个人

         输出描述：
           最大数字字符串

         示例一
           输入
            22,221
           输出
            22221

          示例二
            输入
              4589 101 46425 9999
            输出
              9999458941425101
         */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String q = s;
        String w = "1 22 4446 44 5";
        System.out.println(s.compareTo(q));
        StringBuilder result = new StringBuilder();
        Arrays.stream(w.split(" ")).sorted((s1, s2) -> {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            int s1L = chars1.length;
            int s2L = chars2.length;
            if (s1L == s2L) {
                return s2.compareTo(s1);
            }
            int min = Math.min(s1L, s2L);
            for (int i = 0; i < min; i++) {
                if (chars1[i] != chars2[i]) {
                    return chars2[i] - chars1[i];
                }

            }
            System.out.println(chars1[0]+""+chars2[0]);
//            return chars2[0] - chars1[0];
            if (s1L > s2L) {
                int j=0;
                while (min<s1L&& chars1[min]== chars1[j]){
                    min++; j++;
                }
                return chars1[j] - chars1[min];
            } else {
                int j=0;
                while (min<s2L&& chars2[min]== chars2[j]){
                    min++; j++;
                }
                return chars2[min] - chars2[j];
            }

        }).forEach(result::append);
        System.out.println(result);
//        main1(w);

//        deal(s);
    }

    private static void deal(String s) {
        String[] split = s.split(",");

    }

    public static void main1(String nums) {


        StringBuilder builder = new StringBuilder();

        Arrays.stream(nums.split(" "))
                .sorted((s1, s2) -> {
                    char[] v1 = s1.toCharArray();
                    char[] v2 = s2.toCharArray();
                    int len1 = v1.length;
                    int len2 = v2.length;

                    if (len1 == len2) {
                        return s2.compareTo(s1);
                    }

                    int min = Math.min(len1, len2);
                    for (int i = 0; i < min; i++) {
                        char c1 = v1[i];
                        char c2 = v2[i];
                        if (c1 != c2) {
                            return c2 - c1;
                        }
                    }

                    if (len1 > len2) {
                        return v1[0] - v1[min];
                    } else {
                        return v2[min] - v2[0];
                    }
                })
                .forEach(builder::append);

        System.out.println(builder);

    }

}
