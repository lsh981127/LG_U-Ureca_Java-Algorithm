package Uplus_Java_BaekJoon.BackTracking;


import java.io.*;
import java.util.*;

public class bj_14888 {
    static int N;
    static int[] num;
    static int[] operator = new int[4];

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void comb(int count, int curVal) {
        if (count == N) {
            max = Math.max(max, curVal);
            min = Math.min(min, curVal);
        }

        for(int i = 0; i < 4; i++) {
            if(operator[i] == 0) continue;
            operator[i]--;
            switch(i) {
                case 0:         // +
                    comb(count + 1, curVal + num[count]);
                    break;
                case 1:         // -
                    comb(count + 1, curVal - num[count]);
                    break;
                case 2:         // *
                    comb(count + 1, curVal * num[count]);
                    break;
                case 3:         // /
                    comb(count + 1, curVal / num[count]);
                    break;
            }
            operator[i]++;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());   // 숫자 값

        num = new int[N];                       // 숫자 보관

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++) {        // 조합을 써야해
            operator[i] = Integer.parseInt(st.nextToken());
        }


        comb(1,num[0]);
        System.out.println(max);
        System.out.println(min);




    }
}
