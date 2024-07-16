package Uplus_Java_BaekJoon;
import java.util.*;
import java.io.*;
public class bj_18870 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> hm = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int[] sorted = new int[N];
        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            sorted[i] = temp;
        }

        Arrays.sort(sorted);

        int start = 0;
        for(int i : sorted){
            if(!hm.containsKey(i)) {
                hm.put(i, start);
                start++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : arr) {
            sb.append(hm.get(i)).append(" ");
        }

        System.out.print(sb);
        br.close();

    }
}
