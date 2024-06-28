package Uplus_Java_BaekJoon.DiverAndConquer;

import java.util.*;
import java.io.*;

public class bj_2630 {
    static int N;
    static int[][] arr;
    static int blue = 0;
    static int white = 0;
    static void recur(int x, int y, int n) {
        if(N == 1) {
            if(arr[x][y] == 0) white++;
            else blue++;
            return;
        }
        int cur = arr[x][y];
        boolean done = true;

        for(int i = x; i < x + n; i++) {
            if(!done) break;
            for(int j = y; j < y+n; j++) {
                 if(cur != arr[i][j]) {
                     recur(x, y, n/2);
                     recur(x + n/2, y, n/2);
                     recur(x , y+n/2, n/2);
                     recur(x + n/2, y + n/2, n/2);
                     done = false;
                     break;
                 }
            }
        }

        if(done) {
            if (cur == 0) white++;
            else blue++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
             st = new StringTokenizer(br.readLine());
             for (int j = 0; j < N; j++) {
                 arr[i][j] = Integer.parseInt(st.nextToken());
             }
        }

        recur(0,0, N);
        System.out.println(white);
        System.out.println(blue);

    }
}
