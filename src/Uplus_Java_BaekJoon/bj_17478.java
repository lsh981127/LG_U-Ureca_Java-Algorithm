package Uplus_Java_BaekJoon;

import java.io.*;
import java.util.*;

public class bj_17478 {
    static int num;         // 실행 횟수

    static void recur(int count, boolean decrease) {        // count : 진행 횟수, decrease : count가 Num 횟수만큼 도달하고 감소하는 여부
        if (count < 0) {        // 무한 재귀 막는 용
            return ;
        }

        StringBuilder sb = new StringBuilder();         // 멘트용 StringBuilder
        StringBuilder o = new StringBuilder();          // ____ 용 StringBuilder
        for (int i = 0; i < count; i++) {               // count 만큼 ____를 추가
            o.append("____");
        }

        if (decrease) {                                 // 감소하는 경우, ____ 와 답변하는 부분만
            System.out.println(o + "라고 답변하였지.");
            recur(count-1, true);
            return ;
        }
        if (count == num) {                             // num + 1 만큼 진행한 경우
            sb.append(o).append("\"재귀함수가 뭔가요?\"").append("\n");
            sb.append(o).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
            sb.append(o).append("라고 답변하였지.");
            System.out.println(sb);
            recur(count-1, true);       // 매개변수 값을 1씩 감소시키고 true로 변환
            return ;
        }

        sb.append(o).append("\"재귀함수가 뭔가요?\"").append("\n");
        sb.append(o).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
        sb.append(o).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
        sb.append(o).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        System.out.println(sb);
        recur(count + 1, false);

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recur(0, false);
        br.close();
    }

}
