package com.deke;

import java.util.Scanner;

public class _5_18_GouGuShu {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            solution(n, m);
        }
    }

    private static void solution(int n, int m) {
        int count = 0;
        for (int a = n; a < m - 1; a++) {
            for (int b = a + 1; b < m; b++) {
                for (int c = b + 1; c < m + 1; c++) {
                    if (relativelyPrime(a, b) && relativelyPrime(b, c) && relativelyPrime(a, c) && a * a + b * b == c * c) {
                        count++;
                        System.out.printf("%d %d %d\n", a, b, c);
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println("Na");
        }
    }

    private static boolean relativelyPrime(int x, int y) {
        int min = Math.min(x, y);
        double sqrt = Math.sqrt(min);
        for (int i = 2; i < sqrt; i++) {
            if (x % i == 0 && y % i == 0) {
                return false;
            }
        }
        return true;
    }

}
