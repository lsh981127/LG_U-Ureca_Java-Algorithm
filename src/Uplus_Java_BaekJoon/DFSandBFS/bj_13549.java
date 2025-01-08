package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;

public class bj_13549 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[200001];  // 최대값이 100,000이기에 2배인 200,000까지 허용하기 위해 최대 Index를 200,000으로 잡았다

        Deque<int[]> queue = new ArrayDeque<>();
        int[] start = {N, 0};  // 시작, 현재 값
        queue.offer(start);
        visited[N] = true;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int cur = temp[0];
            int val = temp[1];
            if(cur == K){
                System.out.println(val);
                return;
            }

            // 2배를 하는 연산이 최소값을 보장하기 때문에 제일 먼저 연산을 진행해야한다.
            // 만약 2배 연산을 후순위에 두면 틀린다!
            int[] calc = {cur * 2, cur - 1, cur + 1};

            int[] time = {val, val + 1, val + 1};

            for(int i = 0; i < 3; i++) {
                if(calc[i] >= 0 && calc[i] <= 200000 && !visited[calc[i]] ) {
                    visited[calc[i]] = true;
                    queue.offer(new int[]{calc[i], time[i]});
                }
            }
        }
    }
}
