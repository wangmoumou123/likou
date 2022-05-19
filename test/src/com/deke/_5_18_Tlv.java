package com.deke;

import java.util.Scanner;

public class _5_18_Tlv {
    /**
     * Created with IntelliJ IDEA.
     * Author: Amos
     * E-mail: amos@amoscloud.com
     * Date: 2020/12/15
     * Time: 23:51
     * Description:
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String tag = scanner.nextLine();
            String source = scanner.nextLine();
            solution(tag, source);
        }
    }

    private static void solution(String tag, String source) {
        int p = 0;
        while (p < source.length()) {
            String curTag = source.substring(p, p + 2);
            String lenHEX = source.substring(p + 6, p + 8) + source.substring(p + 3, p + 5);
            int lenDEC = Integer.parseInt(lenHEX, 16);
            System.out.println(lenHEX);
            if (tag.equals(curTag)) {
                String value = source.substring(p + 9, p + 9 + lenDEC * 3);
                System.out.println(value);
            }
            p += 9 + lenDEC * 3;
        }
    }
}

