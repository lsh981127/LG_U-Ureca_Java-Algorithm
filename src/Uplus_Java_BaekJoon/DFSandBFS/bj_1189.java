package Uplus_Java_BaekJoon.DFSandBFS;

import java.io.*;
import java.util.*;

public class bj_1189 {
    static int R, C, K;
    static char[][] arr;
    static boolean[][] visited;
    static int count = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y, int tempCount) {

        if(x == 0 && y == C-1) {
            if(tempCount == K) {
                count++;
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny]) {
                if (arr[nx][ny] != 'T') {
                    // 처음에 방문처리만 해주고 false 를 안풀어줬었다.
                    // 다른 경로로는 해당 부분을 방문할 수 있게 만들어줬었어야하기에 다시 false로 만들어준다.
                    // 그런 뒤, 특정 조건을 만족하면 return을 하게 하고 K번 방문한 것과 목표한 부분에 도착하면 그때 count 를 1씩 증가시킨다.
                    visited[x][y] = true;
                    dfs(nx, ny, tempCount+1);
                    visited[x][y] = false;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_1189.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                arr[i][j] = temp[j];
            }
        }

        dfs(R-1, 0, 1);
        System.out.println(count);
    }
}
