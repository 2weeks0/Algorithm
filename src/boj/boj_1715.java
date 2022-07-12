package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (1 < pq.size()) {
            int a = pq.poll();
            int b = pq.poll();
            answer += a + b;
            pq.add(a + b);
        }

        System.out.println(answer);
        br.close();
    }
}
