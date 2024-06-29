package Uplus_Java_BaekJoon.BackTracking;

import java.util.*;
import java.io.*;

public class bj_2580 {
    static int[] num = {1,2,3,4,5,6,7,8,9};
    static int[][] arr = new int[9][9];
    static int totalSum = 45;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_2580.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
            }
        }


        for(int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        br.close();


    }
}
