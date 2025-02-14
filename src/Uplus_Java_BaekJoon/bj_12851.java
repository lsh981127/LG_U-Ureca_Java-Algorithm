package Uplus_Java_BaekJoon;

import java.util.*;
import java.io.*;

public class bj_12851 {
    static int N, M;
    static int[] cal = {2, 1, -1};
    static int[] v;
    static int min_time = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = new int[1000001];

        if(N >= M) {
            System.out.println(N-M);
            System.out.println(1);
            return;
        }

        BFS(N, M);
        System.out.println(min_time);
        System.out.println(count);
    }

    public static void BFS(int start, int end) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{start, 0});
        v[start] = 0;
        while(!deque.isEmpty()) {
            int[] cur = deque.poll();  // 위치
            int current = cur[0];
            int time = cur[1];
            if(current == end) {
                if(min_time == 0) min_time = time;
                if(time == min_time) count++;
                continue;
            }

            for(int i = 0; i < 3; i++) {
                int next = current;
                if(i == 0) next *= cal[i];
                else next += cal[i];

                if(next < 0 || next > 100000) continue;
                // "일부 동일한 루트"로 오는 경우에 대해 다른 경우들도 방문해야하기 때문에 "시간"을 기준으로 방문 여부를 허용해야한다.
                // 1 -> 2 로 가는 경우는 2가지 경우(+1, *2) => 그러나 서로 다른 경우의 수로 봐야한다.
                // 고로, +1이 먼저 진행해서 v[2] = 2가 되어있으면, *2로 진행하는 방식은 어떻게 v[2]를 방문할 수 있어야 할까?
                // +1, *2 가 진행할 당시 시간 : x
                // 1 + 1 => 2 : v[2] = v[1] + 1
                // 1 * 2 => 2 : v[2]는 이미 +1인 경우가 방문 처리 해둠. 고로, 같은 시간대에 다른 경우로 왔기 때문에 동일한 시간인 v[1] + 1인 경우만 허용해주는 거야
                // 만약, time[next] <= time[now] + 1가 된다면
                // time[next]가 더 작은 값으로 덮어씌워질 수 있음.
                // 이미 최소값이 아닌 경우까지 다시 큐에 넣을 위험이 있음.

                if(v[next] == 0 || v[next] == time + 1) {
                    v[next] = time+1;
                    deque.add(new int[]{next, time+1});
                }

            }
        }
    }
}
