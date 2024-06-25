package Uplus_Java_BaekJoon.CombinationAndPermutaion;


import java.io.*;
import java.util.*;

public class bj_2798 {
    static int N, M;
    static int max = 0;
    static int[] num;
    static int[] arr;
    static void comb(int count, int start) {
        if (count == 3) {
            int temp = 0;
            for(int i = 0; i < 3; i++) {
                temp += arr[i];
            }
            if (temp <= M) max = Math.max(max, temp);
            return;
        }

        for(int i = start; i < N; i++) {
            arr[count] = num[i];
            comb(count + 1, i+1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        arr = new int[3];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        comb(0,0);
        System.out.println(max);


    }
}
