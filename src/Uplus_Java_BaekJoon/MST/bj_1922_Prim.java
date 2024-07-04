package Uplus_Java_BaekJoon.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1922_Prim {
    static int[] p;
    static int N;
    static int[][] g;


    static void make() {
        p = new int[N];
        for(int i = 0; i < N; i++) p[i]=i;
    }
    static int find(int a) {
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        p[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        // 입력값이 from to cost 형태 => 인접리스트로 하기 쉬움 => 크루스칼
        boolean[] visited = new boolean[N];
        g = new int[M][3];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            g[i] = new int[]{from, to, cost};
        }

        Arrays.sort(g, (o1,o2) -> Integer.compare(o1[2], o2[2])); // 가중치 기준 정렬
        make();
        int sum = 0, count = 0;     // sum : 비용용도, count : 종료용 간선 갯수 측정용

        for(int[] temp : g) {
            int from = temp[0];
            int to = temp[1];
            if(union(to, from)) {
                sum += temp[2];
                count++;
            }
            if(count == N-1) break;

        }

        System.out.println(sum);
        br.close();
    }
}
