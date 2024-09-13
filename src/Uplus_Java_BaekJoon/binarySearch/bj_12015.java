package Uplus_Java_BaekJoon.binarySearch;

import java.io.*;
import java.util.*;
public class bj_12015 {
    static int N;
    static int[] lis, arr;
    static int binarySearch(int start, int end, int goal) {
        while(start < end) {
            int mid = (start + end) / 2;
            if(lis[mid] < goal) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        lis = new int[N];
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0];
        int len = 1;
        for(int i = 1; i < arr.length; i++) {
            if(lis[len-1] < arr[i]) {
                lis[len++] = arr[i];
            } else if(lis[len-1] > arr[i]) {
                int idx = binarySearch(0, len - 1, arr[i]);
                lis[idx] = arr[i];
            }
            System.out.println(Arrays.toString(lis));
        }

        System.out.println(len);

    }
}
