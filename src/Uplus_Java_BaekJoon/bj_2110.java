package Uplus_Java_BaekJoon;
import java.util.*;
import java.io.*;

public class bj_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] house = new int[N];

        for(int i = 0; i < N; i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int start = 0;
        int end = house[N-1];  // 최대값
        int result = 0;
        // 가장 인접한 공유기간 거리의 최댓값을 구하는 문제!!
        while(start <= end) {
            int mid = (start + end) / 2;
            int count = 1; // 집 갯수
            int prev = house[0];  // 이전에 공유기를 설치한 지점
            for(int i = 0; i < N; i++) {
                if(house[i] - prev >= mid) {
                    count++;
                    prev = house[i];
                }
                if(house[i] - prev < mid) continue; // 인접한 애들보다 작으면 PASS

                if(count > C) break;
            }

            if(count >= C) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);

    }
}
