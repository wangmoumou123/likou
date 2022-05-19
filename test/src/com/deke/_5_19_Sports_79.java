package com.deke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _5_19_Sports_79 {


    /**
     * Created with IntelliJ IDEA.
     * Author: Amos
     * E-mail: amos@amoscloud.com
     * Date: 2021/12/1
     * Time: 18:07
     * Description: 100%
     */

        /*
         某学校举行运动会,学生们按编号（1、2、3.....n)进行标识,
         现需要按照身高由低到高排列，
         对身高相同的人，按体重由轻到重排列，
         对于身高体重都相同的人，维持原有的编号顺序关系。
         请输出排列后的学生编号
         输入描述：
            两个序列，每个序列由N个正整数组成，(0<n<=100)。
            第一个序列中的数值代表身高，第二个序列中的数值代表体重，
         输出描述：
            排列结果，每个数据都是原始序列中的学生编号，编号从1开始，
         实例一：
            输入:
             4
             100 100 120 130
             40 30 60 50
            输出:
             2134
         */

    static class Stu {
        int num;
        int high;
        int weight;

        public Stu(int num, int high, int weight) {
            this.num = num;
            this.high = high;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = Integer.parseInt(scanner.nextLine());
        String[] highs = scanner.nextLine().split(" ");
        String[] weights = scanner.nextLine().split(" ");
        scanner.close();

        List<Stu> stus = new LinkedList<>();
        for (int i = 0; i < nums; i++) {
            Stu stu = new Stu(i + 1, Integer.parseInt(highs[i]), Integer.parseInt(weights[i]));
            stus.add(stu);
        }
        List<Stu> collect = stus.stream().sorted((o2, o1) -> {
            if (o2.high != o1.high) {
                return o2.high - o1.high;
            } else if (o2.weight != o1.weight) {
                return o2.weight - o1.weight;
            } else {
                return o2.num - o1.num;
            }
        }).collect(Collectors.toList());
        for (Stu stu : collect) {
            System.out.print(stu.num);

        }


    }


//        static class Stu {
//            int id;
//            int h;
//            int w;
//
//            public Stu(int id, int h, int w) {
//                this.id = id;
//                this.h = h;
//                this.w = w;
//            }
//        }
//
//        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            int n = Integer.parseInt(in.nextLine());
//            String[] h = in.nextLine().split(" ");
//            String[] w = in.nextLine().split(" ");
//            in.close();
//            LinkedList<Stu> stus = new LinkedList<>();
//            for (int i = 0; i < n; i++) {
//                Stu stu = new Stu(i + 1, Integer.parseInt(h[i]), Integer.parseInt(w[i]));
//                stus.add(stu);
//            }
//            stus.sort((o1, o2) -> o1.h == o2.h ? (o1.w - o2.w) : o1.h - o2.h);
//            StringBuilder builder = new StringBuilder();
//            stus.forEach(x -> builder.append(x.id).append(" "));
//            System.out.println(builder.substring(0, builder.length() - 1));
//        }

}
