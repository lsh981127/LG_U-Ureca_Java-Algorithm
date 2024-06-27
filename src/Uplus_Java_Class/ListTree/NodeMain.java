package Uplus_Java_Class.ListTree;
import java.util.*;
import java.io.*;

public class NodeMain {
    static class Node{
        int vertex;     // 정점 번호
        Node link;      // 다음 정점

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }

        @Override
        public String toString() {
            return vertex + " -> " + link;
        }
    }

    static int N;
    static Node[] nodeList;
    public static void main(String[] args)  throws Exception{
        System.setIn(new FileInputStream("src/res/graph_input.txt"));
        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
        N = sc.nextInt();
        int E = sc.nextInt();
        nodeList = new Node[N];
        for(int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            nodeList[from] = new Node(to, nodeList[from]);
//            nodeList[to] = new Node(from, nodeList[to]);
        }


        for(int i = 0; i < N; i++) {
            System.out.println(i + " : ");
            for(Node j = nodeList[i]; j != null; j=j.link) {
                System.out.println(j + " -> ");
            }
        }


        /**
         *  0 1
         *  0 2
         *  가 예시로 들어오면
         *  지금 addFirst로 하고 있기 때문에
         *  0 -> 1
         *  0 -> 2 -> 1 이렇게 진행이 되어가는 거야
         *  노드 0은 노드 2의 참조값, 노드 2는 노느 1의 참조값을 가지게 된다.
         *
         */

        sc.close();


    }
}