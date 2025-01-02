package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;
public class bj_16953 {
    static int answer = (int) 10e9;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         *  왜 값 타입을 Long 으로 해야하는가?
         *
         *  A가 5억일떄, * 10 + 1 연산이 진행된다면, 50억 + 1이 진행된다. 즉 Overflow 발생
         *
         */
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        cal(A, B, 0);
        if(answer != (int) 10e9) System.out.println(answer + 1);
        else System.out.println(-1);

    }

    static void cal(long current, long B, int count) {
        if(current > B) return ;
        if(current == B) {
            if(answer > count) answer = count;
            return ;
        }

        cal(current * 2, B, count+1);
        cal(current * 10 + 1, B, count+1);

    }
}
