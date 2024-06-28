package Uplus_Java_BaekJoon.Greedy;

import java.util.*;
import java.io.*;
public class bj_11399 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        for(int i=0;i<num;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        int count = 0;
        Arrays.sort(arr);
        for(int i = 0; i<num;i++) {
            total += arr[i] + count;
            count += arr[i];
        }
        System.out.println(total);

    }

}
