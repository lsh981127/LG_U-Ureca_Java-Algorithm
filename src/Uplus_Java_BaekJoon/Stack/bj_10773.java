package Uplus_Java_BaekJoon.Stack;

import java.util.*;
import java.io.*;
public class bj_10773 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int total = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < K; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val == 0) {
                total -= stack.pop();
                continue;
            }
            total += val;
            stack.push(val);
        }
        System.out.println(total);

    }
}
