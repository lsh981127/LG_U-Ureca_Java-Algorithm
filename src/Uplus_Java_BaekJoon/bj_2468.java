package Uplus_Java_BaekJoon;

import java.io.*;
import java.util.*;

public class bj_2468 {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    //상 우 하 좌
    static int N;
    static int[][] arr;
    static boolean[][] visited;

    static void dfs(int x, int y, int avg) {
        /// avg : 침수하는 높이의 기준
        visited[x][y] = true;
        for(int d =0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                if(arr[nx][ny] > avg) {     // 잠기지 않는 경우에 대해서만 진행
                    dfs(nx,ny, avg);
                }

            }
        }
    }

    static void bfs(int i, int j, int avg) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.offer(new int[]{i,j});
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if(arr[nx][ny] > avg && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int max_height = 0; // 최대 높이 이상으로 돌릴 이유가 없음, 최대 높이면 전부 가라앉기에 답은 0
        int answer = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // 최대 높이를 구해둔다.
                int temp = Integer.parseInt(st.nextToken());
                if (temp > max_height) max_height = temp;
                arr[i][j] = temp;
            }
        }

        // 1부터 구해둔 최대 높이까지에 대해서만 안전지대의 최댓값을 구한다.
        for(int h = 0; h < max_height; h++) {
            // 매번 새 높이에 대한 안전 지역을 구하기에 방문 여부를 초기화해야한다.
            visited = new boolean[N][N];
            int temp_answer = 0;    // 안전지대 갯수 기록용 변수
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(arr[i][j] > h && !visited[i][j]) {
                        dfs(i, j, h);
//                        bfs(i, j, h);
                        temp_answer++;
                    }
                }
            }
            answer = Math.max(answer, temp_answer);     // 최댓값 비교
        }

        System.out.println(answer);
        br.close();

    }
}
