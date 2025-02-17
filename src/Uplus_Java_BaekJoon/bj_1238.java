package Uplus_Java_BaekJoon;

import java.util.*;
import java.io.*;

class Village implements Comparable<Village>{
    int number;
    int cost;

    Village(int number, int cost) {
        this.number = number;
        this.cost = cost;
    }

    @Override
    public int compareTo(Village n) {
        return this.cost - n.cost;
    }
}

public class bj_1238 {
    static int N, M, X;
    static int[] x_path;
    static ArrayList<ArrayList<Village>> map;
    static int MAX = 1000001;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());  // 학생 수
        M = Integer.parseInt(st.nextToken());  // 도로 갯수
        X = Integer.parseInt(st.nextToken());  // 파티하는 마을

        map = new ArrayList<>();
        for(int i = 0; i < N+1; i++) {
            map.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map.get(start).add(new Village(end, cost));
        }

        x_path = dijkstra(X);
        int answer = 0;

        for(int i = 1; i < N+1; i++) {  // 모든 마을에서 X 마을까지 진행
            if(i == X) continue;
            int[] temp = dijkstra(i);  // i번쨰에서 X까지 거리 구하기용 최단 거리
            answer = Math.max(answer, temp[X] + x_path[i]);
        }

        System.out.println(answer);


    }

    public static int[] dijkstra(int start) {
        PriorityQueue<Village> pq = new PriorityQueue<>();
        pq.offer(new Village(start, 0));
        int[] dist = new int[N+1];
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        while(!pq.isEmpty()) {
            Village current = pq.poll();
            for(Village next : map.get(current.number)) {
                if(dist[next.number] > dist[current.number] + next.cost) {
                    dist[next.number] = dist[current.number] + next.cost;
                    pq.offer(next);
                }
            }
        }

        return dist;
    }
}
