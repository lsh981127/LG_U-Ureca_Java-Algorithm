package Uplus_Java_BaekJoon;
import java.util.*;
import java.io.*;

public class bj_11444 {
    final static long MOD = 1000000007;
    public static long[][] origin = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long[][] A = {{1, 1}, {1, 0}};

        System.out.println(pow(A, N-1)[0][0]);

    }


    public static long[][] pow(long[][] A, long exp) {

        if(exp == 1 || exp == 0) {
            return A;
        }

        // 절반으로 분할 => 재귀
        long[][] ret = pow(A, exp / 2);


        // 절반으로 분할한 값을 제곱해서 원복하기

        ret = multiply(ret,ret);
        if(exp % 2 == 1L) {  // 지수가 홀수값이면, 1번 더 곱해줘야지
            ret = multiply(ret, origin);
        }

        return ret;

    }

    public static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] ret = new long[2][2];

        ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
        ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
        ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
        ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;

        // 반복문으로 작성해주어도 무방함
		/*
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		*/
        return ret;
    }

}
