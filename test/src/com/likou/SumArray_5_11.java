package com.likou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumArray_5_11 {
    public static void main(String[] args) {
        System.out.println(new SumArray_5_11().combinationSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        System.out.println(new SumArray_5_11().combinationSum2(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(candidates);
        List<Integer> thisTime = new ArrayList<>();
        myDfs(candidates, target, result, thisTime, 0);


        return result;

    }

    private void myDfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> thisTime, int index) {
        if (index == candidates.length) return;
        if (target == 0) {
            result.add(new ArrayList<>(thisTime));
            return;
        }
        myDfs(candidates, target, result, thisTime, index + 1);
        if (target - candidates[index] >= 0) {
            thisTime.add(candidates[index]);
            myDfs(candidates, target-candidates[index], result, thisTime, index);
            thisTime.remove(thisTime.size()-1);
        }


    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

}
