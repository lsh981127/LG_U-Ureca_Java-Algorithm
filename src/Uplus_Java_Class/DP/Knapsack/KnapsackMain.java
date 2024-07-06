package Uplus_Java_Class.DP.Knapsack;

import java.util.*;
import java.io.*;
public class KnapsackMain {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/Uplus_Java_Class/DP/Knapsack/knapsack_input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int[] weights = new int[N+1];
        int[] profit = new int[N+1];

        for(int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }

        int[][] dp = new int[N+1][W+1];
        for(int i = 1; i <= N; i++) {
            for(int w = 1; w <= W; w++) {
                if(weights[i] <= w) { // 넣을 수 있을떄
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]] + profit[i]);
                } else{
                    dp[i][w] = dp[i-1][w];
                }
                /**
                 * 이렇게 사용 가능
                 * dp[i][w] = dp[i-1][w];
                 * if(weights[i] <= w) { // 넣을 수 있을떄
                 * dp[i][w] = Math.max(dp[i][w], dp[i-1][w-weights[i]] + profit[i]);
                 * }
                 */


            }
        }


        System.out.println(dp[N][W]);
        sc.close();


    }
}
