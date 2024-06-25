package Uplus_Java_BaekJoon.CombinationAndPermutaion;

import java.io.*;

public class bj_3040 {
    static int[] num = new int[9];
    static int[] arr = new int[7];

    static void comb(int count, int start, int sum){
        if (count == 7) {
            if (sum == 100){
                for(int i = 0; i < arr.length;i++)
                    System.out.println(arr[i]);
            }
            return;
        }

        for (int i = start; i < num.length; i++) {
            arr[count] = num[i];
            comb(count+1, i+1, sum + num[i]);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        comb(0,0, 0);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int total =0;
//        for(int i = 0; i < num.length; i++) {
//            num[i] = Integer.parseInt(br.readLine());
//            total += num[i];
//        }
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = i + 1; j < 9; j++) {
//                if (total - num[i] - num[j] == 100) {
//                    for (int k = 0; k < 9; k++) {
//                        if (k == i || k == j) continue;
//                        System.out.println(num[k]);
//                    }
//                    return;
//                }
//            }
//        }

    }


}
