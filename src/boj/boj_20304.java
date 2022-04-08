package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_20304 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] hacker = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            hacker[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(n, hacker));
        br.close();
    }

    static int bfs(int n, int[] hacker) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[n + 1];
        for (int pw : hacker) {
            queue.add(pw);
            visited[pw] = 1;
        }

        int binaryLength = Integer.toBinaryString(n).length();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < binaryLength; i++) {
                int temp = current ^ (1 << i);
                if (n < temp || visited[temp] != 0) {
                    continue;
                }
                visited[temp] = visited[current] + 1;
                queue.add(temp);
            }
        }

        return Arrays.stream(visited).max().getAsInt() - 1;
    }
}
