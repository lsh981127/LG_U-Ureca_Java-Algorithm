package Uplus_Java_BaekJoon.DynamicProgramming;

import java.util.*;
import java.io.*;
public class bj_1535 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());        // 사람
        int[] dp = new int[100];

        int[] lost = new int[N];
        int[] joy = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            lost[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            for(int j = 99; j >= lost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - lost[i]] + joy[i]);
            }
        }

        System.out.println(dp[99]);
        br.close();
    }
}
