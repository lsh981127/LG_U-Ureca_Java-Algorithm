package Uplus_Java_Class;

import java.util.*;
import java.io.*;

public class permutation {
    static int N = 4, R = 3, C = 0;
    static int[] a = {1,2,3,4};         // a
    static int[] b = new int[R];        // R 개를 뽑기에
    static boolean[] v = new boolean[N];    // N개에 대한 방문 처리용

    static void perm(int cnt) {         // 몇 번 재귀호출인지 기록하기 위한 cnt
        if (cnt == R) {         // R만큼 했으면 멈추는 거지
            System.out.println(Arrays.toString(b));
            C++;
            return;
        }

        for(int i =0; i<N; i++) {
            /**
             * 중복 순열인 경우 => 이 코드에서 visited만 지워서 방문 처리 안하면 구현
             * 조합인 경우 => 4
             */
            if(v[i]) continue;
            v[i] = true;
            b[cnt] = a[i];
            perm(cnt + 1);      // 다음 거 뽑는 경우 진행히먄
            v[i] = false;           // 바로 해당 i를 방문 처리를 취소 => 별도의 재귀함수가 이미 돌고 있으니까 다시 초기화해주는 거야
        }

    }


    public static void main(String[] args) throws Exception {
        // 4P3 = 4! / (4-3)! 을 구현하기 위한 코드야
        // nPr = n! / (n-r)!
        // 코드로 구현하려면 팩토리얼을 일단 구현해야겠네 ㄴㄴ => 그냥 재귀
        C = 0;
        perm(0);
        System.out.println(C);

    }
}
