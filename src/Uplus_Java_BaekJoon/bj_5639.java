package Uplus_Java_BaekJoon;

import java.util.*;
import java.io.*;
public class bj_5639 {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

        public void insert(int val) {
            if(val < this.data) {
                if(left == null) this.left = new Node(val);
                else this.left.insert(val);
            } else {
                if(right == null) this.right = new Node(val);
                else this.right.insert(val);
            }
        }
    }

    public static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);

    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true) {
            String val = br.readLine();
            if(val == null || val.equals("")) break;
            root.insert(Integer.parseInt(val));
        }

        postOrder(root);

    }

}
