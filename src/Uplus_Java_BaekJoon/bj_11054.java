package Uplus_Java_BaekJoon;
import java.util.*;
import java.io.*;

public class bj_11054 {
    static int[] number;
    static int N;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = LIS();
        int[] lds = LDS();
        // sol) LIS와 LDS를 구해두고 이에 대한 연산 진행
        // 단, LIS와 LDS는 각각 본인워 index를 포함한 부분 수열이기에 각 index 값에서 1을 빼야한다(중복되기 때문에)
        // LDS는 LIS 진행 방향을 그냥 역순으로 진행하면 된다. => 0 ~ N-1 방향을, N-1 -> 0으로 진행하면 돼

        int[] dp = new int[N];
        int max = 1;
        for(int i = 0; i < N; i++){
            dp[i] = lis[i] + lds[i] - 1;
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }

    public static int[] LIS(){
        int[] lis = new int[N];
        for(int i = 0; i < N; i++) {
            lis[i] = 1;
            for(int j = 0; j < i; j++) {
                if(number[i] > number[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        return lis;
    }

    public static int[] LDS(){
        int[] lds = new int[N];
        for(int i = N-1; i >= 0; i--) {
            lds[i] = 1;
            for(int j = N-1; j > i; j--) {
                if(number[i] > number[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        return lds;
    }
}
