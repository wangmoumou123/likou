package com.likou;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SumArrayOneTime_5_12 {
    public static void main(String[] args) {
        System.out.println(new SumArrayOneTime_5_12().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(new SumArrayOneTime_5_12().combinationSum3(new int[]{10,1,2,7,6,1,5}, 8));
//        System.out.println(Arrays.toString(new int[]{1,3}));
    }

    private List<List<Integer>> result = new ArrayList<>();
    private int[] candidates;
    private int target;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        backTracking(new ArrayList<>(), 0, 0);
        return result;


    }


    private void backTracking(List<Integer> path, int thisPath, int start) {
        if (target == thisPath) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (thisPath + candidates[i] <= target) {
                path.add(candidates[i]);
                backTracking(path, thisPath + candidates[i], i + 1);
                path.remove(path.size() - 1);
            }
            while (i != candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }

        }


    }


    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return ans;
    }

    public void dfs(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }

}
