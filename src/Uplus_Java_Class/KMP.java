package Uplus_Java_Class;

import java.util.*;

public class KMP {
    public static void main(String[] args) {
        String T = "ABABACAABABACAABABACA";

        /**
         * T = "ABCDABC"
         * P = " ABCDABC"
         *
         */
        String P = "ABABACA";
        int[] F = new int[P.length()];      // LIS? 인가 뭐시기인가
        // F는 Skip 배열
        // 패턴의 각 요소들이 반복되는 곳을 기록해두는 배열
        // 이 배열을 활용해서 ㅇ
        System.out.println(Arrays.toString(F));

        for(int t=1, p=0; t<P.length(); t++) {
            while(p>0 && P.charAt(t) != P.charAt(p)) p = F[p-1];
            if (P.charAt(t) == P.charAt(p)) F[t] = ++p;
            // p를 계속 0으로 보내면 처음부터 비교하는 거 => 브루트포스
            // KMP는 p 값부터 시작하기에 조금이라도 불필요한 부분을 빼려고
        }

        List<Integer> ans = new ArrayList<>();
        for(int t=0, p=0; t < T.length(); t++) {
            while(p>0 && T.charAt(t) != P.charAt(p)) p = F[p-1];
            if (T.charAt(p) == P.charAt(p)) {
                if(p == P.length() - 1) {       // 찾으면
                    ans.add(t-p);
                    p = F[p];
                } else {                        //못 찾으면
                    ++p;
                }
            }
        }
        System.out.println(ans.size());
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
