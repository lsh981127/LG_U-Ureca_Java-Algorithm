package Uplus_Java_BaekJoon.BackTracking;

import java.util.*;
import java.io.*;
public class bj_15663 {
    static int N, M;
    static int[] value;
    static int[] b;
    static boolean[] v;
    static HashSet<String> result = new HashSet<>();

    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        value = new int[N];
        b = new int[M];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(value);

        comb(0);
        // 백트래킹으로 작은 애들부터 차차 조합
    }

    static void comb(int count) {
        if(count == M) {
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < M; i++) {    // Deep copy
                temp.append(b[i]);
                temp.append(" ");
            }
            if(!result.contains(temp.toString())) {
                System.out.println(temp);
                result.add(temp.toString());
            }
            return ;
        }

        for(int i = 0; i < N; i++) {
            if(v[i]) continue;
            v[i] = true;
            b[count] = value[i];
            comb(count+1);
            v[i] = false;
        }
    }
}
