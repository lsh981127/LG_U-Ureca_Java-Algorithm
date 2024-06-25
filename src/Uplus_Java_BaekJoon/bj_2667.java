package Uplus_Java_BaekJoon;
import java.util.*;
import java.io.*;

public class bj_2667 {

    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer>[] num;

    static int bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.offer(new int[]{i,j});
        int count = 1;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if(arr[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        count++;
                        q.offer(new int[]{nx, ny});

                    }
                }
            }
        }
        return count;

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        List<Integer> num = new ArrayList<>();

        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
//            char[] charr =  br.readLine().toCharArray();
            for(int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    int number = bfs(i, j);
                    num.add(number);
                }
            }
        }

        Collections.sort(num);
        System.out.println(num.size());
        for(int i = 0; i < num.size(); i++) {
            System.out.println(num.get(i));
        }

        br.close();
    }
}
