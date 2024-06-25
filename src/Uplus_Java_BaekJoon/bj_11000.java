package Uplus_Java_BaekJoon;

import java.util.*;
import java.io.*;

public class bj_11000 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [][]arr = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

//        Arrays.sort(arr, (int[] o1, int[] o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        Arrays.sort(arr, (int[] o1, int[] o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);

        for(int i = 1; i <arr.length; i++) {
            // 강의장 수업 끝나는 시간 <= 지금 수업 시작시간
            if(pq.peek() <= arr[i][0]) pq.poll();
            pq.add(arr[i][1]);
        }
        System.out.println(pq.size());
    }
}
