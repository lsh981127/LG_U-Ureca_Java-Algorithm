package Uplus_Java_BaekJoon.Graph;

public class 프로그래머스_순위 {
    public int solution(int n, int[][] results) {
        // ij = ik + kj
        // i가 J를 이기는지 확실히 알려면 i가 k를 이기고, K가 J를 이기면 확실하게 순위를 알 수 있어
        // 즉, 플로이드 와샬 알고리즘으로 파악이 가능하다
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        for(int i = 0; i < results.length; i++) {
            int[] temp = results[i];
            int start = temp[0];
            int end = temp[1];
            graph[start][end] = 1;
        }

        // 이긴 경우에 대해서만 1 부여
        // 그러면, 2가 3을 이기면

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(graph[i][j] == 1) continue;
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        int[] col = new int[n+1];
        int[] row = new int[n+1];
        for(int i = 1; i <= n; i++) {
            int count = 0;
            // 아 행으로만 4개면 다 이긴 줄 알았는데
            // 이기는 것만 명확한 게 아니라 지는 경우들에 대해서도 Count를 다해야 명확하게 순위를 알 수 있는 것!!
            // 고로, 가로, 세로열에 대해 다 카운트를 해야한다.
            for(int j = 1; j <= n; j++) {
                row[j] += graph[i][j];
                col[i] += graph[i][j];
            }
        }

        for(int i = 1; i <= n; i++) {
            int count = col[i] + row[i];
            if(count == n - 1) answer++;
        }

        return answer;
    }
}
