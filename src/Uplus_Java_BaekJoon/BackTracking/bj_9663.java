package Uplus_Java_BaekJoon.BackTracking;

import java.util.*;
import java.io.*;

public class bj_9663 {
    static int total;
    static int N;
    static int[] col;   // index별, 즉 퀸(열)별 위치하는 행

    static boolean rowCheck(int row) {
        // row 번째 퀸에 대한 검사를 진행
        // row 번째 퀸의 열은 col[row]
        // 고로, 1. 앞에서 선언된 퀸의 열과 동일한지 (세로 일치하는 경우)
        // 2. 퀸들의 행은 어차피 다 다르기에 (x1 - x2)의 절댓값 == (y1-y2)의 절댓값이면 대각선에 위치한다는 거니까 false
        // 해당 조건을 안만족하면 그 위치에는 퀸이 존재할 수 있다는 것!

        for(int j = 0; j < row; j ++) {
            if(col[row] == col[j] ||
                    (Math.abs(col[row] - col[j]) == Math.abs(row - j))) return false;
        }
        return true;
    }

    static void MoveQueen(int num) {
        if(num == N) {          // 모든 행에 대해 퀸이 도착을 했다는 것
            total++;
            return;
        }

        // num 번째 퀸의 열을 0 ~ N까지 돌리면서 검사를 진행하는 거야
        for(int j = 0; j < N; j++) {
            col[num] = j;       // num 번째 퀸의 열을 j로 계속 바꿔준다.
            // 각 퀸들에 대해 같은 열인지 + 대각선인지 검사한 후, true면 다음 퀸 진행
            if(rowCheck(num)) MoveQueen(num + 1);


        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N];       // 퀸의 행 기록용
        total = 0;
        MoveQueen(0);       // 0번 열부터 퀸이 있는 걸로 시작
        System.out.println(total);
        sc.close();
    }


}
