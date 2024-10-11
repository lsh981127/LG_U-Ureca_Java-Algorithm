package Uplus_Java_BaekJoon.BrutalForce;
import java.util.*;
import java.io.*;

public class bj_14500 {
    static int val = 0;
    static int[][] graph;
    static int[][] visited;
    static int[] dx = {1, -1, 0 ,0};
    static int[] dy = {0, 0, 1 ,-1};
    static int N, M;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[N][M];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = 1;
                bfs(i, j, 1, graph[i][j]);
                visited[i][j] = 0;
            }
        }

        System.out.println(val);
    }

    public static void bfs(int x, int y, int cnt, int sum) {
        if(cnt == 4) {
            if(sum > val) {
                val = sum;
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 > nx || nx >= N || 0 > ny || ny >= M)   // 이게 먼저 와야 visited에 index 에러 발생 방지
                // nx,ny가 0보다 작거나 N,M 보다 클 수 있으니
                continue;
            if(visited[nx][ny] == 1)
                continue;


            if(cnt == 2) {
                visited[nx][ny] = 1;
                bfs(x, y, cnt+1, sum + graph[nx][ny]);
                visited[nx][ny] = 0;
            }

            visited[nx][ny] = 1;
            bfs(nx, ny, cnt+1, sum + graph[nx][ny]);
            visited[nx][ny] = 0;

        }


    }

}
