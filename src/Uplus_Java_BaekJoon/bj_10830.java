package Uplus_Java_BaekJoon;

import java.io.*;
import java.util.*;

public class bj_10830 {
    final static int MOD = 1000;
    public static int[][] origin;
    public static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // N X N
        long B = Long.parseLong(st.nextToken());  // 제곱 횟수

        origin = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = new int[N][N];
        result = pow(origin, B);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static int[][] pow(int[][] A, long exp) {
        if(exp == 1L) return A;

        // 절반 쪼개서 분할
        int[][] rel = pow(A, exp / 2);

        rel = multiply(rel, rel);   // 행렬 제곱

        if(exp % 2 == 1L) {  // 홀수였으면 origin 1개 더 곱해줘야햐함
            rel = multiply(rel, origin);
        }

        return rel;

    }

    public static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] temp = new int[N][N];

        for(int i = 0; i < N; i++){ // 원본
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    temp[i][j] += o1[i][k] * o2[k][j];
                    temp[i][j] %= MOD;
                }
            }
        }
        return temp;
    }

}
