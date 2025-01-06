package Uplus_Java_BaekJoon.DynamicProgramming.LCS;

import java.io.*;
public class bj_9251 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        int N = first.length();
        int M = second.length();

        int[][] dp = new int[M+1][N+1];

        for(int i = 1; i < M+1; i++) {  // B
            for(int j = 1; j < N+1; j++) {  // A
                if(second.charAt(i-1) == first.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[M][N]);
    }


}
