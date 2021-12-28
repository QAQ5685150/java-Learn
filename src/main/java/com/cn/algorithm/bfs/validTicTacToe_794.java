package com.cn.algorithm.bfs;

/**
 * @class: validTicTacToe_794
 * @description: 794. 有效的井字游戏
 * @author: 南风
 * @date: 2021-12-09 14:32
 **/
public class validTicTacToe_794 {

    public static void main(String[] args) {
        String[] test = new String[]{"X  ","X O","X  "};
        System.out.println(validTicTacToe(test));
        System.out.println(1 - 'a');

    }

    public static boolean validTicTacToe(String[] board) {
        int x = 0;
        int o = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if('X' == (board[i].charAt(j))){
                    x++;
                }else if('O' == (board[i].charAt(j))){
                    o++;
                }
            }
        }
        if(Math.abs(x - o) > 1) return false;
        if(x == 0 && o != 0) return false;
        return true;
    }

    public static boolean validTicTacToe1(String[] board) {
        char[][] cs = new char[3][3];
        int x = 0, o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') x++;
                else if (c == 'O') o++;
                cs[i][j] = c;
            }
        }
        boolean a = check(cs, 'X'), b = check(cs, 'O');
        if (o > x || x - o > 1) return false;
        if (a && x <= o) return false;
        if (b && o != x) return false;
        if (a && b) return false;
        return true;
    }
    static boolean check(char[][] cs, char c) {
        for (int i = 0; i < 3; i++) {
            if (cs[i][0] == c && cs[i][1] == c && cs[i][2] == c) return true;
            if (cs[0][i] == c && cs[1][i] == c && cs[2][i] == c) return true;
        }
        boolean a = true, b = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) a &= cs[i][j] == c;
                if (i + j == 2) b &= cs[i][j] == c;
            }
        }
        return a || b;
    }

//    public static boolean isEnd(String[] board){
//        int[][] x = new int[4][2];
//        int[][] o = new int[4][2];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length(); j++) {
//                if('X' == (board[i].charAt(j))){
//                    x[i][j]++;
//                }else if('O' == (board[i].charAt(j))){
//                    o++;
//                }
//            }
//        }
//
//
//
//    }
}
