package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        final Deque<Balloon> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        while (true) {
            final Balloon balloon = deque.pollFirst();
            assert balloon != null;
            System.out.printf("%d ", balloon.index);
            if (deque.isEmpty()) {
                break;
            }

            if (balloon.num > 0) {
                for (int i = 0; i < balloon.num - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < balloon.num * - 1; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
    }

    static class Balloon {
        final int index;
        final int num;

        public Balloon(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
}
