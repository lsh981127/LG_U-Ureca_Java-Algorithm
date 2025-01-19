package Uplus_Java_BaekJoon.DisjointSetandUnion;

import java.util.*;
import java.io.*;

public class bj_1043 {
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());  // 사람
        int M = Integer.parseInt(st.nextToken());  // 파티
        int[] truth;
        ArrayList<Integer>[] party = new ArrayList[M];
        for(int i = 0; i < M; i++){
            party[i] = new ArrayList<>();
        }

        parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }



        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        if(T != 0) {
            truth = new int[T];
            for(int i = 0 ; i < T; i++){
                int temp = Integer.parseInt(st.nextToken());
                truth[i] = temp;
            }
        } else {  // 진실 아는 사람이 없어 => 그러면 그냥 모든 파티에서 과장
            System.out.println(M);
            return;
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int people = Integer.parseInt(st.nextToken());
            for(int j = 0; j < people ; j++){
                int temp = Integer.parseInt(st.nextToken());
                party[i].add(temp);
            }
        }


        for(int i = 0 ; i < M; i++){
            int first = party[i].get(0);
            for(int j = 1; j < party[i].size(); j++) {
                union(first, party[i].get(j));   // 각 파티의 파티원별로 다 union 시키는 과정
            }
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            int leader = party[i].get(0);
            boolean result = true;
            for(int j = 0; j < T; j++) {
                if(find(leader) == find(truth[j])) {  // 진실을 아는 애랑 같은 집합이면
                    // 진실을 아는 사람과 같은 집합이기에 과정 불가 => result false하고 break
                    result = false;
                    break;
                }
            }
            if(result) count++;
        }



        System.out.println(count);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) parent[y] = x;
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
