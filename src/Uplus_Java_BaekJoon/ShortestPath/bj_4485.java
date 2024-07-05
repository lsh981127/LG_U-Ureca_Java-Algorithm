package Uplus_Java_BaekJoon.ShortestPath;
import java.util.*;
import java.io.*;


public class bj_4485 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<int[]> pq;
        int[][] graph;
        boolean[][] visited;
        int[][] dist;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int count = 0;
        while(true) {
            int N = Integer.parseInt(br.readLine());
            count++;
            if(N == 0) break;
            graph = new int[N][N];
            visited = new boolean[N][N];

            dist = new int[N][N];
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++) {
                    dist[i][j] = Integer.MAX_VALUE/2;
                }

            dist[0][0] = 0;        // 어차피 (0,0)에서 항상 시작하기에

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++) {
                    graph[i][j]= Integer.parseInt(st.nextToken());
                }
            }

            pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
            pq.offer(new int[]{0,0, dist[0][0]});

            while(!pq.isEmpty()) {
                int[] temp = pq.poll();
                int x = temp[0], y = temp[1], cost = temp[2];
                if(visited[x][y]) continue;
                visited[x][y] = true;
                for(int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(0 <= nx && nx < N && 0 < ny && ny < N && !visited[nx][ny]) {
                        if(dist[nx][ny] > cost + graph[nx][ny]) {
                            dist[nx][ny] = cost + graph[nx][ny];
                            pq.offer(new int[]{nx, ny, dist[nx][ny]});
                        }
                    }
                }
            }
            System.out.println("Problem " + count + ": " + dist[N-1][N-1]);
        }

        br.close();
    }


}
