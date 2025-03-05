package Uplus_Java_BaekJoon;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

public class bj_1918 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] formula = br.readLine().toCharArray();
        Stack<Character> operator = new Stack<>();

        for(int i = 0; i < formula.length; i++) {
            if(formula[i] >= 'A' && formula[i] <= 'Z') sb.append(formula[i]);
            else {
                if(formula[i] == '(') operator.push(formula[i]);
                else if(formula[i] == ')') {
                    while(!operator.isEmpty() && operator.peek() != '(') {
                        //  ( 가 나올때까지 출력
                        sb.append(operator.pop());
                    }
                    // 이제 ( 차례, 이떄는 출력하지는 않기 때문에 그냥 스택에서 뽑아내기
                    if(!operator.isEmpty()) operator.pop();
                } else {
                    // 나머지 연산자들이면
                    // 1. 앞서 나온 연산자 vs 지금 연산자랑 우선순위 비교
                    // 만약, 앞서 나온 연산자(*)  지금 연산자 (+) 면, 앞서 나온 연산자가 먼저 출력되야지.
                    // 이 우선순위를 연산하도록 만든다
                    while(!operator.isEmpty() && check(operator.peek()) >= check(formula[i])) {
                        // 앞에 있는 연산자가 우선순위가 더 크면, 앞에 있는 애 출력
                        sb.append(operator.pop());
                    }
                    operator.push(formula[i]);
                }
            }
        }

        while(!operator.isEmpty()) {
            sb.append(operator.pop());
        }
        System.out.println(sb);
    }

    public static int check(char op) {
        if(op == '*' || op == '/') return 2;
        else if(op =='+' || op =='-') return 1;
        else return 0;   // 스택 안에 ( 가 있을 수도 있음 => 가장 낮은 우선순위 값을 줌으로써 스택에서 빠지지 않도록 만든다
    }

}
