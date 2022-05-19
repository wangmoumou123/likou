package com.deke;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _5_19_CarParting_74 {


    /**
     * Created with IntelliJ IDEA.
     * Author: Amos
     * E-mail: amos@amoscloud.com
     * Date: 2021/10/27
     * Time: 14:45
     * Description:
     */
  /*
    特定大小的停车场 数组cars表示
    其中1表示有车  0表示没车
    车辆大小不一，小车占一个车位(长度1)
    货车占两个车位(长度2)
    卡车占三个车位(长度3)
    统计停车场最少可以停多少辆车
    返回具体的数目

    输入描述：
      整型字符串数组cars
      其中1表示有车0表示没车
      数组长度<1000

    输出描述：
      整型数字字符串
      表示最少停车数

    示例1：
      输入
        1,0,1
      输出
        2
      说明：
        一个小车占第一个车位
        第二个车位空，一个小车占第三个车位
        最少有两辆车

     示例2:
       输入：
         1,1,1,0,0,1,1,1,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,0,1
       输出：
         3
       说明：
         一个货车占第1,2个车位
         第3,4个车位空
         一个卡车占第5,6,7个车位
         第8个车位空
         一个小车占第9个车位
         最少3俩个车
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> partings = Arrays.stream(scanner.nextLine().trim().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int result = 0;
        int connects = 1;
        for (int i = 0; i < partings.size(); i++) {
            int thisTime = 0;
            if (partings.get(i) == 1) {
                while (i < partings.size() && partings.get(i) == 1) {
                    thisTime++;
                    if (thisTime==3){
                        break;
                    }
                    i++;
                }
                result++;
            }

        }
        System.out.println(result);
    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String cars = in.nextLine()
//                .replaceAll(",", "");
//        in.close();
//
//        int count = 0;
//
//        String[] split = cars.split("[0]+");
//        for (String car : split) {
//            int len = car.length();
//            while (len > 3) {
//                count++;
//                len -= 3;
//            }
//            if (len != 0) {
//                count++;
//            }
//        }
//
//        System.out.println(count);
//    }

}
