package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;

public class bj_17070 {
    static int N;
    static int[][] arr;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++ ) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1,2,0);
        System.out.println(count);

    }

    static void dfs(int x, int y, int dir) {
        if(x == N && y == N) {
            count++;
            return;
        }

        if(dir == 0) {
            if(y+1 < N+1 && arr[x][y+1] == 0){
                dfs(x, y + 1, 0);
            }
        } else if(dir == 1) {
            if(x+1 < N+1 && arr[x+1][y] == 0){
                dfs(x+1, y, 1);
            }
        } else {
            if(y+1 < N+1 && arr[x][y+1] == 0){
                dfs(x, y + 1, 0);
            }
            if(x+1 < N+1 && arr[x+1][y] == 0){
                dfs(x+1, y , 1);
            }
        }
        if (x + 1 < N+1 && y + 1 < N+1 && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }



    }
}
