package Uplus_Java_BaekJoon.binarySearch;

import java.util.*;
import java.io.*;

public class bj_11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] lis = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];
        int len = 1;

        for(int i = 1; i < N; i++) {
            if(lis[len-1] < arr[i]) {
                lis[len++] = arr[i];
            } else if(lis[len-1] > arr[i]) {
                int idx = binarySearch(lis, 0, len - 1, arr[i]);
                lis[idx] = arr[i];
            }
        }

        System.out.println(len);
    }

    static int binarySearch(int[] temp, int start, int end, int goal) {

        while(start <= end) {
            int mid = (start + end) / 2;
            if(temp[mid] < goal) start = mid + 1;
            else end = mid-1;
        }
        return start;
    }

}
