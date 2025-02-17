package Uplus_Java_BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1238_flowyd {
    static int N, M, X;
    static boolean[] v;
    static int[][] map;
    static int MAX = 1000001;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());  // 학생 수
        M = Integer.parseInt(st.nextToken());  // 도로 갯수
        X = Integer.parseInt(st.nextToken());  // 파티하는 마을

        map = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(map[i], MAX);
            map[i][i] = 0;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start][end] = cost;
        }


        for(int k = 1; k < N+1; k++) {
            for(int i = 1; i < N+1; i++) {
                for(int j = 1; j < N+1; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int answer = 0;
//        for(int i = 1; i <= N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        for(int i = 1; i < N+1; i++) {
            int temp = map[i][X] + map[X][i];
            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }
}
