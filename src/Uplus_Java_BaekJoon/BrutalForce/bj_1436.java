package Uplus_Java_BaekJoon.BrutalForce;
import java.util.*;
import java.io.*;

public class bj_1436 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int num = 665;
        while(count != N) {
            num++;
            if(String.valueOf(num).contains("666")) {
                count++;
            }
        }

        System.out.println(num);
    }

}
