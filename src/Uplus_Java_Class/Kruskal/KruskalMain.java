package Uplus_Java_Class.Kruskal;

import java.util.*;
import java.io.*;

public class KruskalMain {
    static int N;
    static int[][] g;
    static int[] p;

    static void make() {
        p = new int[N+1];
        for (int i = 0; i < p.length; i++) p[i] = i;
    }

    static int find(int a) {
        if(p[a] == a) return a;
        return p[a]=find(p[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);        // a 부모 찾기
        int bRoot = find(b);        // b 부모 찾기

        if(aRoot == bRoot) return false;
        p[bRoot] = aRoot;           // 이건 통합

        return true;
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("KruskalMain.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int E = sc.nextInt();
        g = new int[E][3];
        for(int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            g[i] = new int[]{from, to, cost};
        }


        Arrays.sort(g, (o1,o2) -> Integer.compare(o1[2], o2[2]));
        for(int[] a: g) System.out.println(Arrays.toString(a));
        make();
        int sum = 0, cnt = 0;
        for(int[] e: g) {
            if(union(e[0], e[1])) {
                sum += e[2];
            }
            if(++cnt == N-1) break;       // 이미 union을 시켰으니 간선이 이미 추가됐기때문에 미리 증가시킨다.

        }
        System.out.println(sum);
        sc.close();
    }
}
