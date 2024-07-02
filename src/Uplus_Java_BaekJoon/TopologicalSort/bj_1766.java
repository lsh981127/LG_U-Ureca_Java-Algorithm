package Uplus_Java_BaekJoon.TopologicalSort;

import java.util.*;
import java.io.*;

public class bj_1766 {
    static int N, M;
    static List<Integer>[] li;
    static int[] indegree;

    static void bfs() {
//        ArrayDeque<Integer> q = new ArrayDeque<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < N+1; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int i = q.poll();
            System.out.print(i + " ");
            for(int k : li[i]) {
                if(--indegree[k] == 0) q.offer(k);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_1766.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        li = new List[N+1];
        indegree = new int[N+1];

        for(int i = 1; i < N+1; i++) li[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            li[from].add(to);
            indegree[to]++;
        }
        bfs();
    }
}
