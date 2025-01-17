package Uplus_Java_BaekJoon;

import java.io.*;
import java.util.*;

public class bj_2448 {
    static int N;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][2*N - 1];
        for(char[] i : map) {
            Arrays.fill(i, ' ');
        }

        star(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for(char[] i : map) {
            sb.append(i);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void star(int x, int y, int count) {
        if(count == 3) {
            map[x][y] = '*';
            map[x+1][y-1] = map[x+1][y+1] = '*';
            map[x+2][y-2] = map[x+2][y-1] = '*';
            map[x+2][y] = map[x+2][y+2] = map[x+2][y+1] = '*';
            return;
        }

        int div = count / 2;
        star(x, y, div);
        star(x + div, y - div, div);
        star(x + div, y + div, div);
    }

}
