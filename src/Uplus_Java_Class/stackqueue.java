package Uplus_Java_Class;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class stackqueue {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("강호동");
        System.out.println(stack);
        ArrayDeque<String> realstack = new ArrayDeque<>();      // 스택을 쓸때는 이제는 이거를 쓴다!

        Queue<String> queue = new LinkedList<>();

        queue.offer("저팔계");
        System.out.println(queue);

        /**
         * queue는
         * peek
         * poll
         * isEmpty
         */

        /**
         * stack은
         * peek
         * pop
         * isEmpty
         *
         *
         */
    }


}
