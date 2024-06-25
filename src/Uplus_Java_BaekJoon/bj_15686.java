package Uplus_Java_BaekJoon;

import java.util.*;
import java.io.*;

public class bj_15686 {
    /**
     * M개에 대한 조합을 구한뒤, 각 조합에 대한 도시의 치킨 거이 값을 구해.
     * 그 이후로 최솟값을 비교해가는 방식으로 진행
     * @param args
     */

    static int N, M;            // 치킨 집 갯수, 몇 개까지만 존재
    static int[][] map;         // 지도
    static int[] chickenComb;   // 치킨 집 조합
    static List<int[]> chicken; //
    static List<int[]> house;
    static int chickenStreet = Integer.MAX_VALUE;

    static void comb(int count, int start) {
        if(count == M) {
            int city = 0;
            for(int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for(int j = 0; j < chickenComb.length; j++) {
                    int distance = Math.abs(chicken.get(chickenComb[j])[0] - house.get(i)[0]) + Math.abs(chicken.get(chickenComb[j])[1] - house.get(i)[1]);
                    if(temp > distance) temp = distance;
                }
                city += temp;
            }
            if(chickenStreet > city) chickenStreet = city;
            return;
        }

        for(int i = start; i < chicken.size(); i++) {
            chickenComb[count] = i;
            comb(count+1, i+1);

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickenComb = new int[M];
        chicken = new ArrayList<>();
        house = new ArrayList<>();

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) house.add(new int[]{i, j});
                else if(temp == 2) chicken.add(new int[]{i, j});
                map[i][j] = temp;
            }
        }

        comb(0,0);
        System.out.println(chickenStreet);
    }
}
