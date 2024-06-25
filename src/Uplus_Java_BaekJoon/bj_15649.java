package Uplus_Java_BaekJoon;
import java.util.*;
import java.io.*;

public class bj_15649
{
    static int N;
    static int M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;

    static void perm(int count) {
        if (count == M) {       // M개를 이제 다 뽑았어
            System.out.println(Arrays.toString(result));
            return ;
        }

        for(int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result[count] = arr[i];
            perm(count + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        result = new int[M];

        for(int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        System.out.println(Arrays.toString(arr));
        perm(0);
        br.close();
    }

}
