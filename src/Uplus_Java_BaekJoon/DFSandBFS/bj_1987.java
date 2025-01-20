package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;
public class bj_1987 {
    static int[][] graph;
    static boolean[] visited = new boolean[26];
    static int result = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int R, C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        for(int i = 0; i < R; i++) {
            String temp = br.readLine();
            for(int j = 0; j < C; j++) {
                graph[i][j] = temp.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 1);
        System.out.println(result);
    }

    static void dfs(int x, int y, int count) {
        visited[graph[x][y]] = true;
        result = Math.max(result, count);
        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && tx < R && ty >= 0 && ty < C) {
                if(!visited[graph[tx][ty]]) {
                    dfs(tx, ty, count + 1);
                    visited[graph[tx][ty]] = false;
                }
            }
        }
    }
}
