package Uplus_Java_BaekJoon;
import java.util.*;
import java.io.*;
public class bj_13172 {
    static final int P = 1000000007;	//나머지 기준 값
    public static void main(String[] args) throws IOException{
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long N = 1, S = 0;
        //기댓값 합 구하기!
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            //각 분모와 분자를 통분하여 계산
            S = s * N + S * n;
            N *= n;
            //모듈러 산술로 인하여 나머지 계산
            S %= P;
            N %= P;

        }
        //기약 분수일 때
        if(S % N != 0)
            bw.write((search(N, P-2) * S) % P + "");
        else		//기약 분수가 아닐 때
            bw.write(S/N + "");
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //페르마 소정리, 모듈러 산술을 이용한 역원의 값 구하기!
    static long search(long N, int index) {
        if(index == 1)
            return N;
        long temp = search(N, index/2);
        if(index % 2 == 1)
            return temp * temp % P * N % P;
        else
            return temp * temp % P;
    }
}
