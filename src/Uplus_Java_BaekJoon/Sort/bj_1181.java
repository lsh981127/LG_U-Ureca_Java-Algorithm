package Uplus_Java_BaekJoon.Sort;

import java.util.*;
import java.io.*;

public class bj_1181 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] arr = new String[num];

        for(int i = 0; i < num; i++) {
            String temp = br.readLine();
            arr[i] = temp;
        }

        Arrays.sort(arr, (String o1, String o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());

        for(int i = 0; i < num; i++) {
            if(i != 0){
                if (arr[i].equals(arr[i-1])) {
                    continue;
                }
            }
            System.out.println(arr[i]);
        }
//        for(int i = 0; i < num; i++) System.out.println(arr[i]);
    }
}
