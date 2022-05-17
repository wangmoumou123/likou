package com.likou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSort_5_16 {

    public static void main(String[] args) {
        System.out.println(new AllSort_5_16().permute(new int[]{1, 2, 6, 4}));
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;


        if (nums == null || length == 0) return result;
        dfs(nums, new ArrayList<>(), new boolean[length]);
        return result;

    }

    private void dfs(int[] nums, List<Integer> thisTime, boolean[] isUsed) {
        int length = nums.length;
        if (thisTime.size() == length) {
            result.add(new ArrayList<>(thisTime));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!isUsed[i]){
                thisTime.add(nums[i]);
                isUsed[i] = true;

                dfs(nums, thisTime, isUsed);

                isUsed[i]= false;
                thisTime.remove(thisTime.size()-1);
            }
        }

    }


    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

}
