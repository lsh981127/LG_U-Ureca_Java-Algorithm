package Uplus_Java_BaekJoon.DynamicProgramming;

import java.util.*;
import java.io.*;

public class bj_14501 {
    static int day;
    static int[] time;
    static int[] money;
    static int max;

    static void day() {

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        day = Integer.parseInt(br.readLine());
        time = new int[day];
        money = new int[day];
        for(int i = 0; i <day; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
        }
    }
}
