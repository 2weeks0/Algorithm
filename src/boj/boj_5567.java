package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_5567 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer>[] map = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[b].add(a);
            map[a].add(b);
        }

        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        dfs(map, visited, 0, 0);

        int answer = 0;
        for (int v : visited) {
            if (0 < v && v <= 2) {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void dfs(List<Integer>[] map, int[] visited, int current, int depth) {
        visited[current] = Math.min(visited[current], depth);
        for (int i : map[current]) {
            if (visited[i] <= depth) {
                continue;
            }
            dfs(map, visited, i, depth + 1);
        }
    }
}
