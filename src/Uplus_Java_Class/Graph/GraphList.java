package Uplus_Java_Class.Graph;

import java.io.*;
import java.util.*;

public class GraphList {
    static int N;
    static List<Integer>[] g;
    static boolean[] v;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/graphmatrix.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 갯수가 주어져야하는데
        N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        g = new List[N];
        v = new boolean[N];

        // 내부에 ArrayList를 미리 선언해둔 뒤에 Add를 해야한다.
        // 이거 안한채로 add 하면 NullPointerException이 발생
        for(int i = 0; i < N; i++) g[i] = new ArrayList<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 여기서 NullPointerException 발생
            // 왜? 지금 List는 전부 Null이다.
            g[a].add(b);
            g[b].add(a);
        }
//        dfs(0);
        bfs(0);
        br.close();
    }


    static void bfs(int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[k] = true;
        q.offer(k);
        while(!q.isEmpty()) {
            int i = q.poll();
            System.out.print((char) (i + 'A') + " ");
            for(int j : g[i]) {
                if(!v[j]) {
                    v[j]=true;
                    q.offer(j);
                }
            }
        }
    }

    static void dfs(int i) {
        v[i] = true;
        System.out.print((char) (i + 'A') + " ");
        for(int j : g[i]) {
            if(!v[j]) {     // 어차피 인접하니까 방문 여부만 체크
                dfs(j);
            }
        }
    }
}
