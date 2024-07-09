package Uplus_Java_BaekJoon.DFSandBFS;

import java.util.*;
import java.io.*;
public class bj_17471 {
    static int N;
    static int[] people;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] one;
    static int[] two;
    static int min = Integer.MAX_VALUE;

    static void comb(int cnt, int start, int num) {
        if(cnt == num) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < one.length; j++) {
                    if(i == one[j]) {
                        break;
                    }
                    two[i] = i;
                }
            }

            if(bfs(one) && bfs(two)) {
                int first = 0;
                int second = 0;
                for(int i: one) {
                    first += people[i];
                    second += people[i];
                    min = Math.min(min, Math.abs(first-second));
                }
            }
            return;
        }

        for(int i = start; i < N; i++) {
            one[cnt] = i;
            comb(cnt + 1, start+1, num);
        }
    }

    static boolean bfs(int[] arr) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int cnt = arr.length - 1;
        visited[arr[0]] = true;
        queue.offer(arr[0]);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int i : graph[node]) {
                for(int j: arr){
                    if(!visited[j])
                        if(i==j) {
                            visited[j] = true;
                            cnt--;
                            queue.offer(j);
                            break;
                        }

                }
            }
        }
        if (cnt == 0) return true;
        return false;

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        people = new int[num];
        graph = new List[num];
        for(int i = 0; i < num; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[num];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < num; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int temp = Integer.parseInt(st.nextToken());
            for(int j = 0; j < temp; j++) {
                int con = Integer.parseInt(st.nextToken()) - 1;
                graph[i].add(con);
            }
        }

        for(int i = 1; i <= N/2; i++) {
            one = new int[i];
            two = new int[N-i];
            comb(0, 0,i);
        }

        br.close();
    }
}
