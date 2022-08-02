package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj_2164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        while (deque.size() != 1) {
            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }

        System.out.println(deque.pollFirst());
        br.close();
    }
}
