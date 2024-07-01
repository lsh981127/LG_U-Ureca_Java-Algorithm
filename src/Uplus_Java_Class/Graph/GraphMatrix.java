package Uplus_Java_Class.Graph;

import java.util.*;
import java.io.*;
public class GraphMatrix {
    static int N;
    static int[][] g;
    static boolean[] v;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/graphmatrix.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        g = new int[N][N];
        v = new boolean[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a][b] = 1;
            g[b][a] = 1;
        }
//        for(int[] a : g) System.out.println(Arrays.toString(a));
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
            for(int j = 0; j < N; j++) {
                if(g[i][j] == 1 && !v[j]) {
                    v[j]=true;
                    q.offer(j);
                }
            }
        }
    }

    static void dfs(int i) {
        v[i] = true;
        System.out.print((char) (i + 'A') + " ");
        for(int j = 0; j < N; j++) {
            if(g[i][j] != 0 && !v[j]) {
                dfs(j);
            }
        }
    }
}
