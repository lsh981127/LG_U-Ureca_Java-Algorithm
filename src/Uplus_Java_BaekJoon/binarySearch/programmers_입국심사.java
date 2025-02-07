package Uplus_Java_BaekJoon.binarySearch;
import java.util.*;
public class programmers_입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);  // 혹시 모르니 시간 정렬

        long start = 0;
        long end = times[0] * (long) n;  // 제일 빨리 끝나는 애한테 모든 애들이 검사받는 경우를 최대로 가정
        // 제일 빠른 심사관으로 모든 애들을 진행하는 경우로도 최대가 되기 때문에

        // 틀린 사유 : n 값을 (long) 강제 형변환 시키지 않아서 틀림
        // 왜? times[0] * n 연산은 int 타입으로 연산이 된다.
        // 즉, end 값이 오버플로우 발생해서 30억인 경우, -xx 값으로 저장되서 잘못된 값이 저장된다. => 그래서 틀리게 된다.
        // 고로, 강제 형변환을 진행해 올바른 end값 (30억) 으로 진행해야 이진탐색이 정상적으로 동작해 문제를 해결할 수 있다.

        long answer = 0;  // 최소 시간 저장용 변수

        while(start <= end) {   // 이진탐색 진행
            long mid = (start + end) / 2;
            long count = 0;     // 입국 심사를 진행할 수 있는 사람의 수

            for(int i = 0; i < times.length; i++) {
                if(times[i] > mid) break;
                count += mid / times[i];  // mid라는 시간동안 각 심사관이 몇 명을 처리할 수 있는지 누적한다.
            }

            if(count < n) {    // 처리할 수 있는 사람 수가 적으면 시간을 늘리고
                start = mid + 1;
            } else {           // "최소"를 찾는 것이 목표기 때문에 n명을 만족한 경우를 대비해 answer에 저장하고 end는 mid - 1로 최신화하는 것
                // 처음에 그냥 end = mid로 하고 return end 하려 했는데 이러면 start와 end가 1 차이날때, 무한 루프를 돌기때문에 안됨.
                // 별도의 값을 저장해둬야 성공적으로 이진탐색을 마무리 + 최소한의 시간을 보장할 수 있게된다.
                end = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}
