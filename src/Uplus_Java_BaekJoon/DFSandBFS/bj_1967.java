package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;

public class bj_1967 {
    static int N;
    static ArrayList<Integer[]> tree[];
    static boolean[] visited;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        boolean[] leafs = new boolean[N+1];
        visited = new boolean[N+1];
        Arrays.fill(leafs, true);
        tree = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());   // 부모 노드
            int end = Integer.parseInt(st.nextToken());     // 자식 노드
            int cost = Integer.parseInt(st.nextToken());
            tree[start].add(new Integer[]{end, cost});
            tree[end].add(new Integer[]{start, cost});
            leafs[start] = false;
        }

        for(int i = 1; i < N+1; i++) {
            if(leafs[i]) {
                Arrays.fill(visited, false);
                dfs(i, 0);
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int count) {
        visited[x] = true;
        max = Math.max(max, count);
        for(Integer[] temp: tree[x]) {
            int next = temp[0];
            int cost = temp[1];
            if(!visited[next]) {
                dfs(next, count + cost);
            }

        }

    }
}
