package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;

public class bj_1260 {
    static int N, M, V;
    static int[][] matrix;
    static List<Integer>[] list;
    static Node[] nodeList;

    static boolean[] visited;

    static class Node {
        int vertex;
        Node link;
        Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }

        @Override
        public String toString() {
            return link + " " + vertex;
        }
    }

    static void bfsNode(int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        visited[k] = true;
        while(!queue.isEmpty()) {
            int i = queue.poll();
            System.out.print(i+1 + " ");
            for(Node j = nodeList[i]; j != null; j = j.link) {
                if(!visited[j.vertex]) {
                    visited[j.vertex] = true;
                    queue.offer(j.vertex);
                }
            }
        }
    }



    static void dfsNode(int i) {
        visited[i] = true;
        System.out.print(i+1 + " ");
        for(Node j = nodeList[i]; j != null; j = j.link) {
            if(!visited[j.vertex]) {
                dfsNode(j.vertex);
            }
        }
    }

    static void bfsMatrix(int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[k] = true;
        queue.offer(k);
        while(!queue.isEmpty()) {
            int i = queue.poll();
            System.out.print(i+1 + " ");
            for(int j = 0; j < N; j++) {
                if(matrix[i][j] != 0 && !visited[j]) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }


    static void dfsMatrix(int i) {
        visited[i] = true;
        System.out.print(i+1 + " ");
        for(int j = 0; j < N; j++) {
            if(matrix[i][j] != 0 && !visited[j]) {
                dfsMatrix(j);
            }
        }
    }

    static void bfsList(int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[k] = true;
        queue.offer(k);
        while(!queue.isEmpty()) {
            int i = queue.poll();
            System.out.print(i+1 + " ");
            for(int j : list[i]) {
                if(!visited[j]) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }


    static void dfsList(int i) {
        visited[i] = true;
        System.out.print(i+1 + " ");
        for(int j : list[i]) {
            if(!visited[j]) {
                dfsList(j);
            }
        }
    }


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_1260.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        nodeList = new Node[N];

        matrix = new int[N][N];

        list = new List[N];
        for(int i = 0; i < N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            from--;
            int to = Integer.parseInt(st.nextToken());
            to--;
//            nodeList[from] = new Node(to, nodeList[from]);
//            nodeList[to] = new Node(from, nodeList[to]);
            // to -> from, 최근 노드가 구 노드를 가리키고

//            matrix[from][to] = 1;
//            matrix[to][from] = 1;

            list[from].add(to);
            list[to].add(from);
        }

//        dfs(V);
//        dfsMatrix(V);
        dfsList(V-1);

        for(int i = 0; i < N; i++) visited[i] = false;
        System.out.println();

        bfsList(V-1);
//        bfsMatrix(V);
//        bfs(V);


        br.close();
    }
}
