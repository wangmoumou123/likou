package com.deke;

import java.util.Scanner;

public class _5_20_CartParting_2_53 {

    /**
     * Created with IntelliJ IDEA.
     * Author: Amos
     * E-mail: amos@amoscloud.com
     * Date: 2021/5/7
     * Time: 19:57
     * Description: 90%
     */
        /*
           停车场有一横排车位0代表没有停车,1代表有车.
           至少停了一辆车在车位上,也至少有一个空位没有停车.
           为防止刮蹭,需为停车人找到一个车位
           使得停车人的车最近的车辆的距离是最大的
           返回此时的最大距离

           输入描述:
           1. 一个用半角逗号分割的停车标识字符串,停车标识为0或1,
            0为空位,1为已停车
           2. 停车位最多有100个

           输出描述
           1. 输出一个整数记录最大距离

           示例一:
           输入
           1,0,0,0,0,1,0,0,1,0,1

            0,0,1,1,0,0
           输出
           2

           说明
           当车停在第三个位置上时,离其最近的车距离为2(1~3)
           当车停在第四个位置上时,离其最近的车距离为2(4~6)
           其他位置距离为1
           因此最大距离为2
         */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                continue;
            }
            max = Math.max(max,calcDis(arr,i));
        }
        System.out.println(max);
    }
    //1,0,0,0,1,0,0,1
    private static int calcDis(int[] arr,int idx){
        int left = 0;
        int right = 0;
        for (int i = 0; i < idx; i++) {
            if (arr[i] == 1){
                left = i;
            }
        }
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] == 1){
                right =i;
                break;
            }
        }
        return Math.min(idx - left,right - idx);
    }
    //todo


}
