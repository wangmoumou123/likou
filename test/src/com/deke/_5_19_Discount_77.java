package com.deke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _5_19_Discount_77 {


    /**
     * Created with IntelliJ IDEA.
     * Author: Amos
     * E-mail: amos@amoscloud.com
     * Date: 2021/11/2
     * Time: 16:48
     * Description:
     */
  /*
  双十一众多商品进行打折销售
  小明想购买自己心仪的一些物品
  但由于购买资金限制
  所以他决定从众多心仪商品中购买三件
  而且想尽可能得花完资金
  现在请你设计一个程序 计算小明尽可能花费的最大资金数

  输入描述：
    输入第一行为一维整型数组m
    数组长度小于100
    数组元素记录单个商品的价格
    单个商品加个小于1000

    输入第二行为购买资金的额度r
    r<100000

  输出描述：
     输出为满足上述条件的最大花费额度

   注意：如果不存在满足上述条件的商品请返回-1

  示例：
     输入
      23,26,36,27
      78
     输出
      76
     说明：
      金额23、26、27得到76而且最接近且小于输入金额78

   示例：
       输入
       23,30,40
       26
       输出
        -1
       说明
       因为输入的商品无法满足3件之和小于26
       故返回-1

   输入格式正确无需考虑输入错误情况


   */


    private static final List<List<Integer>> combines = new ArrayList<>();
    private static final List<Integer> combine = new ArrayList<>(3);
    private static int res = -1;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String m = scanner.nextLine();
            int r = scanner.nextInt();
            solution(m, r);
        }
    }

    private static void solution(String m, int r) {
        String[] goodsPricesString = m.split(",");
        int[] goodsPrices = new int[goodsPricesString.length];
        for (int i = 0; i < goodsPricesString.length; i++) {
            goodsPrices[i] = Integer.parseInt(goodsPricesString[i]);
        }
        Arrays.sort(goodsPrices);
        if (goodsPrices.length < 3 || goodsPrices[0] + goodsPrices[1] + goodsPrices[2] > r) {
            System.out.println(-1);
            return;
        }
        takeGoods(goodsPrices, 0);
        combines.stream().map(list -> sum(list)).sorted(Integer::compareTo).forEach(sum -> {
            if (sum > res && sum <= r) {
                res = sum;
            }
        });
        System.out.println(combines);
        System.out.println(res);
    }

    private static void takeGoods(int[] goodsPrices, int start) {
        if (combine.size() == 3) {
            combines.add(new ArrayList<>(combine));
            return;
        }
        for (int i = start; i < goodsPrices.length; i++) {
            combine.add(goodsPrices[i]);
            takeGoods(goodsPrices, i + 1);
            combine.remove(combine.size() - 1);
        }
    }

    private static Integer sum(List<Integer> prices) {
        int sum = 0;
        for (Integer i : prices) {
            sum += i;
        }
        return sum;
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] goods = scanner.nextLine().trim().split(",");
//        int moneys = Integer.parseInt(scanner.nextLine().trim());
//        scanner.close();
//        int[] prices = new int[goods.length];
//        for (int i = 0; i < goods.length; i++) {
//            prices[i] = Integer.parseInt(goods[i]);
//        }
//        Arrays.sort(prices);
//
//
//
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] goods = scanner.nextLine().trim().split(",");
//        int moneys = Integer.parseInt(scanner.nextLine().trim());
//        scanner.close();
//        int[] prices = new int[goods.length];
//        for (int i = 0; i < goods.length; i++) {
//            prices[i] = Integer.parseInt(goods[i]);
//        }
//        Arrays.sort(prices);
//        List<Integer> usedList = new ArrayList<>();
//        int used = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int i1 = 0; i1 < prices.length; i1++) {
//                for (int i2 = 0; i2 < prices.length; i2++) {
//                    used = prices[i] + prices[i1] + prices[i2];
//                    if (i != i1 && i1 != i2 && i != i2 && used <= moneys) {
//                        usedList.add(used);
//                        if (used == moneys) {
//                            System.out.println(prices[i] + " " + prices[i1] + " " + prices[i2]);
//                        }
//                    }
//                }
//            }
//        }
//
//        usedList.sort(Integer::compareTo);
//        if (usedList.size() != 0) {
//            System.out.println(usedList.get(usedList.size() - 1));
//        }
//        else System.out.println(-1);
//
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        List<Integer> m = Arrays.stream(in.nextLine().split(","))
//                .map(Integer::parseInt)
//                .sorted()
//                .collect(Collectors.toList());
//        int r = Integer.parseInt(in.nextLine());
//        in.close();
//
//        int max = -1;
//        for (int i = 0; i < m.size() - 2; i++) {
//            for (int j = 0; j < m.size() - 1; j++) {
//                for (int k = 0; k < m.size(); k++) {
//                    if (i != j && j != k && i != k) {
//                        int sum = m.get(i) + m.get(j) + m.get(k);
//                        if (sum <= r && sum > max) {
//                            max = sum;
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(max);
//    }

}
