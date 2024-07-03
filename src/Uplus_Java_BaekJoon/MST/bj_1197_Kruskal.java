package Uplus_Java_BaekJoon.MST;

import java.util.*;
import java.io.*;

public class bj_1197_Kruskal {
    static int V, E;
    static int[][] graph;
    static int[] p;

    static void make() {
        p = new int[V];
        for(int i = 0; i < V; i++) p[i] = i;
    }

    static int find(int a) {
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot)
            return false;

        if(aRoot > bRoot)
            p[aRoot] = bRoot;
        else
            p[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_1197.txt"));
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();       // 정점
        E = sc.nextInt();       // 간선
        graph = new int[E][3];

        for(int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph[i] = new int[]{from-1, to-1, cost};
        }

        // 가격을 오름차순 기준 정렬하고
        // 올라가면서 연합할 수 있으면 그때그댸 더하는 거야
        // 최소 스패닝 트리는 간선 갯수가 무조건 V - 1개가 되어야하기에 V-1이면 끝내는 거야

        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        make();
        int sum = 0, count = 0;
        for(int[] g: graph) {
            if(union(g[0], g[1])) {
                sum += g[2];
            }
            if(++count == V - 1) break;
        }
        System.out.println(sum);
        sc.close();

    }
}
