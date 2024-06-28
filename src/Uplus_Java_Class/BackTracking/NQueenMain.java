package Uplus_Java_Class.BackTracking;

import java.util.*;
import java.io.*;

public class NQueenMain {
    static int N, ans, col[];

    static boolean isAvailable(int row) {
        for (int i = 0; i < row; i++) {
            if(col[row] == col[i] ||
                    Math.abs(col[row] - col[i]) == row - i) return false;
        }

        return true;

    }

    static void nqueen(int row) {
        if (row == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            col[row] = i;
            if(isAvailable(row)) nqueen(row + 1);
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
