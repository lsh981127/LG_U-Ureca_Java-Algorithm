package Uplus_Java_Class.DP;

public class CoinGreedy {
    public static void main(String[] args) {
        int N = 8;
        int[] coin = {6,4,1};
        int cnt = 0;
        for(int i = 0; i < coin.length; i++) {
            int c = N / coin[i];
            cnt += c;

        }
        System.out.println(cnt);
    }
}
