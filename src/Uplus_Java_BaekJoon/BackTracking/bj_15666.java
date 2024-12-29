package Uplus_Java_BaekJoon.BackTracking;

import java.util.*;
import java.io.*;

public class bj_15666 {
    static int N, M;
    static int[] numbers;
    static boolean[] v;
    static HashSet<String> set = new HashSet<>();
    static int[] array;
    public static void main(String[] args) throws Exception{
        // 오름차순으로 중복 순열을 허용하라는 뜻
        // 순열 돌리면서 HashSet에 저장해서 존재하는 지 여부에 따라 관리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        array = new int[M];
        v = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        perm(0);


    }

    static void perm(int count) {
        if(count == M) {
            String temp = makeString(array);
            if(!set.contains(temp)) {
                System.out.println(temp);
                set.add(temp);
            }
            return ;
        }

        for(int i = 0; i < N; i++) {
            if(count > 0 && numbers[i] < array[count-1]) continue;
            array[count] = numbers[i];
            perm(count + 1);
        }
    }


    static String makeString(int[] temp) {
        StringBuilder sb = new StringBuilder();
        for(int i : temp) {
            sb.append(i + " ");
        }
        return sb.toString();
    }

}
