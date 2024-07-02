package Uplus_Java_BaekJoon.DisjointSetandUnion;

import java.util.*;
import java.io.*;

public class bj_24391 {

    static int N, M;
    static int[] p;

    static int find(int a) {
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }

    static boolean union(int a, int b, boolean fix) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot)
            return false;

        if(fix) p[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_24391.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N];

        for(int i = 0; i < N; i++) p[i]=i;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a-1,b-1, true);
        }



        int[] classArr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            classArr[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        int count = 0;
        for(int i = 0; i < N-1; i++) {
            if(union(classArr[i], classArr[i+1], false)) count++;

        }

        System.out.println(count);
    }
}
