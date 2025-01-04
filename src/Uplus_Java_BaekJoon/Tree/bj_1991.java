package Uplus_Java_BaekJoon.Tree;

import java.util.*;
import java.io.*;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        left = null;
        right = null;
    }

    public void addLeft(Node node) {
        left = node;
    }

    public void addRight(Node node) {
        right = node;
    }

}


public class bj_1991 {
    static Node[] tree;

    public static void preOrder(Node node) {
        if(node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);

    }

    public static void outOrder(Node node) {
        if(node == null) return;
        outOrder(node.left);
        outOrder(node.right);
        System.out.print(node.value);

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if(tree[node - 'A'] == null) {
                tree[node - 'A'] = new Node(node);
            }
            if(left != '.') {  // 왼쪽값이 .이 아니면
                tree[left - 'A'] = new Node(left);
                tree[node - 'A'].addLeft(tree[left - 'A']);
            }

            if(right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[node - 'A'].addRight(tree[right - 'A']);
            }
        }

        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        outOrder(tree[0]);
    }

}
