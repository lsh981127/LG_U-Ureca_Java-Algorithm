package Uplus_Java_BaekJoon;
import java.util.*;
import java.io.*;


class World {
    int start;
    int end;
    int cost;

    World(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

public class bj_1865 {

    static ArrayList<World> graph;
    static final int MAX = 100000000;
    static int[] dist;
    static BufferedReader br;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int i = 0; i < TC; i++) {
            testcase();
        }
    }

    public static void testcase() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st  = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new World(start, end, cost));
            graph.add(new World(end, start, cost));
        }

        for(int i = 0; i < W; i++) {
            st  = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new World(start, end, cost * -1));
        }

        /**
         * 모든 점에 대해서 진행하지 않는 이유는?
         * - 모든 간선을 N번 검사하는 로직
         * - 그 과정에서, 어차피 모든 간선을 돌면서 정점들의 최단 거리가 업데이트된다
         * - 우리 목적은 음수 순환이 발생하는지 검사하는 것
         * => 최단 거리 업데이트 여부만 확인하면 되기 때문에 굳이 시작점에 대해 진행할 필요가 없다.
         */
        if(BellmanFord(N)) System.out.println("YES");

        /**
         * 왜 시작점을 모든 정점에 대해 진행할 필요가 없는가?
         * - 사이클이 발생하는지만 찾으면 된다. => 각 정점들에 대한 최소 거리를 확인할 필요 없다.
         * - 그냥 마지막 N번째 이후로도 값이 변하는 경우가 있는지만 보면 되는 것
         * - 고로, MAX와 같이 최대값으로 초기화하고, 조건을 추가할 필요 없다
         *
         */
        else System.out.println("NO");
    }


    public static boolean BellmanFord(int n) {
        dist = new int[n+1];

        // N번 탐색 => 최단 거리 보장된다.
        for(int i = 0; i < n-1; i++) {
            boolean updated = false;
            for(World world : graph) {
                if(dist[world.end] > dist[world.start] + world.cost) {
                    dist[world.end] = dist[world.start] + world.cost;
                    updated = true;
                }
            }
            if(!updated) break;
        }

        // 위에서 N번 반복했으니 이번에 1번만 더 진행(모든 간선에 대한 탐색)
        // 이미 최단 거리가 보장되었으니 1번 더 값이 변한다면 음수 순환이 발생한 것이다!
        for(World world : graph) {
            if(dist[world.end] > dist[world.start] + world.cost) {
                return true;
            }
        }
        return false;
    }
}
