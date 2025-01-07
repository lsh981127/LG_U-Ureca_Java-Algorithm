package Uplus_Java_BaekJoon.DynamicProgramming.Knapsack;

import java.util.*;
import java.io.*;

public class bj_12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 물품 갯수
        int max_weight = Integer.parseInt(st.nextToken());  // 버틸 수 있는 무게
        int[][] stuffs = new int[N+1][2];
        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            stuffs[i][0] = Integer.parseInt(st.nextToken());   // 물건의 무게
            stuffs[i][1] = Integer.parseInt(st.nextToken());   // 물건의 가치
        }


//        int[][] dp = new int[N+1][max_weight+1];   // 행 : i번째 물건까지 고려했을 때, 열 : j가 최대 무게였을 때, 값 : 최적의 가치
//
//        for(int i = 1; i < N+1; i++) {
//            for(int j = 1; j < max_weight+1; j++) {
//                //
//                if(stuffs[i][0] > j) {  // i번째 물건의 무게가 j 무게보다 커서 못 넣는 경우
//                    dp[i][j] = dp[i-1][j];  // i-1번째 무게 값 그대로 가져오기
//                } else {
//                    // i번째 물건을 넣을 수 있을떄!!
//                    /**
//                     * 이제, 기존 i-1번째에서 j 무게까지의 최적값([i-1][j]) VS 지금 물건을 넣었을 때 최적값을 비교하는 거야
//                     * i-1번째에서 j 무게까지의 최적값 = dp[i-1][j]
//                     *
//                     * 지금 물건을 넣었을 떄 최적값 = i번째 물건의 무게를 뻈을 때 최적값 + i번째 가치
//                     *                       = dp[i-1][j - i번째 물건의 무게) + i번째 가치
//                     *                       = dp[i-1][j - stuffs[i][0]) + stuffs[i][1]
//                     */
//
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - stuffs[i][0]] + stuffs[i][1]);
//                }
//            }
//        }
//        System.out.println(dp[N][max_weight]);

        /**
         * 2차원 배열이 아닌 1차원 배열로 처리하는 방법
         *
         * 1. 점화식은 i-1 번째, 즉 바로 이전 행만 참고한다.
         * 그러면, 1차원 배열로 만든 뒤, i-1 번째 index로 읽는 방법으로 구현 가능
         *
         * 단, 연순으로 진행해야한다. 왜? => 이걸 이해못했어
         *
         *
         */

        int[] one_dp = new int[max_weight+1];   // 행 : i번째 물건까지 고려했을 때, 열 : j가 최대 무게였을 때, 값 : 최적의 가치
        for(int i = 1; i < N+1; i++) {
            for(int j = max_weight; j >= stuffs[i][0]; j--) {   // 무게가 최대 K -> 지금 진행하는 가방의 무게까지만 진행(stuffs[i][0])
                // 지금 진행하는 가방의 무게까지만 진행 => 어차피 넣을 수 없는 무게에는 1차원 배열에 추가되지 않음

                // 물건 넣을 수 있을 때,
                /**
                 * i-1번째의 무게 j까지 고려한 최적값 = one_dp[j-1]
                 *
                 * i번째 물건을 넣었을 떄 최적값 = i번째 물건의 무게를 뻈을 때 최적값 + i번째 가치
                 *                       = dp[j- i번째 물건 무게] + i번째 가치
                 *                       = dp[j - stuffs[i][0]) + stuffs[i][1]
                 */

                one_dp[j] = Math.max(one_dp[j], one_dp[j - stuffs[i][0]] + stuffs[i][1]);
            }
        }


        System.out.println(one_dp[max_weight]);
    }
}
