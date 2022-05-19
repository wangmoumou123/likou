package com.deke;

import java.util.Scanner;

public class _5_18_GpuCounts {
    /**
     * Created with IntelliJ IDEA.
     * Author: Amos
     * E-mail: amos@amoscloud.com
     * Date: 2020/11/7
     * Time: 14:01
     * Description:
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int num = Integer.parseInt(scanner.nextLine());
            int len = Integer.parseInt(scanner.nextLine());
            int[] datas = new int[len];
            for (int i = 0; i < len; i++) {
                datas[i] = scanner.nextInt();
            }
            solution(num, datas);
            solution2(num, datas);


        }
    }

    private static void solution2(int num,  int[] datas) {
        int time = 0;
        int rem = 0;
        for (int i = 0; i < datas.length; i++) {
            if (rem + datas[i] > num) {
                rem = rem + datas[i] - num;

            } else {
                rem = 0;
            }
            time++;
        }
        time += rem / num;
        if (rem % num != 0) {
            time++;
        }


        System.out.println(time);
    }


    private static void solution(int n, int[] jobCount) {
        int time = 0;
        int remaining = 0;
        for (int count : jobCount) {
            if (count + remaining > n) {
                remaining = count + remaining - n;
            } else {
                remaining = 0;
            }
            time++;
        }
        time += remaining / n;
        if (remaining % n > 0) {
            time++;
        }
        System.out.println(time);
    }

}
