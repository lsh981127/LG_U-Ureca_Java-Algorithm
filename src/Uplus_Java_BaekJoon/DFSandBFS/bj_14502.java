package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;

public class bj_14502 {
    static int N, M;
    static boolean[][] visited;
    static int[][] graph;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]> virus;
    static List<int[]> zero;

    static int[][] wall = new int[3][2];
    static int safeNum = 0;
    static int virusNum = 0;
    static int max = -1;

    static void comb(int cnt, int start) {
        if(cnt == 3) {
            int numV = 0;
            for(int i = 0; i < 3; i++) {
                graph[wall[i][0]][wall[i][1]] = 1;
            }

            for(int[] v: virus)
                numV += bfs(v[0], v[1]);

            int safeCount = (safeNum - 3) - (numV - virusNum);

            if(max < safeCount) {
                max = safeCount;
                System.out.println("Max : "+  max + " numV : " + numV);
            }

            visited = new boolean[N][M];
            for(int i = 0; i < 3; i++) {
                graph[wall[i][0]][wall[i][1]] = 0;
            }
            return ;
        }

        for(int i = start; i < zero.size(); i++) {
            wall[cnt][0] = zero.get(i)[0];
            wall[cnt][1] = zero.get(i)[1];
            comb(cnt+1, start+1);
        }
    }


    static int bfs(int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        if(visited[x][y]) return 0;
        visited[x][y] = true;
        int tempCount = 1;
        q.offer(new int[]{x, y});
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int nx = temp[0];
            int ny = temp[1];
            for(int i = 0; i < 4; i++) {
                int rx = nx + dx[i];
                int ry = ny + dy[i];
                if(0 <= rx && rx < N && 0 <= ry && ry < M && !visited[rx][ry]) {
                    if(graph[rx][ry] != 1) {
                        visited[rx][ry] = true;
                        tempCount++;
                        q.offer(new int[]{rx,ry});
                    }
                }
            }
        }
        return tempCount;
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_14502.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        graph = new int[N][M];

        virus = new ArrayList<>();
        zero = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                graph[i][j] = temp;
                if(graph[i][j] == 2) {
                    virus.add(new int[]{i, j});
                    virusNum++;
                }
                else if(graph[i][j] == 0) {
                    zero.add(new int[]{i,j});
                    safeNum++;
                }
            }
        }
        comb(0, 0);

        System.out.println(safeNum);
        System.out.println(virusNum);
        System.out.println(max);




    }
}
