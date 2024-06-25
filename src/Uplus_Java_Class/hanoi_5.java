package Uplus_Java_Class;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hanoi_5 {
    static int total;
    static void hanoi(int goal, int x, int y, boolean bigMove) {
        // goal : 몇 번을 옮길지, x : 시작 봉, y : 끝 봉

        if (!bigMove && goal > 1) { //  제일 밑 원판을 제외하고 나머지를 중앙으로 이동
            // 기둥의 합이 1, 2, 3 = 6이기에 6 - 시작 - 끝을 통해 중앙 기둥을 찾을 수 있어!
            total++;
            hanoi(goal - 1, x, 6 - x - y, false);
        }

        // 이제 1개만 남은 경우, 제일 큰 애
        // 2. 제일 큰 애를 x -> y로 이동, 1 증가
        if (goal == 1) {
            total++;
        }
        // 3. 중앙(6-x-y - y)으로 goal -1개를 이동

        if (bigMove && goal > 1) {
            total++;
            hanoi(goal-1, 6-x-y, y, true);
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        total = 0;
        int n = 3;  // 원판 갯수
        // 1에서 3번으로 옮길거야
        hanoi(n, 1, 3, false);
        System.out.println(total);
    }
}
