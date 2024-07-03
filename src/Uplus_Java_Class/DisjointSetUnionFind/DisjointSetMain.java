package Uplus_Java_Class.DisjointSetUnionFind;

import java.util.*;

public class DisjointSetMain {
    static int N;
    static int[] p;

    static void make() {
        p = new int[N];
        for (int i = 0; i < N; i++) p[i] = i;
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

        // A를 B의 부모노드로 만드는 함수야!

        return true;
    }

    public static void main(String[] args) throws Exception{
        N = 5;
        make();
        System.out.println("{0, 1, 2, 3, 4}");
        System.out.println(Arrays.toString(p));
        System.out.println("");


        // 1 -> 0
        System.out.println("{0, 1, 2, 3, 4}");
        System.out.println(union(0, 1));
        System.out.println(Arrays.toString(p));
        System.out.println("");

        // 1 - > 2인데 1의 부모노드인 0 -> 2 가 되는 거지
        System.out.println(union(2, 1));
        System.out.println("{0, 1, 2, 3, 4}");
        System.out.println(Arrays.toString(p));
        System.out.println("");


        // 2 - > 3, 그러면, 1 -> 0 -> 2 -> 3, 4 이렇게 2개의 서로소 집합이 있는 거야!
        System.out.println(union(3, 2));
        System.out.println("{0, 1, 2, 3, 4}");
        System.out.println(Arrays.toString(p));
        System.out.println("");

    }
}
