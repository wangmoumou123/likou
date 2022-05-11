package com.likou;

import java.util.HashSet;
import java.util.Set;

public class UsefulNumSelf_5_11 {
    public static void main(String[] args) {
//        System.out.println(new UsefulNumSelf().isValidSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
        System.out.println(new UsefulNumSelf_5_11().isValidSudoku(new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}}));
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character> comp = new HashSet<>();
        int len = 0;
        // 横向
        if (!CheckHorizontal(comp, len, board)) return false;
        if (!CheckVertical(comp, len, board)) return false;
        if (!CheckJiugongge(comp, len, board)) return false;

        return true;


    }

    private boolean CheckJiugongge(Set<Character> comp, int len, char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int k=i;
                while ( k < i + 3) {
                    int l=j;
                    while (l < j + 3) {
                        char temp = board[k][l];
                        if (temp != '.') {
                            len += 1;
//                            System.out.println("board"+k+"-"+l+"====>"+temp);

                            comp.add(temp);
                        }
                        l++;
                    }
                    k++;
                }
//                System.out.println(comp);
                if (len != comp.size()) return false;
                comp.clear();
                len = 0;
            }

        }
        return true;

    }

    public boolean CheckHorizontal(Set<Character> comp, int len, char[][] board) {
        for (char[] chars : board) {
            for (char temp : chars) {
                if (temp != '.') {
                    len += 1;
                    comp.add(temp);
                }
            }
            if (len != comp.size()) return false;
            comp.clear();
            len = 0;
        }
        return true;
    }

    public boolean CheckVertical(Set<Character> comp, int len, char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char temp = board[j][i];
                if (temp != '.') {
                    len += 1;
                    comp.add(temp);
                }
            }
            if (len != comp.size()) return false;
            comp.clear();
            len = 0;
        }
        return true;
    }


}
