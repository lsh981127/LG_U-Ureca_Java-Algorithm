package Uplus_Java_BaekJoon.TwoPointer;
import java.util.*;
import java.io.*;
public class bj_30804 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] fruit = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            fruit[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, max = 0, count = 0;
        int f1 = fruit[start], f2 = fruit[end];

        while(end < N) {
            if(fruit[end] != f1 && fruit[end] != f2 && f1 != f2) { // 2가지 종류랑 다르면
                max = Math.max(max, count);
                count--;
                f1 = f2;
                start++;
            }
            f2 = fruit[end];
            end++;
            count++;
        }
        max = Math.max(max, count);

        System.out.println(max);
        br.close();

    }
}
