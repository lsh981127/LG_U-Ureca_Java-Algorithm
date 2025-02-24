package Uplus_Java_BaekJoon;

import java.io.*;
import java.util.*;

class City implements Comparable<City>{
    int number;
    int cost;

    City(int number, int cost) {
        this.number = number;
        this.cost = cost;
    }

    @Override
    public int compareTo(City o2) {
        return this.cost - o2.cost;
    }
}

public class bj_11779 {
    static int N, M;
    static ArrayList<City>[] graph;
    static boolean[] v;
    static int MAX = 100000001;
    static int[] dist;
    static int[] route;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new City(number, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start_city = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        v = new boolean[N+1];
        route = new int[N+1];   // 최단 거리 경로를 따라 어디서 왔는지 저장하는 배열
        // EX) 5번으로 오는 최단 거리의 바로 전 거쳐온 노드의 값이 저장되는 것
        // end부터 시작해서 start까지 거슬러 올라가면 최단 거리 기준의 경로가 추척된다.

        dijkstra(start_city);

        System.out.println(dist[dest]);
        Stack<Integer> stack = new Stack<>();
        stack.push(dest);
        int cur = dest;
        int count = 1;
        while(route[cur] != 0) { // 0인 경우는 route[start_city], 즉 출발한 경우까지 진행
            stack.push(route[cur]);
            count++;
            cur = route[cur];
        }
        System.out.println(count);
        while(!stack.isEmpty()) System.out.print(stack.pop() + " ");

    }

    public static void dijkstra(int start) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        dist = new int[N+1];   // 각 거리별로 최단 거리, 거쳐온 도시 수, 거쳐온 도시숫자
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        route[start] = 0;
        pq.add(new City(start, 0));
        while (!pq.isEmpty()) {
            City current = pq.poll();

            // 다익스트라에서 같은 노드에 대해 중복적으로 들어갈 수 있기 때문에 조건문으로 그러한 경우들을 제거

            // 현재 최단 거리보다 긴 경우에 대해서는 확인할 필요가 없음
            if(dist[current.number] < current.cost) continue;

            for(City next : graph[current.number]) {
                if(dist[next.number] > dist[current.number] + next.cost) {
                    dist[next.number] = dist[current.number] + next.cost;
                    pq.add(new City(next.number, dist[next.number]));
                    route[next.number] = current.number;
                }
            }
        }
    }

}
