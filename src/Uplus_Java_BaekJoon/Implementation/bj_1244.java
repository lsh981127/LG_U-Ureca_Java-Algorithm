package Uplus_Java_BaekJoon.Implementation;

import java.io.*;
import java.util.*;

public class bj_1244 {
    static int[] arr;

    static void man(int start) {
        // start 가 3, index 는 2
        int i = 1;
        while (start * i <= arr.length) {
            if (arr[(start * i) - 1] == 1) arr[(start * i) - 1] = 0;
            else arr[(start * i) - 1] = 1;
            i++;
        }
    }

    static void woman(int start) {
        int i = 0;
        int index = start - 1;
        // start 3
        while(true) {
            if (index + i < arr.length && index - i >= 0) {
                if (arr[index + i] == arr[index-i]) {
                    if(arr[index + i] == 1) {
                        arr[index+i] = 0;
                        arr[index-i] = 0;
                    } else {
                        arr[index+i] = 1;
                        arr[index-i] = 1;
                    }
                    i++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }
    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("src/res/bj_1244.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // BufferedWriter를 써도 된다

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine()); // 스위치
        arr = new int[num];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int per = Integer.parseInt(br.readLine());
        int[][] person = new int[per][2];
        for(int i = 0; i < per; i++){
            st = new StringTokenizer(br.readLine(), " ");
            person[i][0] = Integer.parseInt(st.nextToken());    // 성
            person[i][1] = Integer.parseInt(st.nextToken());    // 시작 칸
        }

        for (int i = 0; i < per; i++) {
            int start = person[i][1];
            if (person[i][0] == 1) man(start);
            else woman(start);

        }

        for (int i = 1; i <= num; i++) {

            if (i != 0 && i % 20 == 0) {
                sb.append(arr[i-1]);
                sb.append("\n");

//                bw.write(arr[i-1]);
//                bw.append("\n");
            }

            else {
                sb.append(arr[i-1]).append(" ");
//                bw.append(arr[i-1]).append(" ");
            }

        }
        System.out.print(sb);

    }
}
