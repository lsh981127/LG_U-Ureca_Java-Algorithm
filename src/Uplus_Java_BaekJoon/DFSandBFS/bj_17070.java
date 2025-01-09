package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;

public class bj_17070 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 1};  // 가로, 세로, 대각선 방향
    static int[] dy = {1, 0, 1};
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i = 1; i < N+1; i++ ) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 미는 방향 3개
        // ->

    }

    static void dfs(int x, int y, int dir) {
        if(x < 1 || x > N || y < 1 || y > N || arr[x][y] == 1) return;

        if(dir == 2) {      // 대각선일 때, (x+1, y), (x, y+1) 다 벽인지 아닌지 확인해야함
            if(arr[x+1][y] == 1 || arr[x][y+1] == 1) return;
        }

        if(x == N && y == N) {
            count++;
            return;
        }

        if(dir == 0) {
            dfs(x, y+1, dir);   // 우로 밀리기만
            dfs(x+1, y+1, 2); // 우로 밀리고 밑으로 이동한 경우
        } else if(dir == 1) {

        } else {

        }



    }
}
