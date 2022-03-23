package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16928 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> ladderMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ladderMap.put(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        Map<Integer, Integer> snakeMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            snakeMap.put(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        System.out.println(bfs(ladderMap, snakeMap));
        br.close();
    }

    static int bfs(Map<Integer, Integer> ladderMap, Map<Integer, Integer> snakeMap) {
        int[] visited = new int[100];
        visited[0] = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == 99) {
                return visited[current] - 1;
            }

            for (int d = 1; d <= 6; d++) {
                int next = current + d;
                if (ladderMap.containsKey(next)) {
                    next = ladderMap.get(next);
                } else if (snakeMap.containsKey(next)) {
                    next = snakeMap.get(next);
                }

                if (100 <= next || visited[next] != 0) {
                    continue;
                }

                visited[next] = visited[current] + 1;
                queue.add(next);
            }
        }

        return -1;
    }
}

