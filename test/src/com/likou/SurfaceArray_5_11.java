package com.likou;

import javax.xml.transform.Result;

public class SurfaceArray_5_11 {
    public static void main(String[] args) {
        System.out.println(new SurfaceArray_5_11().countAndSay(5));
    }

    public String countAndSay2(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }

        return str;
    }


    public String countAndSay(int n) {
        return digui(n);
    }

    private String digui(int n) {
        if (n > 1) {
            String result = digui(n - 1);
            int length = result.length();
            if (length == 1) {
                return "1" + result;
            } else {
                int count = 1;
                StringBuilder newResult = new StringBuilder();
                for (int i = 1; i < length; i++) {
                    if (result.charAt(i) == result.charAt(i - 1)) {
                        count++;
                    } else {
                        newResult.append(count);
                        newResult.append(result.charAt(i - 1));
                        count = 1;
                    }
                }
                newResult.append(count);
                newResult.append(result.charAt(length - 1));
                return newResult.toString();
            }
        } else {
            return "1";
        }

    }

}