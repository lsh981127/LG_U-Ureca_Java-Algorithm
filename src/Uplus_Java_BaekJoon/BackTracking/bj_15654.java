package Uplus_Java_BaekJoon.BackTracking;
import java.util.*;
import java.io.*;
public class bj_15654 {
    static int N,M;
    static int[] array;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        sb = new StringBuilder();
        ArrayList<Integer> temp = new ArrayList<>();
        perm(0,0, temp);


        System.out.println(sb);;
    }


    static void perm(int x, int count, ArrayList<Integer> temp) {
        if(count == M) {
            for(Integer val : temp) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(array[i]);
                perm(array[i], count+1, temp);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }
}
