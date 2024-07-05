package Uplus_Java_Class.DP;
import java.util.*;
public class CoinDP {
    public static void main(String[] args) {
        int N = 8;
        int[] coin = {6,4,1};
        int cnt = 0;
        int[] dp = new int[N+1];

        // 방법 1
        for(int i = 1; i < N+1; i++) {
            int min = Integer.MAX_VALUE;
            if(i-1 >= 0 && min > dp[i-1] + 1)
                min = dp[i-1] + 1;
            if(i-4 >= 0 && min > dp[i-4] + 1)
                min = dp[i-1] + 4;
            if(i-6 >= 0 && min > dp[i-6] + 1)
                min = dp[i-1] + 6;
            dp[i] = min;
        }


        // 방법 2
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] coin1 = new int[]{1,4,6};
        for(int i = 0; i < coin1.length; i++) {
            for(int j = coin1[i]; j <=N; j++){
                dp[j] = Math.min(dp[j], dp[j - coin[i]]+1);
            }
        }

        System.out.println(dp[N]);
    }
}
