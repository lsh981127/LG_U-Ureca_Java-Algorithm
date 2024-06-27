package Uplus_Java_BaekJoon.Queue;

import java.util.*;
import java.io.*;

public class bj_2164 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        for(int i = 1; i <= val; i++) arr.add(i);

        while(arr.size() > 1) {
            arr.poll();
            int temp = arr.poll();
            arr.offer(temp);
        }
        System.out.println(arr.poll());
    }
}
