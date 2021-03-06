package com.likou;

import java.util.*;

public class AllSortNoRepeat_5_16 {


    public static void main(String[] args) {
        System.out.println(new AllSortNoRepeat_5_16().permute(new int[]{1, 1, 2}));
    }


    private List<List<Integer>> result = new ArrayList<>();
    private HashSet<List<Integer>> re = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) return result;
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), new boolean[length]);
//        System.out.println(re.toArray());
        return new ArrayList<>(re);

    }

    private void dfs(int[] nums, List<Integer> thisTime, boolean[] isUsed) {


        int length = nums.length;
        if (thisTime.size() == length) {
            result.add(new ArrayList<>(thisTime));
            re.add(new ArrayList<>(thisTime));
            return;
        }
        for (int i = 0; i < length; i++) {
//            if (i>0 &&nums[i]==nums[i-1]) continue;
            if (!isUsed[i]) {
                thisTime.add(nums[i]);
                isUsed[i] = true;

                dfs(nums, thisTime, isUsed);

                isUsed[i] = false;
                thisTime.remove(thisTime.size() - 1);
            }
        }

    }


    private List<List<Integer>> result1 = new ArrayList<>();

    public List<List<Integer>> permute3(int[] nums) {
        if (nums == null || nums.length == 0) return result1;
        Arrays.sort(nums);
        dfs2(nums, new ArrayList<>(), new boolean[nums.length]);
        return result1;

    }

    private void dfs2(int[] nums, List<Integer> thisTime, boolean[] isUsed) {


        int length = nums.length;
        if (thisTime.size() == length) {
            result1.add(new ArrayList<>(thisTime));
            return;
        }
        for (int i = 0; i < length; i++) {
//            if (i>0 &&nums[i]==nums[i-1]) continue;
            if (!isUsed[i]) {
                thisTime.add(nums[i]);
                isUsed[i] = true;

                dfs(nums, thisTime, isUsed);

                isUsed[i] = false;
                thisTime.remove(thisTime.size() - 1);
            }
        }

    }

//*/5 *   * * *   root    service  epapermanager restart

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
        // ?????????????????????
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // ??????????????????
            Collections.swap(output, first, i);
            // ???????????????????????????
            backtrack(n, output, res, first + 1);
            // ????????????
            Collections.swap(output, first, i);
        }
    }

}
