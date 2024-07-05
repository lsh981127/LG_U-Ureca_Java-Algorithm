package Uplus_Java_BaekJoon.ShortestPath;

import java.util.*;
import java.io.*;
public class bj_1753 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());       // 정점 개수
        int E = Integer.parseInt(st.nextToken());       // 간선 개수
        int K = Integer.parseInt(br.readLine()) - 1;        // 시작 정점

        List<int[]>[] graph = new List[V];
        for(int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new int[] {to, cost});
        }

        boolean[] visited = new boolean[V];

        int[] dist = new int[V];
        for(int i = 0; i < V; i++) dist[i] = Integer.MAX_VALUE;
        dist[K] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[]{K, 0});
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            int min = temp[1];
            int minVertex = temp[0];

            if(visited[minVertex]) continue;
            visited[minVertex] = true;

            for(int[] j: graph[minVertex]) {
                if(!visited[j[0]] && dist[j[0]] > min + j[1]) {
                    dist[j[0]] = min + j[1];
                    pq.offer(new int[]{j[0], dist[j[0]]});
                }
            }
        }

        for(int i = 0; i < V; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }
    }
}
