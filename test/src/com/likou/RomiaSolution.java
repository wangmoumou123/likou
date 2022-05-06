package com.likou;

import java.awt.*;

public class RomiaSolution {

    public static void main(String[] args) {
        System.out.println(new RomiaSolution().intToRoman(60));
        System.out.println(new RomiaSolution().intToRoman2(60));
    }

    public String intToRoman2(int num) {
        StringBuffer sb = new StringBuffer();
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                num -= val[i];
                sb.append(symbols[i]);
            }
            if (num== 0){
                break;
            }
        }

        return sb.toString();
    }

    public String intToRoman(int num) {
        if (num > 3999) {
            return null;
        }
        int thou = num / 1000;
        int hun = num / 100 - thou * 10;
        int ten = num / 10 - thou * 100 - hun * 10;
        int res = num % 10;
        String finalStr = "";

        finalStr = addChar(thou, finalStr, "M");
        finalStr = cal(finalStr, hun, new String[]{"M", "D", "C"});
        finalStr = cal(finalStr, ten, new String[]{"C", "L", "X"});
        finalStr = cal(finalStr, res, new String[]{"X", "V", "I"});
        return finalStr;
    }

    private String cal(String finalStr, int hun, String[] strings) {
        if (hun == 0) {
            return finalStr;
        }

        if (hun < 4) {
            finalStr = addChar(hun, finalStr, strings[2]);

        } else if (hun == 4) {
            finalStr += strings[2];
            finalStr += strings[1];
        } else if (hun == 5) {
            finalStr += strings[1];
        } else if (hun < 9) {
            finalStr += strings[1];
            finalStr = addChar(hun - 5, finalStr, strings[2]);

        } else if (hun == 9) {
            finalStr += strings[2];
            finalStr += strings[0];
        }
        return finalStr;


    }

    private String addChar(int thou, String finalStr, String m) {
        int i = 0;
        while (i < thou) {
            finalStr += m;
            i++;
        }
        return finalStr;
    }


}


