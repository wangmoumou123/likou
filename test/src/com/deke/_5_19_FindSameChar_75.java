package com.deke;

import java.util.Arrays;
import java.util.Scanner;

public class _5_19_FindSameChar_75 {


    /**
     * Created with IntelliJ IDEA.
     * Author: Amos
     * E-mail: amos@amoscloud.com
     * Date: 2021/10/27
     * Time: 17:11
     * Description:
     */
  /*
  输入一串字符串
  字符串长度不超过100
  查找字符串中相同字符连续出现的最大次数

  输入描述
    输入只有一行，包含一个长度不超过100的字符串

  输出描述
    输出只有一行，输出相同字符串连续出现的最大次数

   说明：
     输出

   示例1：
     输入
       hello
     输出
       2

    示例2：
      输入
       word
      输出
       1

     示例3：
      输入
        aaabbc
       输出
        3

    字符串区分大小写
   */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().trim().toCharArray();
        scanner.close();

        int result = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i - 1]) {
                int thisResult = 1;
                int thisValue = chars[i - 1];
                while (i < chars.length && chars[i] == thisValue) {
                    thisResult++;
                    i++;
                }
                if (thisResult > result) result=thisResult;
            }

        }
        System.out.println(result);


    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        in.close();
//
//        char[] chars = str.toCharArray();
//
//        int maxLen = 0;
//
//        for (int i = 0; i < chars.length; i++) {
//            int index = i;
//            int len = 1;
//            while (index + 1 < chars.length && chars[index + 1] == chars[index]) {
//                len++;
//                index++;
//            }
//            if (len > maxLen) maxLen = len;
//        }
//
//        System.out.println(maxLen);
//
//    }


}
