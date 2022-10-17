package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_2210 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sb.append(map[i][j]);
                dfs(map, set, i, j, 0, sb);
                sb.setLength(sb.length() - 1);
            }
        }

        System.out.println(set.size());
        br.close();
    }

    static void dfs(int[][] map, Set<String> set, int r, int c, int depth, StringBuilder sb) {
        if (depth == 5) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || 5 <= nr || nc < 0 || 5 <= nc) {
                continue;
            }
            sb.append(map[nr][nc]);
            dfs(map, set, nr, nc, depth + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
