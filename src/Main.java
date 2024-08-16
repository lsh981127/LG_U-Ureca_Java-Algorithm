import java.util.*;
import java.io.*;
public class Main {
    static int[][] graph;
    static int diff = 101;
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println("result " + solution(9, arr));
    }

    public static int solution(int n, int[][] wires) {
        // 모든 간선들 중, 끊었을 때, 1. 2개로 나누어지는지(만약 나눠지면 그때 2개 트리의 노드들의 차가 최소값이랑 업데이트)
        // 끊은 간선 기준 (a,b)를 끊었으면, a, b에 대해서 dfs나 BFS를 돌리고, 방문한 애들 갯

        graph = new int[n][n];

        for(int i = 0; i < n-1; i++) {
            int[] temp = wires[i];
            int x = temp[0];
            int y = temp[1];
            graph[x-1][y-1] = 1;
            graph[y-1][x-1] = 1;
        }

        for(int i = 0; i < n-1; i++) {
            int[] erase = wires[i];
            int x = erase[0]-1, y = erase[1] -1;
            visited = new boolean[n];
            graph[x][y] = 0;
            graph[y][x] = 0;

            int diff_x = bfs(x);
            visited = new boolean[n];
            int diff_y = bfs(y);

            int temp = Math.abs(diff_x - diff_y);
            diff = Math.min(diff, temp);

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        return diff;
    }

    static int bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        int count = 0;
        queue.offer(start);
        while(!queue.isEmpty()) {
            int cur = queue.pop();
            count++;
            for(int i = 0; i < graph[cur].length; i++) {
                if (graph[cur][i] == 1 && !visited[i]) { // 연결되어 있으면
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        return count;
    }

}
