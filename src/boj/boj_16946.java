package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16946 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < m; c++) {
                board[r][c] = line.charAt(c) - '0';
            }
        }

        int key = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] != 0) {
                    continue;
                }
                int cnt = dfs(n, m, board, r, c, key);
                map.put(key, cnt);
                key++;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] != 1) {
                    sb.append(0);
                } else {
                    Set<Integer> set = new HashSet<>();
                    for (int d = 0; d < dr.length; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr < 0 || n <= nr || nc < 0 || m <= nc || board[nr][nc] == 1) {
                            continue;
                        }
                        set.add(board[nr][nc]);
                    }

                    int sum = set.stream().map(map::get).mapToInt(it -> it).sum();
                    sb.append((sum + 1) % 10);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    static int dfs(int n, int m, int[][] board, int r, int c, int key) {
        board[r][c] = key;
        int cnt = 1;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || n <= nr || nc < 0 || m <= nc || board[nr][nc] != 0) {
                continue;
            }
            cnt += dfs(n, m, board, nr, nc, key);
        }
        return cnt;
    }

}
