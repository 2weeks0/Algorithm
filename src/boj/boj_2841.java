package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2841 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int p = Integer.parseInt(st.nextToken());
        int answer = 0;

        final Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            final int line = Integer.parseInt(st.nextToken());
            final int fret = Integer.parseInt(st.nextToken());

            map.putIfAbsent(line, new Stack<>());
            final Stack<Integer> stack = map.get(line);

            while (!stack.isEmpty() && stack.peek() > fret) {
                stack.pop();
                answer++;
            }

            if (stack.isEmpty() || stack.peek() < fret) {
                stack.push(fret);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
