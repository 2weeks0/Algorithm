package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.StringTokenizer;

public class boj_2840 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int k = Integer.parseInt(st.nextToken());

        final ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i ++) {
            deque.add('?');
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            final int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                deque.addFirst(Objects.requireNonNull(deque.pollLast()));
            }
            final Character c = st.nextToken().charAt(0);
            final Character temp = deque.pollFirst();

            if ((temp != '?' && c != temp) || deque.contains(c)) {
                System.out.println("!");
                return;
            }
            deque.addFirst(c);
        }

        final StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(deque.pollFirst());
        }
        System.out.println(answer);
    }
}
