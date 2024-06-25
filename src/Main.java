import java.util.*;
public class Main {
    static int N = 4, R = 3, C = 0;
    static int[] a = {1,2,3,4};         // a
    static int[] b = new int[R];        // R 개를 뽑기에

    static void perm(int cnt) {         // 몇 번 재귀호출인지 기록하기 위한 cnt
        if (cnt == R) {         // R만큼 했으면 멈추는 거지
            System.out.println(Arrays.toString(b));
            C++;
            return;
        }

        for(int i =0; i<N; i++) {
            b[cnt] = a[i];
            perm(cnt + 1);      // 다음 거 뽑는 경우 진행히먄
        }

    }


    public static void main(String[] args) throws Exception {
        String a = "0123";
//        System.out.println(a[0]);

    }
}
