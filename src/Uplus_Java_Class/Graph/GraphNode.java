package Uplus_Java_Class.Graph;

import java.io.*;
import java.util.*;

public class GraphNode {
    static int N;
    static Node[] g;
    static boolean[] v;


    static class Node {
        int vertex;     // 노드 번호
        Node link;      // 연결된 다음 노드
        Node(int vertex, Node line) {
            this.vertex = vertex;
            this.link = line;
        }

        @Override
        public String toString() {
            return vertex + "->" + link;
        }
    }
    /**
     *
     * 노드 리스트로 구현할 시, 제일 뒤에 넣는 게 아니라 제일 앞에 계속해서 넣기때문에
     * 결과가 반대로 나온다!
     *
     * 1. 더하면 addFirst 하는 구조다
     * 2. dump?
     *
     */

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/graphmatrix.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        g = new Node[N];
        v = new boolean[N];

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g[a] = new Node(b, g[a]);
//            g[b] = new Node(a, g[b]);

        }
        for(Node a : g) System.out.println(a);
        System.out.println();
//        dfs(0);
//        bfs(0);
        br.close();
    }


    static void bfs(int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[k] = true;
        q.offer(k);
        while(!q.isEmpty()) {
            int i = q.poll();
            System.out.print((char) (i + 'A') + " ");
            for(Node j = g[i]; j != null; j = j.link) {
                if(!v[j.vertex]) {
                    v[j.vertex]=true;
                    q.offer(j.vertex);
                }
            }
        }
    }

    static void dfs(int i) {
        v[i] = true;
        System.out.print((char) (i + 'A') + " ");
        for(Node j = g[i]; j != null; j = j.link) {
            if(!v[j.vertex]) {
                dfs(j.vertex);
            }
        }
    }
}
