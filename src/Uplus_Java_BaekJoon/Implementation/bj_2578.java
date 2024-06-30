package Uplus_Java_BaekJoon.Implementation;
import java.util.*;
import java.io.*;

public class bj_2578 {
    static int[][] player;
    static int total = 0;
    static int count = 0;

    static int check() {
        int temp = 0;
        int current = 0;

        for(int i = 0; i < player.length; i++) {        // 행에 대한 검사
            temp = 0;
            for(int j: player[i]) {
                if(j != 0) break;
                temp++;
            }
            if(temp == player.length) current++;
        }

        for(int i = 0; i < player.length; i++) {       // 열에 대한 검사
            temp = 0;
            for(int j = 0; j < player.length; j++) {
                if(player[j][i] != 0) break;
                temp++;
            }
            if(temp == player.length) current++;
        }

        temp = 0;
        for(int i = 0; i < player.length; i++) {        // 우하양 대각선
            if(player[i][i] != 0)
                break;
            temp++;
            if(temp == player.length) current++;
        }

        temp = 0;
        for(int i = 0; i < player.length; i++) {        // 좌하양 대각선
            if(player[i][player.length - i - 1] != 0)
                break;
            temp++;
            if(temp == player.length) current++;
        }

        return current;
    }


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj_2578.txt"));
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

        for(int i = 0; i < player.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < player.length; j++) {
                int bingoValue = Integer.parseInt(st.nextToken());
                int[] place = map.get(bingoValue);
                player[place[0]][place[1]] = 0;     // 해당 위치값 초기화
                count++;
                if (check() >= 3) {
                    System.out.println(count);
                    System.exit(0);
                }
                //  => 여기에서 검사

            }
        }


    }
}
