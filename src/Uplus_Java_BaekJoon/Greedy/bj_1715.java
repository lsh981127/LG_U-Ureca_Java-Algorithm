package Uplus_Java_BaekJoon.Greedy;

import java.util.*;
import java.io.*;

public class bj_1715 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int total = 0;
        int formal = 0;
        int[] arr = new int[num];

        for(int i = 0; i<num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for(int i = 0; i < num; i++) {
            total += formal + arr[i];
            formal += arr[i];
        }

        System.out.println(total);









    }
}
