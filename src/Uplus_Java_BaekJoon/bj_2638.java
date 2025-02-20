package Uplus_Java_BaekJoon;

import java.awt.List;
import java.util.*;
import java.io.*;

public class bj_2638 {
    static int N, M;
    static boolean[][] v;
    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<int[]> cheese;
    static int cheese_count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        v = new boolean[N][M];

        cheese = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) {
                    cheese_count++;
                    cheese.add(new int[]{i, j});
                }
            }
        }

        int count = 0;
        while(true) {
            count++;
            v = new boolean[N][M];
            outair_bfs();
            check_melt();
            if(cheese_count == 0) break;
        }
        System.out.println(count);
    }

    static void outair_bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        v[0][0] = true;
        graph[0][0] = 2;
        dq.offer(new int[]{0,0});
        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            for(int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;
                if(!v[nx][ny] && graph[nx][ny] == 0) {
                    graph[nx][ny] = 2;
                    v[nx][ny] = true;
                    dq.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static void check_melt() {
        for(int i = 0; i < cheese.size(); i++) {
            int x = cheese.get(i)[0];
            int y = cheese.get(i)[1];
            int air = 0;
            for(int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(graph[nx][ny] == 2) air++;
            }
            if(air >= 2) {
                graph[x][y] = 0;
                cheese_count--;
                cheese.remove(i) ;
                i--;
            }
        }
    }
}
