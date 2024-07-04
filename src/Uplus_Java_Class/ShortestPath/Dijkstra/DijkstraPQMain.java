package Uplus_Java_Class.ShortestPath.Dijkstra;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraPQMain {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Uplus_Java_Class/ShortestPath/Dijkstra/DijkstraInput.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<int[]>[] g = new List[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int c = sc.nextInt();
                if(c!= 0) g[i].add(new int[]{j, c});
            }
        }

        boolean[] v = new boolean[N];
        int[] dist = new int[N];                  // 최소 가중치를 가지는 리스트
        for(int i = 0; i < N; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1],o2[1]));

        int sum = 0, cnt = 0;
        dist[0] = 0;
        pq.offer(new int[]{0, dist[0]});   // 정점, 비용
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            v[cur[0]] = true;
            int min = cur[1];
            int minVertex = cur[0];
            if(minVertex==N-1) break;
            for(int[] j: g[minVertex]) {
                if(!v[j[0]] && dist[j[0]] > min + j[1]) {
                    dist[j[0]] = min + j[1];
                    pq.offer(new int[]{j[0], dist[j[0]]});
                }
            }
        }
        System.out.println(dist[N-1]);
        sc.close();

    }
}