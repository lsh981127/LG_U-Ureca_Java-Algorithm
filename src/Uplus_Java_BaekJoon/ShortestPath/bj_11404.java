package Uplus_Java_BaekJoon.ShortestPath;

import java.io.*;
import java.util.*;

public class bj_11404 {
    static int MAX = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());

        int[][] path = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            Arrays.fill(path[i], MAX);
            path[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            path[start][end] = Math.min(path[start][end], cost);

        }

        for(int k = 1; k < n+1; k++) {
            for(int i = 1; i < n+1; i++) {
                for(int j = 1; j < n+1; j++) {
                    path[i][j] = Math.min(path[i][j], path[i][k] + path[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if(path[i][j] == MAX) {
                    sb.append(0).append(" ");
                    continue;
                }
                sb.append(path[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
