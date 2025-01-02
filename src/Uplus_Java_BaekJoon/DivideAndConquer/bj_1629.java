package Uplus_Java_BaekJoon.DivideAndConquer;

import java.util.*;
import java.io.*;

public class bj_1629 {
    static long A, B, C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    static long pow(long value, long exp) {
        if(exp == 1) return value % C;

        long temp = pow(value, exp/2);
        if(exp % 2 == 1) {
            return (temp * temp % C) * value % C;
        }

        return temp * temp % C;

    }



}
