package com.likou;

public class DivideSolution_5_8 {
    public static void main(String[] args) {
        System.out.println(new DivideSolution_5_8().divide(-10, -5));
    }

    public int divide(int dividend, int divisor) {
        int result = 0;


        if (dividend > 0) {
            while (dividend > 0) {
                dividend -= divisor > 0 ? divisor : -divisor;
                result += 1;
            }
            return divisor > 0 ? result : -result;

        } else if (dividend < 0) {
            while (dividend < 0) {
                dividend += divisor > 0 ? divisor : -divisor;
                result += 1;
            }
            return divisor < 0 ? result : -result;

        }


        return 0;


    }
}
