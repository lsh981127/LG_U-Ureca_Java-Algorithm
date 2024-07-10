import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> comb = new HashMap<>();
        String[][] clothes;
        clothes = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        String[] participant = new String[]{"eden", "kiki"};
        int answer = 1;
        HashMap<String, Integer> closet = new HashMap<>();
        for(String[] cloth : clothes) {
            closet.put(cloth[1], closet.getOrDefault(cloth[1], 0) + 1);
            // 기존 replace 를 사용해서 값을 변경하려 했으나 put을 넣어야 동작하더라
        }
        for(Map.Entry<String, Integer> entry : closet.entrySet()) {
            answer *= entry.getValue() + 1;
        }
        System.out.println(answer -1);
    }
}
