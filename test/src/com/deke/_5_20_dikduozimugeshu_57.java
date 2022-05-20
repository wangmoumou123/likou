package com.deke;

import java.util.*;

public class _5_20_dikduozimugeshu_57 {


    /**
     * Created with IntelliJ IDEA.
     * Author: Amos
     * E-mail: amos@amoscloud.com
     * Date: 2021/5/13
     * Time: 17:44
     * Description:
     */

/*
    给定一个字符串
    只包含大写字母
    求在包含同一字母的子串中
    长度第K长的子串
    相同字母只取最长的子串

    输入
     第一行 一个子串 1<len<=100
     只包含大写字母
     第二行为k的值

     输出
     输出连续出现次数第k多的字母的次数

     例子：
     输入
             AABAAA
             2
     输出
             1
       同一字母连续出现最多的A 3次
       第二多2次  但A出现连续3次

    输入

    AAAAHHHBBCDHHHH
    3

    输出
    2

//如果子串中只包含同一字母的子串数小于k

则输出-1

 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int k = Integer.parseInt(scanner.nextLine().trim());
        scanner.close();
        Map<Character, Integer> data = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char thisTime = s.charAt(i);
            int thisCharNums = 1;
            while (i < s.length() - 1 && thisTime == s.charAt(i + 1)) {
                thisCharNums++;
                i++;
            }
            int n = data.getOrDefault(thisTime, thisCharNums);
            data.put(thisTime, Math.max(thisCharNums, n));
        }
        int[] ints = data.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue() != o2.getValue()) {
                return o2.getValue() - o1.getValue();
            } else {
                return o1.getKey() - o2.getKey();
            }
        }).mapToInt(Map.Entry::getValue).toArray();

        System.out.println(k < ints.length ? ints[k - 1] : -1);
        main1(k, s);
    }
    public static void main1(int k, String line) {


        HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = line.toCharArray();
        if (chars.length == 0) {
            System.out.println(-1);
            return;
        }

        char cur = chars[0];
        int count = 1;
        map.put(cur, count);

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == cur) count++;
            else {
                cur = c;
                count = 1;
            }
            map.put(cur, map.containsKey(cur) ?
                    map.get(cur) > count ? map.get(cur) : count :
                    count);
        }

        ArrayList<String> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(entry.getKey() + "-" + entry.getValue());
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.split("-")[1].compareTo(o1.split("-")[1]);
            }
        });

        if (k > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(k - 1).split("-")[1]);
        }


    }
    //todo
}
