package Uplus_Java_BaekJoon.DFSandBFS;
import java.util.*;
import java.io.*;
public class bj_21736 {
    static int N, M;
    static boolean visited[][];
    static char graph[][];
    static int[] dx;
    static int[] dy;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        // 시작 포인트 찾고
        int x = 0;
        int y = 0;
        count = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        graph = new char[N][M];

        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(arr[j] == 'I') {
                    x = i;
                    y = j;
                }
                graph[i][j] = arr[j];
            }
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x ,y});

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int nx = temp[0], ny = temp[1];
            for(int i = 0; i < 4; i++) {
                int tx = nx + dx[i];
                int ty = ny + dy[i];
                if(0 <= tx && tx < N && 0 <= ty && ty < M && !visited[tx][ty] && graph[tx][ty] != 'X'){
                    if(graph[tx][ty] == 'P') {
                        count++;
                    }
                    visited[tx][ty] = true;
                    queue.offer(new int[]{tx, ty});
                }
            }
        }

        System.out.println(count != 0 ? count : "TT");
    }
}
