package Uplus_Java_Class;

import java.util.ArrayDeque;
import java.util.Arrays;

public class BFSandDFSReturn {
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};
    // di,dj의 방향 : 하 상 우 좌

    static int N = 5, C= 0;
    static int[][] a;
    static boolean[][] v;
    static ArrayDeque<Integer> deque;


    static int dfs(int x, int y) {
        int cnt = 1;
        v[x][y] = true;
        a[x][y] = C++;
        for(int d =0; d < 4; d++) {
            int ni = x + di[d];
            int nj = y + dj[d];
            if(ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj]) {
                cnt += dfs(ni, nj);
            }
        }
        return cnt;
    }

    static int bfs(int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[x][y] = true;
        q.offer(new int[]{x, y});
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] ij = q.poll();
            int i = ij[0];
            int j = ij[1];
            a[i][j] = C++;
            for(int []b: a) System.out.println(Arrays.toString(b)); System.out.println();
            for(int d =0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if(ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj]) {
                    /**
                     * 방문처리하고 큐에 넣어야 큐에 들어가는 수를 줄일 수 있다? 라고 하시네
                     * 큐 넣고 방문처리하면 while문에 poll한 뒤, 방문 여부 검사를 또 해줘야함.
                     *
                     * 그래야 나중에 우선순위 큐에서 큐가 안터지게 할 수 있다? 뭐 그렇다고 하심
                     */
                    v[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                    cnt++;
                }
            }
        }


        v[x][y] = true;
        a[x][y] = C++;
        return cnt;
    }


    public static void main(String[] args)  throws Exception{
        a = new int[N][N];
        v = new boolean[N][N];
        C = 1;
        deque = new ArrayDeque<>();
        System.out.println(dfs(N/2, N/2));
//        System.out.println(bfs(N/2, N/2));


    }
}
