package Uplus_Java_BaekJoon.Implementation;
import java.util.*;
import java.io.*;

public class bj_2578 {
    static int[][] player;

    static void check() {

    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 값과 해당 값의 좌표를 기록해주는 HashMap
        HashMap<Integer, int[]> map = new HashMap<>();

        player = new int[5][5];
        for(int i = 0; i <5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                int value = Integer.parseInt(st.nextToken());
                player[i][j] = value;
                map.put(value, new int[]{i, j});
            }
        }

        for(int i = 0; i <5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                int bingoValue = Integer.parseInt(st.nextToken());
                int[] place = map.get(bingoValue);
                player[place[0]][place[1]] = 0;     // 해당 위치값 초기화
//                => 여기에서 검사
            }
        }


    }
}
