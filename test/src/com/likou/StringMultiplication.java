package com.likou;

import com.sun.xml.internal.fastinfoset.util.CharArray;

public class StringMultiplication {
    public static void main(String[] args) {
        System.out.println(new StringMultiplication().multiply("12", "11"));
        System.out.println(new StringMultiplication().multiply2("12", "11"));
//        System.out.println(new StringMultiplication().addStrings("1233", "11"));
//        System.out.println(new StringMultiplication().addStrings1("1233", "11"));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int num1Length = num1.length();
        int num2Length = num2.length();

        String result = "0";
        for (int i = num1Length - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            StringBuilder thisTime = new StringBuilder();
            for (int k = num1Length - 1; k > i; k--) {
                thisTime.append(0);
            }
            int add = 0;
            for (int j = num2Length - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int thisResult = x * y + add;
                add = thisResult / 10;
                thisTime.append(thisResult % 10);
            }
            if (add != 0) thisTime.append(add % 10);
            result = addStrings1(result, thisTime.reverse().toString());
        }


        return result;
    }

    private String addStrings1(String num1, String num2) {
        int n1 = num1.length() - 1, n2 = num2.length() - 1, add = 0;
        StringBuilder result = new StringBuilder();
        while (n1 >= 0 || n2 >= 0 || add != 0) {
            int x = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
            int y = n2 >= 0 ? num2.charAt(n2) - '0' : 0;
            int thisResult = x + y + add;
            result.append(thisResult % 10);
            add = thisResult / 10;
            n1--;
            n2--;
        }
        return result.reverse().toString();
    }


    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder curr = new StringBuilder();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }

        return ans;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();

    }


    /**
     * 计算形式
     * num1
     * x num2
     * ------
     * result
     */
    public String multiply3(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings2(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    public String addStrings2(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }


}
