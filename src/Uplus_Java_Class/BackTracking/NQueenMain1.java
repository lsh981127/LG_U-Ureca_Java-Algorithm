package Uplus_Java_Class.BackTracking;

import java.util.Scanner;

public class NQueenMain1 {
    static int N, ans, col[];

    static boolean isAvailable(int row) {
        for (int i = 0; i < row; i++) {
            if(col[row] == col[i] ||
                    Math.abs(col[row] - col[i]) == row - i) return false;
        }

        return true;

    }

    static void nqueen(int row) {
        if(true) {
            // 백트래킹하려면
            // 특정 경우들에 대해 가지치기를 하면 되는 겨야
        }

        if(!isAvailable(row-1)) return;        // 가지치기

        if (row == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            col[row] = i;
//            if(isAvailable(row)) return;
            nqueen(row + 1);
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = 4;
        col = new int[4];
        ans = 0;
        nqueen(0);
        System.out.println(ans);

        sc.close();


    }
}
