package Uplus_Java_BaekJoon.BrutalForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_18111 {
    static int N, M, B;
    static int[][] graph;
    static int time = Integer.MAX_VALUE;
    static int height = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(temp.nextToken());
                if(tmp > max) max = tmp;
                if(tmp < min) min = tmp;
                graph[i][j] = tmp;
            }
        }



        for(int i = min; i <= max; i++) {       // min ~ max 범위의 높이를 맞추면 된다.
            int timeCal = 0;
            int del = 0;
            int add = 0;
            for(int j = 0; j < N; j++) {
                for(int k = 0; k <M; k++) {
                    if(graph[j][k] == i)
                        continue;
                    if(graph[j][k] > i) {
                        del += graph[j][k] - i;
                    }

                    if(graph[j][k] < i) {
                        add += i - graph[j][k];
                    }
                }
            }
            if(B + del - add < 0)
                continue;

            timeCal = del * 2 + add;
            if(time > timeCal) {
                time = timeCal;
                height = i;
            } else if (time == timeCal) {
                if (height < i) height = i;
            }
        }


        System.out.print(time + " " + height);
        br.close();

    }
}
