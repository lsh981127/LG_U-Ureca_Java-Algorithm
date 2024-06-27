import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        StringBuilder sb=new StringBuilder();

        ArrayDeque<String> leftStack=new ArrayDeque<>();
        ArrayDeque<String> rightStack=new ArrayDeque<>();

        String str=br.readLine().trim();
        for(int i=0; i<str.length(); i++) {
            leftStack.push(String.valueOf(str.charAt(i)));
        }

        int M=Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st=new StringTokenizer(br.readLine()," ");
            String input=st.nextToken();
            switch(input) {
                case "P":
                    leftStack.push(st.nextToken());
                    break;
                case "L":
                    if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                    break;
                case "D":
                    if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                    break;
                case "B":
                    if(!leftStack.isEmpty()) leftStack.pop();
                    break;
            }
        }

        System.out.println(Arrays.toString(leftStack.toArray()));
        System.out.println(Arrays.toString(rightStack.toArray()));

        while(!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        System.out.println(Arrays.toString(leftStack.toArray()));
        System.out.println(Arrays.toString(rightStack.toArray()));

        while(!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
        br.close();
    }
}
