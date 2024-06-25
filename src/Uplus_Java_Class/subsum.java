package Uplus_Java_Class;

import java.util.Arrays;

public class subsum {
    static int N = 4, C = 0;
    static int[] a = {1,2,3,4};

    /**
     *   visited를 사용한 방식
     */
//    static boolean[] v = new boolean[N];
//    static void subs(int cnt) {
//        if (cnt == N) {
//            C++;
//            for(int i = 0; i<N; i++) System.out.print((v[i]?a[i]:0) + " ");
//            System.out.println("");
//            return;
//        }
//
//        v[cnt] = true;        // 이게 선택하는 부분
//        subs(cnt + 1);
//        v[cnt] = false;       // 이게 비선택하는 부분
//        subs(cnt+1);
//    }


    /**
     *
     * @param cnt : 카운트
     * @param str : 부분집합을 기록하는 매개변수
     */
    static void subs(int cnt, String str) {

        if (cnt == N) {
            C++;
            System.out.println(str);
            return;
        }
        subs(cnt + 1, str + a[cnt]);    // 선택한 경우, 매개변수에 현재 값을 추가
        subs(cnt+1, str);                   // 선택 안한 경우, 현재 값 제외하고 진행
    }

    public static void main(String[] args) throws Exception {
        subs(0, "");
        System.out.println(C);
    }
}
