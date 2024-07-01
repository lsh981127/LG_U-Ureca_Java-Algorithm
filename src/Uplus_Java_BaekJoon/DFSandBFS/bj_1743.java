package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;

public class bj_1743 {
    static int N, M, K;
    static int[][] trashMatrix;
    static boolean[][] visitedM;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count;
    static int max;

    static void dfs(int x, int y) {
        visitedM[x][y] = true;
        count++;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < N && 0 <= ny && ny < M && !visitedM[nx][ny]) {
                if(trashMatrix[nx][ny] != 0) {
                    dfs(nx, ny);
                }

            }
        }
    }

    static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visitedM[x][y] = true;
        count = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int rx = cur[0];
            int ry = cur[1];
            for(int i = 0; i < 4; i++) {
                int nx = rx + dx[i];
                int ny = ry + dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < M && !visitedM[nx][ny]) {
                    if(trashMatrix[nx][ny] != 0) {
                        visitedM[nx][ny] = true;
                        count++;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        if (max < count) max = count;
    }


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/res/bj_1743.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        trashMatrix = new int[N][M];
        visitedM = new boolean[N][M];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            trashMatrix[x-1][y-1] = 1;
        }

        count = 0;
        max = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visitedM[i][j] && trashMatrix[i][j] != 0) {
                    count = 0;
                    dfs(i, j);
                    max = Math.max(max, count);
//                    bfs(i, j);
                }
            }
        }
        System.out.println(max);

    }
}
