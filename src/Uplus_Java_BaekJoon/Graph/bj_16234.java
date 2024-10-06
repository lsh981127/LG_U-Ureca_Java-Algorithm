package Uplus_Java_BaekJoon.Graph;

import java.io.*;
import java.util.*;
public class bj_16234 {
    static boolean[][] v;
    static int[][] graph;
    static int[] dirx = {1, -1, 0, 0};
    static int[] diry = {0, 0, 1, -1};
    static int N, L, R;
    static boolean work = false;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(true) {
            v= new boolean[N][N];
            work = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!v[i][j]) {
                        bfs(i,j);
                    }
                }
            }
            if(!work) {
                break;
            } else {
                day++;
            }
        }
        System.out.println(day);
    }

    public static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        ArrayDeque<int[]> memo = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        memo.offer(new int[]{x, y});
        int total = graph[x][y];
        int count = 1;
        v[x][y] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int dx = cur[0];
            int dy = cur[1];
            int cur_val = graph[dx][dy];
            for(int i = 0; i < 4; i++) {
                int tempx = dx + dirx[i];
                int tempy = dy + diry[i];
                if(0 <= tempx && tempx < N && 0 <= tempy && tempy < N ) {
                    int temp_val = graph[tempx][tempy];
                    int diff = Math.abs(cur_val - temp_val);
                    if(!v[tempx][tempy] && diff >= L && diff <= R) {
                        total += graph[tempx][tempy];
                        count++;
                        v[tempx][tempy] = true;
                        work = true;
                        memo.offer(new int[]{tempx, tempy});
                        queue.offer(new int[]{tempx, tempy});
                    }
                }
            }
        }

        if(work) {
            int val = total / count;
            for(int[] temp : memo) {
                graph[temp[0]][temp[1]] = val;
            }
        }
    }
}
