package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");

        System.out.println(sb);
        br.close();
    }
}
