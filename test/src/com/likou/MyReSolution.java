package com.likou;

public class MyReSolution {

    public static void main(String[] args) {

        MyReSolution myReSolution = new MyReSolution();
        System.out.println(myReSolution.Solution("adasd", "sas.*"));
    }

    private boolean Solution(String s, String p) {
        int SLength = s.length();
        int PLength = p.length();
        boolean[][] flag = new boolean[SLength + 1][PLength + 1];
        flag[0][0] = true;
        for (int i = 0; i < SLength; i++) {
            for (int j = 1; j < PLength; j++) {
                if (p.charAt(j - 1) == '*') {
                    flag[i][j] = flag[i][j - 2];
                    if (machine(s, p, i, j - 1)) {
                        flag[i][j] = flag[i][j] || flag[i - 1][j];
                    }
                } else {
                    if (machine(s, p, i, j)) {
                        flag[i][j] = flag[i - 1][j - 1];
                    }
                }
            }
        }
        return flag[SLength][PLength];
    }

    private boolean machine(String s, String p, int i, int j) {
        if (i == 0) return false;
        if (p.charAt(j - 1) == '.') return true;
        return s.charAt(i) == p.charAt(j);
    }
}
