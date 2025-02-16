package Uplus_Java_BaekJoon;
import java.awt.List;
import java.util.*;
import java.io.*;

public class bj_14938 {
//    static ArrayList<ArrayList<Integer>> map;
    static int[][] map;
    static int MAX = 2000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];
        for(int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], MAX);
            map[i][i] = 0;
        }

        int[] items = new int[n+1];   // 지역별 아이템 갯수
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < n+1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[] max_item = new int[n+1];

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start][end] = cost;
            map[end][start] = cost;
        }


        for(int k = 1; k < n+1; k++) {
            for(int i = 1; i < n+1; i++) {
                for(int j = 1; j < n+1; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int max = 0;
        for(int i = 1; i < n+1; i++) {  // 각 지역별로 최대 값 구하기
            for(int j = 1; j < n+1; j++) {
                int dist = map[i][j];
                if(dist > m) continue;
                max_item[i] += items[j];
            }
            max = Math.max(max, max_item[i]);
        }
        System.out.println(max);


    }
}
