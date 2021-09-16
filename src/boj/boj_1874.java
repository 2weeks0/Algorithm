package boj;

import java.io.*;
import java.util.Stack;

public class boj_1874 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();
        final Stack<Integer> stack = new Stack<>();
        final int n = Integer.parseInt(br.readLine());

        int num = 0;
        for (int i = 0; i < n; i++) {
            final int target = Integer.parseInt(br.readLine());
            if (num <= target) {
                while (num != target) {
                    stack.push(++num);
                    stringBuilder.append("+\n");
                }
                stack.pop();
            } else {
                final int pop = stack.pop();
                if (pop != target) {
                    System.out.println("NO");
                    return;
                }
            }
            stringBuilder.append("-\n");
        }
        System.out.print(stringBuilder);
    }
}
