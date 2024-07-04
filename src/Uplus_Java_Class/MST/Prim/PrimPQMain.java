package Uplus_Java_Class.MST.Prim;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimPQMain {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Uplus_Java_Class/MST/Prim/PrimInput.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<int[]>[] g = new List[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int c = sc.nextInt();
                if(c!= 0) g[i].add(new int[]{j, c});
            }
        };

        boolean[] v = new boolean[N];
        int[] minEdge = new int[N];                  // 최소 가중치를 가지는 리스트
        for(int i = 0; i < N; i++) minEdge[i] = Integer.MAX_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1],o2[1]));

        int sum = 0, cnt = 0;
        minEdge[0] = 0;
        pq.offer(new int[]{0, minEdge[0]});   // 정점, 비용

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            System.out.print(cur[0] + " ");
            if(v[cur[0]]) continue;          // 방문 여부를 검사해서 끊어줌으로써 사이클이 안만들어지도록!
            v[cur[0]] = true;
            sum += cur[1];
            if(cnt++==N-1) break;
            for(int[] j: g[cur[0]]) {
                if(!v[j[0]]) {
                    pq.offer(j);
                }
            }
        }
        System.out.println(sum);
        sc.close();

    }
}