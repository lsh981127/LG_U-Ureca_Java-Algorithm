package Uplus_Java_BaekJoon;
import java.awt.List;
import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int num;
    int cost;

    Node(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        // 가중치 오름차순 정렬을 위해 넣어줘야한다.
        return this.cost - o.cost;
    }
}

public class bj_14938 {
    static int MAX = 2000;
    static ArrayList<ArrayList<Node>> map;
    static int N, M, R;
    static int[] dist;
    static boolean[] v;
    static int[] items;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        items = new int[N+1];   // 지역별 아이템 갯수
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < N+1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map.get(start).add(new Node(end, cost));
            map.get(end).add(new Node(start, cost));
        }

        v = new boolean[N+1];
        dist = new int[N+1];

        int max = 0;
        for(int i = 1; i < N+1; i++) {  // 각 지역별로 최대 값 구하기
            max = Math.max(max, dijkstra(i));
        }
        System.out.println(max);


    }

    public static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, MAX);  // 초기화
        Arrays.fill(v, false);

        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int cur_node = cur.num;
            if(v[cur_node]) continue;
            v[cur_node] = true;
            for(Node next : map.get(cur_node)) {
                if(!v[next.num] && dist[next.num] > dist[cur_node] + next.cost) {
                    dist[next.num] = dist[cur_node] + next.cost;
                    pq.offer(new Node(next.num, dist[next.num]));
                }
            }

        }

        // 이제 start를 기준으로 모든 점들의 최단 거리가 구해진 상태
        int val = 0;
        for(int i = 1; i < N+1; i++) {
            if(dist[i] > M) continue;
            val += items[i];
        }
        return val;

    }
}
