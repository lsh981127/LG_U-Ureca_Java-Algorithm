package Uplus_Java_BaekJoon.DFSandBFS;
import java.util.*;
import java.io.*;
public class bj_21736 {
    static int N, M;
    static boolean visited[][];
    static char graph[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 시작 포인트 찾고

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if()
                graph[i][j] = arr[j];
            }
        }



    }
}
