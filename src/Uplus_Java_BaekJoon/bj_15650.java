package Uplus_Java_BaekJoon;

import java.util.*;
import java.io.*;
public class bj_15650 {
    static int N, M;
    static int[] num;
    static int[] arr;

    static void comb(int count, int start) {
        if(count == M) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
            return ;
        }

        for(int i = start; i < N; i++) {
            arr[count] = num[i];
            comb(count + 1, i+1);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        arr = new int[M];
        for(int i = 0; i < N; i++) {
            num[i] = i+1;
        }
        comb(0, 0);


    }
}
