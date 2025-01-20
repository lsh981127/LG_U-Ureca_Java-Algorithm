package Uplus_Java_BaekJoon.ShortestPath;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{

    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class bj_1916 {

    static int N;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end,cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dikjstra(start, end);

    }

    static void dikjstra(int start, int end) {
        boolean[] v = new boolean[N+1];
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            int now = pq.poll().index;
            if(v[now]) continue;
            v[now] = true;

            for(Node node : graph[now]){
                if(dist[node.index] > dist[now] + node.cost) {
                    dist[node.index] = dist[now] + node.cost;
                    pq.offer(new Node(node.index, dist[node.index]));
                }
            }
        }

        System.out.println(dist[end]);
    }

}
