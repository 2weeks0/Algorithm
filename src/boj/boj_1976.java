package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1976 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cities = new int[m];
        for (int i = 0; i < m; i++) {
            cities[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        br.close();

        boolean[] visited = new boolean[n];
        dfs(n, map, visited, cities[0]);
        for (int i = 1; i < m; i++) {
            if (cities[i - 1] != cities[i] && !visited[cities[i]]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static void dfs(int n, int[][] map, boolean[] visited, int current) {
        visited[current] = true;
        for (int i = 0; i < n; i++) {
            if (map[current][i] == 1 && !visited[i]) {
                dfs(n, map, visited, i);
            }
        }
    }
}
