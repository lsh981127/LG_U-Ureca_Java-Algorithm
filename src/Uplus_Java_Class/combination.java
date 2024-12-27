package Uplus_Java_Class;

import java.util.Arrays;

public class combination {
    static int N = 4, R = 2, C = 0;
    static int[] a = {1,2,3,4};
    static int[] b = new int[R];
    static boolean[] v = new boolean[N];

    static void comb(int cnt, int start) {
        if (cnt == R) {
            System.out.println(Arrays.toString(b));
            C++;
            return;
        }

        for(int i = start; i<N; i++) {
            b[cnt] = a[i];
            comb(cnt + 1, i+1);
        }
        // cnt 는 현재 R개 중에 몇 개를 진행하고 있는지를 판단하는 것
        // start 는 어느 index부터 시작하는지

    }


    public static void main(String[] args) throws Exception {
        C = 0;
        comb(0, 0);
        System.out.println(C);

    }

}
