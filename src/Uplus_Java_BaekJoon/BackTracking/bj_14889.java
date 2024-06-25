package Uplus_Java_BaekJoon.BackTracking;
import java.util.*;
import java.io.*;
public class bj_14889 {

    static int[][] arr;             // 점수판
    static int[] num;               // 사람 1~ people 까지
    static int people;              // 사람 수
    static int min = Integer.MAX_VALUE;
    static int[] team;              // 팀원
    static List<Integer> scoreList = new ArrayList<>();

    static void comb(int count, int start) {
        if (count == people/2) {
            // team에 지금 조합 들어 가있음
            int teamScore = 0;
            for(int i = 0; i < team.length; i++) {
                for(int j = 0; j < team.length; j++) {
                    if(i == j) continue;
                    teamScore += arr[team[i]-1][team[j]-1];
                }
            }

            scoreList.add(teamScore);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            team[count] = num[i];
            comb(count + 1, i + 1);
        }
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        people = Integer.parseInt(br.readLine());
        arr = new int[people][people];
        num = new int[people];
        team = new int[people/2];

        for (int i = 0; i < people; i++) {
            num[i] = i+1;
        }

        for (int i = 0; i < people; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < people; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);

        int len = scoreList.size();
        for(int i = 0; i < len/2; i++) {
            min = Math.min(min, Math.abs(scoreList.get(i) - scoreList.get(len - i - 1)));
        }

        System.out.println(min);

    }
}
