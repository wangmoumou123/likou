package com.likou;

import java.lang.ref.SoftReference;

public class FindMaxPre {
    public static void main(String[] args) {
        FindMaxPre findMaxPre = new FindMaxPre();
        System.out.println(findMaxPre.longestCommonPrefix(new String[]{"dasd", "dadc", "daaas"}));
    }

    private String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        int length = strings[0].length();
        int count = strings.length;
        for (int i = 0; i < length; i++) {
            char c = strings[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strings[j].length() || strings[j].charAt(i) != c) {
                    return strings[0].substring(0, i);
                }
            }
        }
        return strings[0];


    }

    public String longestCommonPrefix1(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


}



