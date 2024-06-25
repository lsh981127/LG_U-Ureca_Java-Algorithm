package Uplus_Java_BaekJoon;
import java.io.*;
import java.util.*;

public class bj_1931 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int num = Integer.parseInt(br.readLine());

        // 배열에 값 다 넣기
        int[][] arr = new int[num][2];
        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i][0] = start;
            arr[i][1] = end;
        }

//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                // o1[1] - o2[1] : 끝나는 시간 기준 오름차순 정렬
//                // 만약 끝나는 시간이 동일하다면 시작하는 시간이
//                if (o1[1] == o2[1]) {
//                    return o1[0] - o2[0];
//                }
//
//                return o1[1] - o2[1];
//            }
//        });

        Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1]-o2[1]);

        int count = 0;                      // 진행 가능한 회의 갯수
        int prevEnd = 0;                    // 이전 회의 끝나는 시간 보관하는 변수
        for (int i = 0; i < num; i++) {
            if (arr[i][0] >= prevEnd) {     // 다음 회의 시작시간이 이전 회의 끝나는 시간 이후라면 회의 진행
                count++;
                prevEnd = arr[i][1];
            }
        }
        System.out.println(count);
    }
}
