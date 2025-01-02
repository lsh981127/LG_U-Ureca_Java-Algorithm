package Uplus_Java_BaekJoon.DivideAndConquer;

import java.util.*;
import java.io.*;

public class bj_1074 {
    static int N;
    static int count;
    static void z(int x, int y, int n) {
        if(n == 0) return;

        int size = (int) Math.pow(2, n);

        if(x < size/2 && y < size/2) z(x, y, n-1);          // 1
        else if(x < size/2 && y >= size/2) {                   // 2
            count += size * size / 4;
            z(x, y - size/2, n-1);      //
        } else if(x >= size/2 && y < size/2) {
            count += (size * size / 4) * 2;
            z(x - size/2, y, n-1);
        } else {
            count += (size * size / 4) * 3;
            z(x - size/2, y - size/2, n-1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        count = 0;


        z(R,C,N);

        System.out.println(count);


    }
}
