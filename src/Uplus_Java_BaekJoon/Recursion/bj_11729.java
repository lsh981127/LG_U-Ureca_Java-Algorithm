package Uplus_Java_BaekJoon.Recursion;
import java.util.*;
import java.io.*;
public class bj_11729 {
    static int total;
    static int n;
    static void hanoi(int goal, int x, int y) {
        // goal : 몇 번을 옮길지, x : 시작 봉, y : 끝 봉

        if (goal > 1) { //  제일 밑 원판을 제외하고 나머지를 중앙으로 이동
            // 기둥의 합이 1, 2, 3 = 6이기에 6 - 시작 - 끝을 통해 중앙 기둥을 찾을 수 있어!
            total++;
            hanoi(goal - 1, x, 6 - x - y);
            System.out.println(x + " " + (6 - x - y));
        }

        // 이제 1개만 남은 경우, 제일 큰 애
        // 2. 제일 큰 애를 x -> y로 이동, 1 증가
        if (goal == 1) {
            total++;
            System.out.println(x + " " + y);
        }
        // 3. 중앙(6-x-y - y)으로 goal -1개를 이동

        if (goal > 1) {
            total++;
            hanoi(goal-1, 6-x-y, y);
            System.out.println((6 - x - y) + " " + y);
        }
    }

    static void move(int no, int x, int y) {
        if(no>1) {
            move(no - 1, x, 6-x-y);
        }
        System.out.println(x + " " + y);

        if (no > 1) {
            move(no-1, 6-x-y,y);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        total = 0;
        n = Integer.parseInt(br.readLine());  // 원판 갯수
        // 1에서 3번으로 옮길거야
        move(n, 1, 3);

    }
}
