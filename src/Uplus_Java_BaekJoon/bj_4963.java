package Uplus_Java_BaekJoon;

import java.util.*;
import java.io.*;

public class bj_4963 {
    static int[][] arr;
    static int N, M;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};        // 12시부터 시계방향
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static boolean[][] visited;
    static int island;

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (arr[nx][ny] == 1 && !visited[nx][ny]) {         // 방문 안한 섬인 경우
                    dfs(nx,ny);
                }

            }
        }
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!q.isEmpty()) {
            int[] cor = q.poll();
            int x = cor[0];
            int y = cor[1];
            for(int d = 0; d< 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }

        visited[i][j] = true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            // 새로운 테스트 케이스에 대해 초기화
            visited = new boolean[N][M];
            arr = new int[N][M];
            island = 0;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
//                        dfs(i, j);
                        bfs(i, j);
                        island++;
                    }
                }
            }

            System.out.println(island);
//            System.out.println(dfs(0,0));
//            System.out.println(bfs(0,0));

        }
        br.close();
    }
}
