package Uplus_Java_BaekJoon.BackTracking;

import java.util.*;
import java.io.*;

public class bj_6603 {
    static int n;
    static int[] com;
    static int[] arr;

    static void comb(int count, int start) {
        if(count == 6) {
            for(Integer i : com) System.out.print(i + " ");
//            System.out.println(Arrays.toString(com));
            System.out.println("");
            return;
        }

        for(int i = start; i < n; i++) {
            com[count] = arr[i];
            comb(count + 1, i + 1);
        }

    }


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_6603"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            arr = new int[n];
            com = new int[6];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            comb(0,0);
            System.out.println(" ");

        }

    }
}
