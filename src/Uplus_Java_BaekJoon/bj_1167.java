package Uplus_Java_BaekJoon;

import java.io.*;
import java.util.*;

public class bj_1167 {
    static int N;
    static boolean[] v;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int length = 0;
    static int one = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        v = new boolean[N + 1];

        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while(true) {
                int end = Integer.parseInt(st.nextToken());
                if(end == -1) break;
                graph.get(start).add(new int[]{end, Integer.parseInt(st.nextToken())});
            }
        }

        // 지금 이건 1 기준으로 다른 노드들까지의 거리를 계산하는 DFS이다.

        // 우리 문제는, 두 정점이 제일 먼 것 = x, y 두 정점 중 어느 것 인지 모른다.

        dfs(1, 0);
        v = new boolean[N+1];

        dfs(one, 0);   // 1 기준 제일 먼 정점에 대해 트리의 지름 구하기


        System.out.println(length);

    }

    public static void dfs(int current, int len) {
        v[current] = true;
        for (int[] temp : graph.get(current)) {
            if(!v[temp[0]]) {
                if(length < len + temp[1]) {
                    length = len + temp[1];
                    one = temp[0];
                }
                dfs(temp[0], len + temp[1]);
            }
        }
    }

}
