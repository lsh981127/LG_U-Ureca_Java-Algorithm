package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;

public class bj_2178 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;


    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int rx = temp[0], ry = temp[1];
            if(rx == N-1 && ry == M-1)
                break;

            for(int i = 0; i < 4; i++) {
                int nx = rx + dx[i];
                int ny = ry + dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
                    if(map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[rx][ry] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_2178.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            char[] in = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                map[i][j] = in[j] - '0';
            }
        }


        bfs(0, 0);
        // 가는 경로에 대해 몇 번재 방문인지 값을 저장해두는 것!
        System.out.println(map[N-1][M-1]);


    }
}
