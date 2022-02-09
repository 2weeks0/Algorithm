package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj_16936 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Long> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            deque.add(Long.parseLong(st.nextToken()));
        }

        LinkedList<Long> answer = new LinkedList<>();
        answer.add(deque.poll());

        while (!deque.isEmpty()) {
            long num = deque.pollFirst();
            assert !answer.isEmpty();
            if (2 * num == answer.peekFirst() || (num % 3 == 0 && num / 3 == answer.peekFirst())) {
                answer.addFirst(num);
            } else if (2 * answer.peekLast() == num || (answer.peekLast() % 3 == 0 && answer.peekLast() / 3 == num)) {
                answer.addLast(num);
            } else {
                deque.addLast(num);
            }
        }

        while (!answer.isEmpty()) {
            bw.append(String.valueOf(answer.pollFirst())).append(' ');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
