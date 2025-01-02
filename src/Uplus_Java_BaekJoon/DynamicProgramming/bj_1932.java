package Uplus_Java_BaekJoon.DynamicProgramming;

import java.util.*;
import java.io.*;


public class bj_1932 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int[][] array = new int[N+1][N];
        int[][] dp = new int[N+1][N];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if(j == 0) {
                    dp[i][j] = array[i][j] + dp[i-1][j];
                } else if (j == i-1) {
                    dp[i][j] = array[i][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = array[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }

        }

        for(int i : dp[N]) {
            if(answer < i) answer = i;
        }

        System.out.println(answer);




    }



}
