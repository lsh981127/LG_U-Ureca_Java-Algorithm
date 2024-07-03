package Uplus_Java_BaekJoon.MST;

import java.io.*;
import java.util.*;

public class bj_1197_PrimPQ {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/res/bj_1197.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]>[] g = new List[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<>();

        for(int i = 0; i < M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //
            g[from-1].add(new int[]{to-1, cost});
            g[to-1].add(new int[]{from-1, cost});

        }

        boolean[] v = new boolean[N];
        int[] minEdge = new int[N];

        for(int i = 0; i < N; i++) minEdge[i] = Integer.MAX_VALUE;


        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int sum = 0, cnt = 0;
        minEdge[0] = 0;
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            int minVertex = temp[0];                 // 최소 가치를 가지는 노드 기록 변수
            int min = temp[1];        // 최소 가치
            if(v[minVertex]) continue;
            v[minVertex] = true;
            sum += min;
            if(cnt++ == N-1) break;
            for(int[] j: g[minVertex]) {
                if(!v[j[0]] && minEdge[j[0]] > j[1]) {
                    minEdge[j[0]] = j[1];
                    pq.offer(j);
                }
            }
//            System.out.println(Arrays.toString(minEdge));
        }
        System.out.println(sum);
        br.close();

    }
}
