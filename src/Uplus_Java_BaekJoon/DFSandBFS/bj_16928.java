package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;
public class bj_16928 {

    static HashMap<Integer, Integer> move;
    static boolean[] visited = new boolean[101];
    public static void main(String[] args) throws Exception{
        // 사다리나 뱀이 있는 것만 검사하는 게 맞지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        move = new HashMap<>();


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            move.put(start, end);

        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            move.put(start, end);
        }
        bfs(1);
        br.close();
    }

    public static void bfs(int start) {
        int count = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        visited[start] = true;
        dq.offer(start);
        while(!dq.isEmpty()) {
            // 주사위 라운드 별 , 즉 1~6까지 다 돌리는 경우들에 대해서 검사해야한다.
            // 그러면 큐 안에 6개씩이 각 라운드 별로 들어오게 됨.
            int size = dq.size();
            count++;
            for(int i = 0; i < size; i++) {
                int temp = dq.poll();
                for(int j = 1; j <= 6; j++) {    // 주사위
                    int current = temp + j;
                    if(current > 100) continue;
                    if(current == 100) {
                        System.out.println(count);
                        return;
                    }

                    if(!visited[current]) {
                        visited[current] = true;
                        if(move.containsKey(current)) {
                            current =  move.get(current);
                        }
                        dq.offer(current);
                    }
                }
            }
        }
    }
}
