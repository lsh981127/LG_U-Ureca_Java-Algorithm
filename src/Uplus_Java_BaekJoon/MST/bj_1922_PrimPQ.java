package Uplus_Java_BaekJoon.MST;

import java.io.*;
import java.util.*;

public class bj_1922_PrimPQ {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N];

        List<int[]>[] li = new List[N];
        for(int i = 0; i < N; i++) li[i] = new ArrayList<>();


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            li[from].add(new int[]{to, cost});
            li[to].add(new int[]{from, cost});
        }

        int sum = 0, count = 0;     // sum : 비용용도, count : 종료용 간선 갯수 측정용
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

        pq.offer(li[0].get(0));

        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            System.out.println("노드번호 : " + temp[0] + " ");
            visited[temp[0]] = true;
            sum += temp[1];
            if(count++ == N - 1) break;
            for(int[] k: li[temp[0]]) {
                if(!visited[k[0]]) {
                    pq.offer(k);
                }
            }
        }
        System.out.println(sum);
        br.close();
    }
}
