package Uplus_Java_BaekJoon;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class bj_2206 {
    static int N, M;
    static boolean[][][] v;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        v = new boolean[N][M][2];    // 벽을 깨서 온 경우, 안 깨서 온 경우

        for(int i = 0; i < N; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = arr[j] - '0';
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0, 1, 0});  // x, y, count, 벽 부신 여부

        // dq에 넣는 것은 해당 경로의 진행상황을 보관하기 위한 용도
        // v는 누가 제일 먼저 해당 좌표를 방문했는지 체크하기 위한 용도 => 최단 거리 보장
        // 벽을 부숴서 도착했던가, 벽을 안 부수도 도착했던가, 2가지 경우에 대해 누가 먼저 도착했는지를 기록하는 용도
        v[0][0][0] = true;


        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            int count = cur[2];
            int destroyed = cur[3];
            if(cur_x == N-1 && cur_y == M-1) {
                System.out.println(count);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(map[nx][ny] == 0) {   // 벽이 없을 때
                    if(!v[nx][ny][0] && destroyed != 1)  { // 벽을 부신 적이 없는 경우
                        v[nx][ny][0] = true;
                        dq.offer(new int[]{nx,ny, count+1, 0});
                    } else if(!v[nx][ny][1] && destroyed == 1) {   // 벽을 부순 적이 있는 경우
                        v[nx][ny][1] = true;
                        dq.offer(new int[]{nx, ny, count + 1, 1});
                    }
                } else {   // -1로 벽이 있을 때
                    if(destroyed != 1 && !v[nx][ny][1])  {  // 부순 적이 없는 경우만 가능
                        v[nx][ny][1] = true;
                        dq.offer(new int[]{nx, ny, count+1, 1});
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
