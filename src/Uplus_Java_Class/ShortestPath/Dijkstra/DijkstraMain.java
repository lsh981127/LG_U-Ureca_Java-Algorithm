package Uplus_Java_Class.ShortestPath.Dijkstra;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DijkstraMain {
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
        };

        boolean[] v = new boolean[N];
        int[] dist = new int[N];                // 해당 노드까지의 최단 거리를 기록하는 변수(메모리제이션)
        for(int i = 0; i < N; i++) dist[i] = Integer.MAX_VALUE;

        int sum = 0, cnt = 0;
        dist[0] = 0;
        for(int i = 0; i < N; i++) {
            int minVertex = -1;                 // 최소 가치를 가지는 노드 기록 변수
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < N; j++) {
                if(!v[j] && min > dist[j]) {
                        min = dist[j];
                        minVertex = j;
                }
            }
            v[minVertex] = true;
            sum += min;

            if(minVertex == N-1) break;
            for(int[] j: g[minVertex]) {
                if(!v[j[0]] && dist[j[0]] > min + j[1]) {        // 특정 노드까지 오는 거리를 계속 더해주면서 갱신시키는 거야!
                    dist[j[0]] = min + j[1];
                }
            }
        }
        System.out.println(dist[N-1]);
        sc.close();

    }
}