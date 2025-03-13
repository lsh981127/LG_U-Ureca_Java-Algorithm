package Uplus_Java_BaekJoon.binarySearch;

import java.util.*;
import java.io.*;
public class bj_2805 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int start = 0;
        int end = tree[N-1];
        // M 값 : 최대 20억
        // 나무 높이 최대 10억
        int result = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            int length = 0;
            for(int i : tree) {
                if(i < mid) continue;
                length += i - mid;
            }

            // 높이의 최댓값을 구하는 문제(= )
            // 나무를 충분히 구했다면,
            if(length >= M) {
                start = mid + 1;
                result = mid;
            } else {  // M
                end = mid - 1;
            }
        }

        System.out.println(result);

    }
}
