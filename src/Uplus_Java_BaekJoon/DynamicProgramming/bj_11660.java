package Uplus_Java_BaekJoon.DynamicProgramming;

import java.util.*;
import java.io.*;

public class bj_11660 {
    static int N;
    static int[][] array;
    static long[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());
        array = new int[N+1][N+1];

        // N X N에다가 각 값이 1,000 이하더라도 int를 초과할 수도 있을 것 같아서 Long으로 설정
        dp = new long[N+1][N+1];

        for(int i = 1; i < N+1; i++)  {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j < N+1; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + array[i][j];
            }
        }

        for(int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(calc(x1, y1, x2, y2));
        }
    }

    static long calc(int x1, int y1, int x2, int y2) {
        if(x1 == x2 && y1 == y2) return array[x1][y1];
        return dp[x2][y2] - (dp[x2][y1-1] + dp[x1-1][y2]) + dp[x1-1][y1-1];

    }
}
