package Uplus_Java_BaekJoon.KMP;

import java.util.*;
import java.io.*;

public class bj_1786 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();

        int[] skip = new int[P.length()];

        for(int i = 1, j = 0; i < P.length(); i++) {
            while(j > 0 && P.charAt(i) != P.charAt(j)) j = skip[j-1];
            if(P.charAt(i) == P.charAt(j)) skip[i] = ++j;
        }



    }
}
