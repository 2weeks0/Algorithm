package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String c4 = br.readLine();

        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();

       outer: for (int i = 0; i < str.length(); i++) {
            stack.add(str.charAt(i));
            if (c4.length() <= stack.size()) {
                for (int j = c4.length() - 1; 0 <= j; j--) {
                    char c = stack.pop();
                    temp.add(c);
                    if (c != c4.charAt(j)) {
                        while (!temp.isEmpty()) {
                            stack.add(temp.pop());
                        }
                        continue outer;
                    }
                }
                temp.clear();
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse());
        }

        br.close();
    }
}
