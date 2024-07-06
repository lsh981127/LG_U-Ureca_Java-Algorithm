package Uplus_Java_Class.DP.Knapsack;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class KnapsackMain2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/Uplus_Java_Class/DP/Knapsack/knapsack_input.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();               // 물건 수
        int W = sc.nextInt();               // 최대 무게
        int[] weights = new int[N+1];       // 물건들의 무게 기록
        int[] profit = new int[N+1];        // 물건들의 가치 기록

        for(int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }

        int[] dp = new int[W+1];            // 최대 무게에 대한 DP 리스트 생성(용량)
        for(int i = 1; i <= N; i++) {       // 모든 물건들에 대해 검사를 진행
            for(int w = W; w >= weights[i]; w--) {    // 최대 무게에서 현재 i번째 물건의 무게까지 검사
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + profit[i]);

                /**
                 * 데이터 예제
                 *  4 7
                 * 6 13
                 * 4 8
                 * 3 6
                 * 5 12
                 */

                /**
                 *  i = 1, w = 7인 상황
                 *  i = 1이니까 상품은 weight[1] = 6, price[1] = 13
                 *
                 *  dp[7] = max(dp[7], dp[7 - 1번 상품의 무게] + 1번 상품의 가치)
                 *  즉, 기존 w번째 기록된 누적 가치(dp[7]) vs 지금 해당 상품을 넣었을 때의 가치
                 *  지금 해당 상품을 넣었을 때의 가치 = i번째 가치  + i 번째 물건의 무게를 넣기전까지의 누적 값
                 *                            = Profic[i] + dp[w - weight[i]]
                 */

                /**
                 * 이렇게 사용 가능
                 * dp[i][w] = dp[i-1][w];
                 * if(weights[i] <= w) { // 넣을 수 있을떄
                 * dp[i][w] = Math.max(dp[i][w], dp[i-1][w-weights[i]] + profit[i]);
                 * }
                 */


            }
        }

        System.out.println(Arrays.toString(dp));

        System.out.println(dp[W]);
        sc.close();


    }
}

