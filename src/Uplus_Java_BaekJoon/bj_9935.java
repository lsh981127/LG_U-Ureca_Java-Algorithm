package Uplus_Java_BaekJoon;

import java.io.*;
import java.util.*;

public class bj_9935 {
    public static void main(String[] args) throws Exception {
        Stack<Character> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String bomb = br.readLine();

        int bombSize = bomb.length();

        for(int i = 0; i < origin.length(); i++) {
            stack.push(origin.charAt(i));
            if(stack.size() >= bombSize) {
                boolean flag = true;
                for(int j = 0; j < bombSize; j++) {
                    // stack 길이 - bomb 길이 + j = 새로운 문자가 들어갈때마다, 이전에 탐색했던 부분은 다시 탐색할 필요없도록 하기 위한 Index 처리
                    if(stack.get(stack.size() - bombSize + j) != bomb.charAt(j)) {
                        // bomb 길이만큼 탐색하다 일치하지 않는게 1개라도 나오면 바로 Break
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    // bombsize 와 일치하는 경우, bombsize 만큼 Pop
                    // 다시 실행해도 뒤에 문자들이 다시 쌓이는 것이기에 해당 부분부터 새로 시작
                    for(int k = 0; k< bombSize; k++) stack.pop();
                }
            }
        }

        if(stack.isEmpty()) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for(Character c : stack) sb.append(c);
            System.out.println(sb);
        }

//        boom(origin, bomb);
    }

//    static void boom(String result, String bomb) {
//        StringTokenizer st = new StringTokenizer(result, bomb);
//        if(st.countTokens() == 0) {
//            System.out.println("FRULA");
//            return;
//        } else if(st.countTokens() == 1) {
//            System.out.println(st.nextToken());
//            return;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while(st.hasMoreTokens()) {
//            sb.append(st.nextToken());
//        }
//
//        boom(sb.toString(), bomb);
//    }

}
