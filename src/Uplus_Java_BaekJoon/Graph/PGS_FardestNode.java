package Uplus_Java_BaekJoon.Graph;

import org.w3c.dom.Node;

import java.util.*;
public class PGS_FardestNode {

    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) {
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println("solution = " + solution(6, vertex));
    }

    public static int solution(int n, int[][] edge) {
        // 최단 거리로 1부터 다른 노드들까지의 거리 다 구한뒤
        // 최대값 가지는 애들의 갯수를 찾는 것
        // 다익스트라 알고리즘이 적합
        graph = new ArrayList<>();
        visited = new boolean[n];
        dist = new int[n];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] i : edge) {
            int start = i[0] - 1;
            int end = i[1] - 1;
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        dijkstra(0);
        int max = Arrays.stream(dist).max().getAsInt();
        int answer = 0;
        for(int i : dist) {
            if (i != max) continue;
            answer++;
        }
        return answer;
    }

    public static void dijkstra(int start) {
        // 우선순위 큐는 기본적으로 큰 값을 출력,
        // 오름차순 정렬을 하게되면 작은 값부터 출력하게 된다.
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        pq.add(start);
        dist[start] = 0;
        while(!pq.isEmpty()) {
            int now = pq.poll();
            if(!visited[now]) {
                visited[now] = true;
            }
            for(int i = 0; i < graph.get(now).size(); i++) {
                ArrayList<Integer> temp = graph.get(now);
                for(int j = 0; j < temp.size(); j++) {
                    int curr = temp.get(j);
                    if(!visited[curr] && dist[curr] > dist[now] + 1) {
                        dist[curr] = dist[now] + 1;
                        pq.add(curr);
                    }
                }

            }
        }
    }
}
