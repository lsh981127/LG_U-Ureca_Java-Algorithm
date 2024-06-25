package Uplus_Java_BaekJoon;
import java.util.*;
import java.io.*;

public class bj_16935 {
    static int[][] arr;

    static void form1() {
        int x = arr.length;
        int y = arr[0].length;
        int[][] temp = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i][j] = arr[x - 1 - i][j];
            }
        }
        arr = temp;
    }

    static void form2() {
        int x = arr.length;
        int y = arr[0].length;
        int[][] temp = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[i][j] = arr[i][y-1-j];
            }
        }
        arr = temp;
    }

    static void form3() {           // 우로 90
        int x = arr.length;
        int y = arr[0].length;

        int[][] temp = new int[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[j][x-i-1] = arr[i][j];
            }
        }

        arr = temp;
    }

    static void form4() {           // 좌로 90
        int x = arr.length;
        int y = arr[0].length;

        int[][] temp = new int[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp[y-j-1][i] = arr[i][j];
            }
        }

        arr = temp;
    }

    static void form5() {
        int x = arr.length;
        int y = arr[0].length;
        int[][] temp = new int[x][y];

        int half_x = x / 2;
        int half_y = y / 2;

        for(int i = 0; i < half_x; i++) {  // 1- > 2번 구역 작성
            for(int j = 0; j < half_y; j++) {
                temp[i][half_y + j] = arr[i][j];
            }
        }

        for(int i = 0; i < half_x; i++) {  // 2 - > 3번 구역 작성
            for(int j = half_y; j < y; j++) {
                temp[half_x+i][j] = arr[i][j];
            }
        }


        for(int i = half_x; i < x; i++) {  // 3 - > 4번 구역 작성
            for(int j = half_y; j < y; j++) {
                temp[i][j - half_y] = arr[i][j];
            }
        }

        for(int i = half_x; i < x; i++) {  // 1번 구역 작성
            for(int j = 0; j < half_y; j++) {
                temp[i-half_x][j] = arr[i][j];
            }
        }

        arr = temp;
    }

    static void form6() {
        int x = arr.length;
        int y = arr[0].length;
        int[][] temp = new int[x][y];

        int half_x = x / 2;
        int half_y = y / 2;

        for(int i = 0; i < half_x; i++) {  // 4번 구역 작성
            for(int j = 0; j < half_y; j++) {
                temp[i + half_x][j] = arr[i][j];
            }
        }

        for(int i = half_x; i < x; i++) {  // 4 -> 3
            for(int j = 0; j < half_y; j++) {
                temp[i][j+half_y] = arr[i][j];
            }
        }


        for(int i = half_x; i < x; i++) {  // 3 - > 2
            for(int j = half_y; j < y; j++) {
                temp[i-half_x][j] = arr[i][j];
            }
        }

        for(int i = 0; i < half_x; i++) {  // 2번 -> 1
            for(int j = half_y; j < y; j++) {
                temp[i][j-half_y] = arr[i][j];
            }
        }

        arr = temp;
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/res/bj16935.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        arr = new int[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < count; i++) {
            int form = Integer.parseInt(st.nextToken());

            switch (form) {
                case 1:
                    form1();
                    break;
                case 2:
                    form2();
                    break;
                case 3:
                    form3();
                    break;
                case 4:
                    form4();
                    break;
                case 5:
                    form5();
                    break;
                case 6:
                    form6();
                    break;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }


        System.out.println(sb.toString());
    }
}
