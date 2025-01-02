package Uplus_Java_BaekJoon.DFSandBFS;
import java.util.*;
import java.io.*;
public class bj_16234 {
    static int N, L, R;
    static int[][] arr;

    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int rx = temp[0], ry = temp[1];
            for (int i = 0; i < 4; i++) {
                int nx = rx + dx[i];
                int ny = ry + dy[i];
                if(0<= nx && nx < N && 0 <= ny && ny < N) {

                }
            }
        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }




    }
}
