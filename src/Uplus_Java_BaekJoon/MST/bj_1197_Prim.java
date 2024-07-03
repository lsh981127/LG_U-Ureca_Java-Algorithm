package Uplus_Java_BaekJoon.MST;

import java.io.*;
import java.util.*;

public class bj_1197_Prim {
    // 간선 많으면 => 크루스칼
    // 아니면 프림
    // 대신 크루스칼은 그냥 from to cost 형태로 데이터가 주어지니까 편한데

    // 프림은 만약 그냥 인접행렬 형태로 데이터가 계속 오면 인접리스트로 바꿔서 푸는 게 좋아서 그렇다?
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/res/bj_1197.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<int[]>[] g = new List[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<>();

        for(int i = 0; i < M;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            //
            g[from-1].add(new int[]{to-1, cost});
            g[to-1].add(new int[]{from-1, cost});

        }

        boolean[] v = new boolean[N];
        int[] minEdge = new int[N];
//        Arrays.fill(minEdge, Integer.MAX_VALUE/2); // 메모리 터지는 거 방지하기 위해 2로 나눔
        for(int i = 0; i < N; i++) minEdge[i] = Integer.MAX_VALUE;

        int sum = 0, cnt = 0;
        minEdge[0] = 0;
        for(int i = 0; i < N; i++) {
            int minVertex = -1;                 // 최소 가치를 가지는 노드 기록 변수
            int min = Integer.MAX_VALUE;        // 최소 가치
            for(int j = 0; j < N; j++) {
                if(!v[j] && min > minEdge[j]) {
                    min = minEdge[j];
                    minVertex = j;
                }
            }
            v[minVertex] = true;
            sum += min;

            if(cnt == N-1) break;
            for(int[] j: g[minVertex]) {
                if(!v[j[0]] && minEdge[j[0]] > j[1]) {
                    minEdge[j[0]] = j[1];
                }
            }
//            System.out.println(Arrays.toString(minEdge));
        }
        System.out.println(sum);
        sc.close();

    }
}
