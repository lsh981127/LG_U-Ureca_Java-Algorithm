package Uplus_Java_Class.TopologicalSort;

import java.io.*;
import java.util.*;

public class TopologicalSortMain {
    static int N, M;
    static List<Integer>[] g;
    static int[] indegree;      // 진입 차수

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/TopologicalSort.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        g = new List[N+1];

        indegree = new int[N+1];
        // 진입차수용 리스크
        // 진입차수 : 특정 노드로 들어오는 간선의 갯수

        for(int i = 0; i < N+1; i++) g[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            indegree[b]++;
        }
        bfs();
        br.close();
    }


    static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
//        PriorityQueue<Integer> q = new PriorityQueue<>();
        // 정점 오름 차순
        for(int i = 1; i < N+1; i++) {
            if(indegree[i] == 0) q.offer(i);        // indegree가 0인 것부터 시작하는 거야
        }
        while(!q.isEmpty()) {
            int i = q.poll();
            System.out.print(i + " ");
            for(int j : g[i]) {
                if(--indegree[j] == 0) q.offer(j);
                // 이렇게 한번에도 가능
            }
        }
    }

}
