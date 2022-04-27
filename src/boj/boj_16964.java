package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16964 {
    static boolean find = false;
    static int depth = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        dfs(n, graph, new boolean[n], order);
        System.out.println(find ? 1 : 0);
        br.close();
    }

    static void dfs(int n, List<Integer>[] graph, boolean[] visited, int[] order) {
        if (find) {
            return;
        } else if (depth == n) {
            find = true;
            return;
        }

        int current = order[depth];
        if (visited[current]) {
            return;
        }
        visited[current] = true;
        while (graph[current].contains(order[depth + 1])) {
            graph[current].remove((Integer) order[++depth]);
            dfs(n, graph, visited, order);
        }
    }
}
