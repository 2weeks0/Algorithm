package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18290 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(n, m, k, 0, map, new boolean[n][m], 0);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int m, int k, int idx, int[][] map, boolean[][] visited, int cnt) {
        if (cnt == k) {
            int sum = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (visited[r][c]) {
                        sum += map[r][c];
                    }
                }
            }
            answer = Math.max(answer, sum);
            return;
        }

        outer: for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (0 <= nr && nr < n && 0 <= nc && nc < m && visited[nr][nc]) {
                    continue outer;
                }
            }

            visited[r][c] = true;
            recursive(n, m, k, i + 1, map, visited, cnt + 1);
            visited[r][c] = false;
        }
    }
}
