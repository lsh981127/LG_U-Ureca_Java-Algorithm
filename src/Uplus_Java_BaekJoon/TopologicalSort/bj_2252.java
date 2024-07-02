package Uplus_Java_BaekJoon.TopologicalSort;

import java.io.*;
import java.util.*;

public class bj_2252 {
    static int N, M;
    static List<Integer>[] li;
    static int[] indegree;

    static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < N+1; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int i = q.poll();
            System.out.print(i + " ");
            for(int j : li[i]) {
                if(--indegree[j] == 0) q.offer(j);
            }

        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_2252.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        li = new List[N+1];
        for(int i = 0; i < N+1; i++) li[i] = new ArrayList<>();

        for (int i = 1; i < M+1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            li[from].add(to);
            indegree[to]++;
        }
        bfs();
    }
}
