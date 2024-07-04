package Uplus_Java_Class.MST.Prim;

import java.io.FileInputStream;
import java.util.*;

public class PrimMain {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Uplus_Java_Class/Prim/PrimInput.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<int[]>[] g = new List[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 인접 리스트 형태로 i : from, j : to, se.nextInt() : cost
                int c = sc.nextInt();
                if(c!= 0) g[i].add(new int[]{j, c});
            }
        };

        boolean[] v = new boolean[N];
        int[] minEdge = new int[N];                  // 현재 진행하는 상황에서 index 번호 노드까지의 최소 가중치를 기록하는 배열
//        Arrays.fill(minEdge, Integer.MAX_VALUE/2); // 메모리 터지는 거 방지하기 위해 2로 나눔
        for(int i = 0; i < N; i++) minEdge[i] = Integer.MAX_VALUE;

        int sum = 0, cnt = 0;
        minEdge[0] = 0;
        for(int i = 0; i < N; i++) {
            int minVertex = -1;                 // 최소 가치를 가지는 노드 기록 변수
            int min = Integer.MAX_VALUE;        // 최소 가치
            for(int j = 0; j < N; j++) {
                if(!v[j] && min > minEdge[j]) {     // 방문을 안했고 현재 해당 노드까지 최소 가중치보다 더 작으면
                        min = minEdge[j];
                        minVertex = j;
                }
            }
            v[minVertex] = true;
            sum += min;

            if(cnt++ == N-1) break;
            for(int[] j: g[minVertex]) {
                if(!v[j[0]] && minEdge[j[0]] > j[1]) {
                    minEdge[j[0]] = j[1];
                }
            }
//            System.out.println(Arrays.toString(minEdge));
        }
        System.out.println(sum);
        sc.close();

    }
}