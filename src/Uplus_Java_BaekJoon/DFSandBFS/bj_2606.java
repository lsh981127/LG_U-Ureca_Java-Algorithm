package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;
public class bj_2606 {
    static int N, M;
    static List<Integer>[] network;
    static boolean[] visited;
    static int total;

    static void bfs(int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(k);
        visited[k] = true;
        while (!q.isEmpty()) {
            int i = q.poll();
            for(int j : network[i]) {
                if(!visited[j]) {
                    visited[j] = true;
                    total++;
                    q.offer(j);
                }
            }
        }
    }

    static void dfs(int k) {
        visited[k] = true;
        for(int j: network[k]) {
            if(!visited[j]) {;
                total++;
                dfs(j);
            }
        }
    }


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_2606.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        network = new List[N];
        for(int i =0; i < N; i++) network[i] = new ArrayList<>();

        visited = new boolean[N];

        for(int i =0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            network[from-1].add(to-1);
            network[to-1].add(from-1);
        }

        // dfs용
        total = 0;
//        dfs(0);
//        System.out.println(total);

        // bfs용
        bfs(0);
        System.out.println(total);


    }
}
