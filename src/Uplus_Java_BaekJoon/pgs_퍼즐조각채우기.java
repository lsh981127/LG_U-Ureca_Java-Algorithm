package Uplus_Java_BaekJoon;
import java.util.*;

public class pgs_퍼즐조각채우기 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int len;
    public static void main(String[] args) {

    }

    class Solution {
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};
        static int len;

        public int solution(int[][] game_board, int[][] table) {
            len = game_board.length;
            boolean[][] v = new boolean[len][len];

            List<List<int[]>> emptySpace = new ArrayList<>();
            List<List<int[]>> blocks = new ArrayList<>();

            for(int i = 0; i < len; i++) {
                for(int j = 0; j < len; j++) {
                    if(!v[i][j] && game_board[i][j] == 0) {
                        emptySpace.add(bfs(i, j, game_board, v, 0));
                    }
                }
            }

            v = new boolean[len][len];

            for(int i = 0; i < len; i++) {
                for(int j = 0; j < len; j++) {
                    if(!v[i][j] && table[i][j] == 1) {
                        blocks.add(bfs(i, j, table, v, 1));
                    }
                }
            }

            // 정규화까지 된 애들
            // 빈 공간에 대해 1) 해당 빈 공간의 크기와 일치하고, 2) 회전했을 때, 일치하는 경우 채워서 갯수 count 및 방문 처리

            boolean[] block_used = new boolean[blocks.size()];
            int answer = 0;
            for(List<int[]> space : emptySpace) {
                int size = space.size();
                for(int i = 0; i < blocks.size(); i++) {
                    if (block_used[i]) continue;   // 이미 사용한 블럭이면 skip
                    List<int[]> block = blocks.get(i);
                    if (size != block.size()) continue;  // 빈 공간과 블럭 크기가 맞지 않으면 skip

                    // 4번 회전시키면서 일치하면, 방문 처리 및 갯수 세고 continue
                    // 1. 회전
                    // 2. 일치 여부 판단
                    // 2-1. 일치하면 넣고 갯수 카운팅 후 블록 사용한 것으로 처리 => 끝

                    if (rotateCheck(space, block)) {
                        block_used[i] = true;
                        answer += size;
                        break;
                    }
                }
            }

            return answer;
        }


        // 특정 그래프와 값에 대해 BFS를 진행하고, 해당 조건에 맞는 공간을 찾아내는 BFS 함수 코드
        public List<int[]> bfs(int x, int y, int[][] graph, boolean[][] v, int checkValue) {
            Deque<int[]> dq = new ArrayDeque<>();
            List<int[]> path = new ArrayList<>();
            dq.offer(new int[]{x,y});
            v[x][y] = true;
            while(!dq.isEmpty()) {
                int[] temp = dq.poll();
                path.add(temp);
                int cx = temp[0];
                int cy = temp[1];

                for(int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if(nx < 0 || nx > len - 1 || ny < 0 || ny > len - 1) continue;
                    if(!v[nx][ny] && graph[nx][ny] == checkValue) {
                        v[nx][ny] = true;
                        dq.offer(new int[]{nx, ny});
                    }
                }
            }

            return normalize(path);

        }

        public List<int[]> normalize(List<int[]> data) {
            // 정규화 시키는 함수
            // 각 모양의 중간을 (1,1) 기준으로 만들어서 다른 모양들과 쉽게 비교할 수 잉ㅆ게 한다.

            int minX = 51;
            int minY = 51;

            for(int[] temp : data) {
                minX = Math.min(minX, temp[0]);
                minY = Math.min(minY, temp[1]);
            }

            for(int[] temp : data) {
                temp[0] -= minX;
                temp[1] -= minY;
            }

            return data;

        }

        public boolean rotateCheck(List<int[]> space, List<int[]> block) {
            List<int[]> rotated = block;
            for(int i = 0; i < 4; i++) {
                if(check(space, rotated)) {
                    return true;
                }
                rotated = rotate(rotated);
            }

            return false;

        }

        public boolean check(List<int[]> space, List<int[]> block) {
            /**
             * 정규화된 x 좌표끼리 같으면, x축 기준으로 오름차순 정렬하고
             * 각 모양의 좌표 순서를 맞추기 위해 정렬한다!!
             * 정렬하는 건, 왼쪽 위부터 오른쪽 아래 방향 순으로 정렬되는 것
             */

            Collections.sort(space, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            Collections.sort(block, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

            for(int i = 0; i < space.size(); i++) {
                int[] s = space.get(i);
                int[] b = block.get(i);
                if(s[0] != b[0] || s[1] != b[1]) {
                    return false;
                }
            }

            return true;
        }

        public List<int[]> rotate(List<int[]> block) {
            List<int[]> result = new ArrayList<>();
            int minX = 51;
            int minY = 51;

            for(int[] temp : block) {
                int x = temp[1];
                int y = temp[0] * -1;

                result.add(new int[]{x, y});
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
            }

            for(int[] temp : result) {
                temp[0] -= minX;
                temp[1] -= minY;
            }

            return normalize(result);
        }

    }
}
