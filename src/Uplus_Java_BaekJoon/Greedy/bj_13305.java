package Uplus_Java_BaekJoon.Greedy;

import java.util.*;
import java.io.*;

public class bj_13305 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        int[] distance = new int[num-1];    //
        int[] city = new int[num-1];          // 근데 마지막 어차피 안쓰지 않나?
        int distanceTotal = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num-1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
            distanceTotal += distance[i];
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num-1; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }


        int min = city[0];
        int total = distance[0] * min;
        distanceTotal -= distance[0];
        for(int i = 1; i < num-1; i++) {
            if (min > city[i]) {
                min = city[i];
            }
            if (min == 1) {
                total += distanceTotal;
                break;
            }

            total += distance[i] * min;
            distanceTotal -= distance[i];
        }

        System.out.println(total);


    }
}
