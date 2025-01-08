package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;

public class bj_13549 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[200001];

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
