package Uplus_Java_BaekJoon.LinkedList_ListIterator;

import java.util.*;
import java.io.*;

public class bj_1406 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String sentence = br.readLine();

        /**
         *  List Iterator란?
         *
         *  Iterator 인터페이스를 상속받은 인터페이스
         *  - 컬렉션의 요소에 접근할 때, 한 방향으로만 이동할 수 있다.
         *  - 컬렉션 요소 대체, 추가, 인덱스 검색 등을 지원
         */


        // 풀이 1: ListIterator 쓴 경우
        List<Character> li = new LinkedList<>();
        for(char c: sentence.toCharArray()) {
            li.add(c);
        }
        ListIterator<Character> liIter = li.listIterator(li.size());

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            switch (cmd) {
                case 'P':
                    char ch = st.nextToken().charAt(0);
                    liIter.add(ch);
                    break;
                case 'L':
                    if(liIter.hasPrevious()) liIter.previous();
                    break;
                case 'D':
                    if(liIter.hasNext()) liIter.next();
                    break;
                case 'B':
                    // remove는 next()나 pevious() 메소드에 의해 반환된 가장 마지막 요소를 제거해!
                    if(liIter.hasPrevious()) {
                        liIter.previous();
                        liIter.remove();
                    }
                    break;
            }
        }

        for(Character c: li) bw.write(c);
        bw.flush();
        br.close();
        bw.close();



    }
}
