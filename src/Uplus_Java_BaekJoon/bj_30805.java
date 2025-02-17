package Uplus_Java_BaekJoon;

import java.util.*;
import java.io.*;

public class bj_30805 {
    static Set<Integer> memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        memo = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int idx_A = 0, idx_B = 0;
        Deque<Integer>deque = new ArrayDeque<>();
        while(idx_A < N && idx_B < M) {
            int result = 0;   // A, B 배열의 가장 큰 수를 찾기 위한 변수(idx_A, idx_B 뒤에 남아 있는 애들에 대해 진행)

            // idx_A, idx_B 뒤로 둘이 공통된 수 중 가장 큰 값 찾기
            for(int i = idx_A; i < N; i++) {
                for(int j = idx_B; j < M; j++) {
                    if(A[i] == B[j]) result = Math.max(result, A[i]);
                }
            }

            if(result != 0) {  // 공통된 수가 있으면! (0이면 없다는 뜻, 그럼 기존 값 출력)
                deque.offer(result);
                // idx_A, idx_B를 현재 최대값으로 최신화해줘야해
                while(A[idx_A] != result) idx_A++;
                while(B[idx_B] != result) idx_B++;

                // 다음 최댓값 탐색을 위해 1씩 증가시켜준다. 1씩 증가시키지 않으면 지금 막 넣은 result값을 또 넣게 된다.
                idx_A++;
                idx_B++;

            } else break;

        }

        StringBuilder sb = new StringBuilder();
        sb.append(deque.size()).append("\n");   // 부분수열 길이
        while(!deque.isEmpty()) sb.append(deque.poll()).append(" ");

        System.out.println(sb.toString());


    }
}
