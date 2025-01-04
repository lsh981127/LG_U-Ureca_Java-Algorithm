package Uplus_Java_Class.ListTree;

public class TreePrac {

    int count;  // 이 트리의 노드 갯수

    public TreePrac() {
        count = 0;
    }
    public class Node {
        Object data;
        Node left;
        Node right;

        public Node(Object data) {
            this.data = data;
            left = null;
            right = null;
        }

        public void addLeft(Node node) {
            left = node;
            count++;
        }

        public void addRight(Node node) {
            right = node;
            count++;
        }

        public void deleteLeft() {
            left = null;
            count--;
        }

        public void deleteRight() {
            right = null;
            count--;
        }
    }

    public Node addNode(Object data) {
        Node n = new Node(data);
        return n;
    }

    public void preOrder(Node node) {
        if(node == null) return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }


    public void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if(node == null) return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.data);
    }

}
