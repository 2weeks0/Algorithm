package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj_4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        Stack<Character> stack = new Stack<>();
        outer: while (!(str = br.readLine()).equals(".")) {
            stack.clear();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '[' || c == '(') {
                    stack.push(c);
                } else if (c == ']' || c == ')') {
                    if (stack.isEmpty() || (c == ']' && stack.pop() != '[') || (c == ')' && stack.pop() != '(')) {
                        bw.append("no\n");
                        continue outer;
                    }
                }
            }

            bw.append(stack.isEmpty() ? "yes\n" : "no\n");
        }

        bw.close();
        br.close();
    }
}
