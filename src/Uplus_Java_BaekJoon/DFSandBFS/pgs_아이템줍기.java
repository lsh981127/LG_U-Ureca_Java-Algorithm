package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;

public class pgs_아이템줍기 {

    public static void main(String[] args) {
        int[][] rectangle = {{1, 1,7,4}, {3,2,5,5},{4,3,6,9},{2,6,6,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
    }



    static int[][] graph;
    static boolean[][] v;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 테두리 : 1, 외부 : -1, 내부 : 0
        // 단, 중요한 점 : *2를 한 뒤, 거리를 /2 해야한다.
        // 왜? 테두리를 타고 가야하는데, BFS 방법으로 하면 테두리가 아니라 그냥 바로 인접한 1롤 가기 때문에 테두리를 가지 않는 경우가 있다.

        /** 반례
         *  테두리를 따라가는 예시(우리가 의도한 것)
         *  1 -> 1
         *       |
         *  1 <- 1
         *
         *  BFS로 인한 반례(= 바로 인접한 1로 이어감)
         *  - 해결책 : 각 좌표값을 2배해서 인접하더라도 테두리를 따라가도록 설정, 이동 거리 / 2를 통해서 최단 거리를 측정할 수 있다.
         *  1    1
         *  |
         *  1    1

         */

        /**
         그리고, 좌표와 2차원 배열 변환을 위해 X, Y 입력을 반대로 넣어준다.
         **/

        graph = new int[51 * 2][51 * 2];
        for(int[] i : graph) {
            // 전부 -1로 만들기
            Arrays.fill(i, -1);
        }
        v = new boolean[51 * 2][51 * 2];

        for(int i = 0; i < rectangle.length; i++) {
            // 크기를 2배로 했기 때문에 해당 좌표값들도 2배한 값을 넣어야한다.
            int[] rec = rectangle[i];
            int low_x = rec[0] * 2;
            int low_y = rec[1] * 2;
            int high_x = rec[2] * 2;
            int high_y = rec[3] * 2;
            setLine(low_y, low_x, high_y, high_x);
        }

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{characterY * 2, characterX * 2, 0});
        v[characterY * 2][characterX * 2] = true;
        int answer = 0;
        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            int cur_cost = cur[2];
            if(cur_x == itemY * 2 && cur_y == itemX * 2) {
                answer = cur_cost / 2;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];
                if(nx < 0 || nx >= 102  || ny < 0 || ny >= 102) continue;
                if(!v[nx][ny] && graph[nx][ny] == 1) {
                    dq.offer(new int[]{nx, ny, cur_cost+1});
                    v[nx][ny] = true;
                }
            }

        }

        return answer;
    }

    public static void setLine(int lx, int ly, int hx, int hy) {
        for(int i = lx; i <= hx; i++) {
            if(i == hx || i == lx) {   // 제일 위, 아래변 1로 설정
                for(int j = ly; j <= hy; j++) {
                    if(graph[i][j] == 0) continue;
                    graph[i][j] = 1;
                }
            } else {   // 중간에 있는 가로줄
                for(int j = ly; j <= hy; j++) {
                    if(graph[i][j] == 0) continue;
                    if(j == ly || j == hy) graph[i][j] = 1;  // 이미 양끝변이면 테두리이므로 1
                    else graph[i][j] = 0;    //  내부는 0로 체크
                }
            }
        }
    }

}
