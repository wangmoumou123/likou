package com.likou;

import java.util.ArrayList;
import java.util.List;

public class BracketUseful_5_8 {

    public static void main(String[] args) {
        System.out.println(new BracketUseful_5_8().generateParenthesis(2));
    }


    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        String thisTime = "";

        deal(result, n, n, thisTime);


        return result;


    }

    private void deal(List<String> result, int left, int right, String thisTime) {

        if (left == 0 && right == 0) {
            result.add(thisTime);
            return;

        }
        if (left > right) return;

        if (left > 0) {
            deal(result, left - 1, right, thisTime + "(");
        }

        if (right > 0) {
            deal(result, left, right - 1, thisTime + ")");
        }

    }


    // 做减法

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }


}
