package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;

public class bj_14502 {
    static int N, M;
    static int count;
    static boolean[][] visited;
    static int[][] graph;
    static int[][] test;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]> virus;
    static List<int[]> zero;

    static int bfs(int x, int y, int type) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int tempCount = 0;
        visited[x][y] = true;
        tempCount++;
        q.offer(new int[]{x, y});
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int nx = temp[0];
            int ny = temp[1];
            for(int i = 0; i < 4; i++) {
                int rx = nx + dx[i];
                int ry = ny + dy[i];
                if(0 <= rx && rx < N && 0 <= ry && ry < M && !visited[rx][ry]) {
//                    if(graph[rx][ry] != 1) {
//                        visited[rx][ry] = true;
//                        tempCount++;
//                        q.offer(new int[]{rx,ry});
//                    }

                    if (type == 2) {
                        if(test[rx][ry] != 1) {
                            // 벽만 아니면 지나가는 거지
                            visited[rx][ry] = true;
                            tempCount++;
                            q.offer(new int[]{rx,ry});
                        }
                    } else {
                        if(test[rx][ry] == 1) {
                            visited[rx][ry] = true;
                            q.offer(new int[]{rx,ry});
                        }
                        else if(test[rx][ry] == 0) {
                            // 벽만 아니면 지나가는 거지
                            visited[rx][ry] = true;
                            tempCount++;
                            q.offer(new int[]{rx,ry});
                        }
                    }
                }
            }
        }
        return tempCount;
    }

    static void dfs(int x, int y, int cnt) {
        if(cnt == 3) {
            for(int[] v: virus)
                bfs(v[0], v[1], 2);

            int temp = 0;
            for(int[] z:zero)
                temp += bfs(z[0], z[1], 0);

            if(count < temp) count = temp;
            visited = new boolean[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    test[i][j] = graph[i][j];
                }
            }
        }

        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int rx = x + dx[i];
            int ry = y + dy[i];
            if(0 <= rx && rx < N && 0 <= ry && ry < M && !visited[x][y]) {
                if(test[rx][ry] == 0) {
                    test[rx][ry] = 1;
                    dfs(rx, ry, cnt + 1);
                    test[rx][ry] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_14502.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        graph = new int[N][M];
        test = new int[N][M];

        virus = new ArrayList<>();
        zero = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                graph[i][j] = temp;
                test[i][j] = temp;
                if(graph[i][j] == 2) virus.add(new int[]{i,j});
                else if(graph[i][j] == 0) zero.add(new int[]{i,j});
            }
        }

        // 1. 벽 설치  => 1에 대해서 어떻게 설치를 하는 게 좋을까?
        // 2. 바이러스 전파 = > bfs 돌리고
        // 3. 0 갯수 측정

        dfs(zero.get(0)[0], zero.get(0)[1], 0);
        System.out.println(count);




    }
}
