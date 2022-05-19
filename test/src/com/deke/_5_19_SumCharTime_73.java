package com.deke;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _5_19_SumCharTime_73 {


    /**
     * Created with IntelliJ IDEA.
     * Author: Amos
     * E-mail: amos@amoscloud.com
     * Date: 2021/9/7
     * Time: 15:30
     * Description: 85%
     */
        /*

        给出一个只包含字母的字符串,
        不包含空格,统计字符串中各个子字母(区分大小写)出现的次数,
        并按照字母出现次数从大到小的顺序输出各个字母及其出现次数
        如果次数相同,按照自然顺序排序,且小写字母在大写字母之前

        输入描述:
          输入一行仅包含字母的字符串

        输出描述:
          按照字母出现次数从大到小的顺序输出各个字母和字母次数,
          用英文分号分割,
          注意末尾的分号
          字母和次数中间用英文冒号分隔

        示例:
            输入: xyxyXX
            输出:x:2;y:2;X:2;
        说明:每个字符出现的次数为2 故x排在y之前
        而小写字母x在大写X之前

        示例2:
            输入:
             abababb
            输出:
                b:4;a:3
            说明:b的出现个数比a多 故排在a前
         */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] datas = scanner.nextLine().trim().toCharArray();
        scanner.close();
        Arrays.sort(datas);
        Map<Character, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < datas.length; i++) {
            Integer orDefault = resultMap.getOrDefault(datas[i], 0);
            resultMap.put(datas[i], orDefault + 1);
        }
//        System.out.println(resultMap);
        StringBuilder resu = new StringBuilder();
        print( resultMap.entrySet().stream().filter(o->o.getKey()>'Z').collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)), resu);
        print( resultMap.entrySet().stream().filter(o->o.getKey()<='Z').collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)), resu);
//        System.out.println(resultMap.entrySet().stream().filter(o -> o.getKey() > 'Z').map(o->o.getKey()).collect(Collectors.toList()));

        if (resu.length()>0){
            System.out.println(resu.substring(0, resu.length()-1));
        }
//        main1(datas);

    }

    private static void print(Map<Character, Integer> resultMap, StringBuilder resu) {
        resultMap.entrySet().stream().sorted((o1, o2) -> {
            if (o2.getValue() != o1.getValue()) {
                return o2.getValue() - o1.getValue();
            } else{
                return o1.getKey()- o2.getKey();
            }
        }).forEach(o->{
            resu.append(o.getKey()).append(":").append(o.getValue()).append(",");
        });
    }
    public static void main1(char[] chars) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        print1(map.entrySet().stream().filter(e -> e.getKey() >= 'a'));
        print1(map.entrySet().stream().filter(e -> e.getKey() <= 'Z'));

    }

    private static void print1(Stream<Map.Entry<Character, Integer>> stream) {
        List<Map.Entry<Character, Integer>> list = stream
                .sorted((o1, o2) -> {
                    int v1 = o1.getValue();
                    char k1 = o1.getKey();
                    int v2 = o2.getValue();
                    char k2 = o2.getKey();
                    if (v1 != v2) {
                        return v2 - v1;
                    } else {
                        return k1 - k2;
                    }
                }).collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            builder.append(entry.getKey()).append(":")
                    .append(entry.getValue()).append(";");
        }

        System.out.print(builder);
    }


}
