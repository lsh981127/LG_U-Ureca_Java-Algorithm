package Uplus_Java_BaekJoon.Sort;

import java.util.*;
import java.io.*;

public class bj_11650 {
    static int[][] cord;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        cord = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cord[i][0] = Integer.parseInt(st.nextToken());
            cord[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cord, (int[] o1, int[] o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]): Integer.compare(o1[0], o2[0]));
        for(int i = 0; i < N; i++) {
            System.out.println(cord[i][0] + " " + cord[i][1]);
        }
    }
}

