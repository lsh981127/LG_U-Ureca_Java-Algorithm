package Uplus_Java_BaekJoon.DisjointSetandUnion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_16562 {
    static int N, M, K;
    static int[] p;
    static int[] money;
    static int find(int a) {
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot)
            return false;

        if(money[aRoot] > money[bRoot]) p[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_24391.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        p = new int[N];
        for(int i = 0; i < N; i++) p[i]=i;

        int[] money = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a-1, b-1);
        }

        int count = 0;
        for(int i = 0; i < N-1; i++) {
            if(union(i, i+1))
                count++;

        }

        System.out.println(count);
    }
}
