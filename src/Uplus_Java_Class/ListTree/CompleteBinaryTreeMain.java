package Uplus_Java_Class.ListTree;

import java.util.*;
public class CompleteBinaryTreeMain {

    static class CompleteBinaryTree<T>  {
        final int SIZE;
        Object[] nodes;
        int lastIndex;

        CompleteBinaryTree(int size) {
            SIZE = size;
            nodes = new Object[size+1];         // 0 번 index는 사용하지 않는다. => 2를 나누면 부모, 곱하면 자식 노드가 될 수 있도록 하기 위해
        }

        void add(T t) {
            if(lastIndex == SIZE) {
                System.out.println("포화상태!");
                return;
            }
            nodes[++lastIndex] = t;
//            System.out.println(Arrays.toString(nodes));
        }

        void bfs(int i) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offer(i);
            while(!q.isEmpty()) {
                i = q.poll();
                System.out.print(nodes[i] + " ");
                if (i*2 <= lastIndex) q.offer(i * 2);
                if (i*2+1 <= lastIndex) q.offer(i * 2+1);
            }
        }

        void preOrder(int i) {
            System.out.print(nodes[i] + " ");
            if (i*2 <= lastIndex) preOrder(i * 2);
            if (i*2+1 <= lastIndex) preOrder(i * 2+1);
        }

        void inOrder(int i) {           //  ?? 이거 정확한 동작 원리가 궁금, 그니까 목적 이 과정의 목표 및 과정
            if (i*2 <= lastIndex) preOrder(i * 2);
            System.out.print(nodes[i] + " ");
            if (i*2+1 <= lastIndex) inOrder(i * 2+1);
        }

        void postOrder(int i) {
            if (i*2 <= lastIndex) postOrder(i * 2);
            if (i*2+1 <= lastIndex) postOrder(i * 2+1);
            System.out.print(nodes[i] + " ");
        }




    }
    public static void main(String[] args) throws Exception{
        int size = 12;
        CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(size);
        for(int i ='A'; i < 'A' + size; i++) tree.add((char)i);

//        tree.bfs(1);
        tree.preOrder(1);
//        tree.inOrder(1);
//        tree.postOrder(1);
        System.out.println();
    }
}
