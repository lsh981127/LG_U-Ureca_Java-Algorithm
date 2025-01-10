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

        if(dir == 0) {  // 가로일 때
            if(y+1 < N+1 && arr[x][y+1] == 0){  // 우로 이동
                dfs(x, y + 1, 0);
            }
        } else if(dir == 1) {  // 세로일 때
            if(x+1 < N+1 && arr[x+1][y] == 0){  //밑으로 한칸 이동
                dfs(x+1, y, 1);
            }
        } else {        // 대각선일떄
            if(y+1 < N+1 && arr[x][y+1] == 0){ // 대각선 -> 가로
                dfs(x, y + 1, 0);
            }
            if(x+1 < N+1 && arr[x+1][y] == 0){ // 대각선 - 세로
                dfs(x+1, y , 1);
            }
        }
        // 모든 방향 파이프들은 대각선으로 이동할 수 있기에 제일 밑에서 진행하도록 설정
        // x+1, y+1로 이동하기 (단, 회전 가능하도록 검사 후 진행)
        if (x + 1 < N+1 && y + 1 < N+1 && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
    }
}
