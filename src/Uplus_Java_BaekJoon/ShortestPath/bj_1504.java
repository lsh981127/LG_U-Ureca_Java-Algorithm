package Uplus_Java_BaekJoon.ShortestPath;

import java.util.*;
import java.io.*;

public class bj_1504 {
    static int N, E, node1, node2;
    static int[][] graph;
    static int INF = 200000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) continue;
                graph[i][j] = INF;
            }
        }

//        dest = new int[N+1][N+1];
//
//
//        for(int i = 1; i < N + 1; i++) {
//            Arrays.fill(dest[i], INF);
//        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
            graph[b][a] = c;
        }

        st = new StringTokenizer(br.readLine(), " ");
        node1 = Integer.parseInt(st.nextToken());
        node2 = Integer.parseInt(st.nextToken());

        // 플로이드 와샬 진행
        for(int k = 1; k < N+1; k++) {
            for(int i = 1; i < N+1; i++) {
                for(int j = 1; j < N+1; j++) {
                    if(graph[i][k] == INF || graph[k][j] == INF) continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

//        for(int i = 1; i < N+1; i++) {
//            System.out.println(Arrays.toString(graph[i]));
//        }

        // 시작점에서 1 혹은 2번
        int first = dfs(node1, node2);
        int second = dfs(node2, node1);

        if(first == INF && second == INF) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(first, second));



    }

    static int dfs(int x, int y) {
        int count = 0;
        if(graph[1][x] == INF) return INF;
        count += graph[1][x];
        if(graph[x][y] == INF) return INF;
        count += graph[x][y];
        if(graph[y][N] == INF) return INF;
        count+= graph[y][N];
        return count;
    }

}
