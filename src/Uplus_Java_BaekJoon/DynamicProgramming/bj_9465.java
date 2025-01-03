package Uplus_Java_BaekJoon.DynamicProgramming;

import java.util.*;
import java.io.*;

public class bj_9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] array = new int[2][N+1];
            int[][] dp = new int[2][N+1];
            for(int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 1; k <= N; k++) {
                    array[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 첫째 행은 본인들
            dp[0][1] = array[0][1];
            dp[1][1] = array[1][1];

            for(int d = 2; d <= N; d++) {
                dp[0][d] = Math.max(dp[1][d-2], dp[1][d-1]) + array[0][d];
                dp[1][d] = Math.max(dp[0][d-2], dp[0][d-1]) + array[1][d];
            }

            System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));

        }



    }
}
