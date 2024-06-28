package Uplus_Java_BaekJoon.DiverAndConquer;

import java.util.*;
import java.io.*;


public class bj_1992 {
    static int[][] arr;

    static String recur(int x, int y, int n) {
        if(n == 1) {        // 2 X 2
            return String.valueOf(arr[x][y]);
        }

        int temp = arr[x][y];
        for(int i = x; i < x + n; i++) {
            for(int j = y; j < y + n; j++) {
                if (arr[i][j] != temp) {
                    return "(" + recur(x, y, n/2) + recur(x, y+n/2, n/2)
                            + recur(x+n/2, y, n/2) + recur(x+n/2, y+n/2, n/2) + ")";
                }
            }
        }
        return String.valueOf(temp);
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_1992.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(recur(0, 0, N));
    }
}
