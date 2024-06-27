package Uplus_Java_BaekJoon.LinkedList_ListIterator;

import java.util.*;
import java.io.*;

public class bj_5397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());

        for(int i = 0; i < test; i++) {
            String temp = br.readLine();
            List<Character> list = new LinkedList<>();
            ListIterator<Character> li = list.listIterator();

            // 어차피 값들을 1개씩 넣어주면서 커서를 이동하기 때문에 처음부터 list에 값을 넣어둘 필요가 없다!
            for(char c : temp.toCharArray()) {
                switch (c) {
                    case '<':
                        if(li.hasPrevious()) li.previous();
                        break;
                    case '>':
                        if(li.hasNext()) li.next();
                        break;
                    case '-':
                        if(li.hasPrevious()) {
                            li.previous();
                            li.remove();
                        }
                        break;
                    default:
                        li.add(c);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(Character c : list) sb.append(c);
            System.out.println(sb.toString());
            // 출력 시, StringBuilder를 사용해서 출력을 하면 된다.
        }
        br.close();
    }
}
