package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20058 {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};
    static int cntIce = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int q = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            rotate(n, board, Integer.parseInt(st.nextToken()));
            melt(n, board);
        }

        boolean[][] visited = new boolean[n][n];
        int max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                cntIce += board[r][c];
                if (visited[r][c] || board[r][c] == 0) {
                    continue;
                }
                max = Math.max(max, dfs(n, board, visited, r, c));
            }
        }

        System.out.println(cntIce);
        System.out.println(max);
        br.close();
    }

    static void rotate(int n, int[][] board, int l) {
        l = (int) Math.pow(2, l);
        for (int r = 0; r < n; r += l) {
            for (int c = 0; c < n; c += l) {
                for (int cr = 0; cr < l / 2; cr++) {
                    for (int cc = 0; cc < l / 2; cc++) {
                        int temp = board[r + cr][c + cc];
                        board[r + cr][c + cc] = board[r + l - 1 - cc][c + cr];
                        board[r + l - 1 - cc][c + cr] = board[r + l - 1 - cr][c + l - 1 - cc];
                        board[r + l - 1 - cr][c + l - 1 - cc] = board[r + cc][c + l - 1 - cr];
                        board[r + cc][c + l - 1 - cr] = temp;
                    }
                }
            }
        }
    }

    static void melt(int n, int[][] board) {
        int[][] temp = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                temp[r][c] = board[r][c];
            }
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 0) {
                    continue;
                }
                int cnt = 0;
                for (int d = 0; d < dr.length; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 0 || n <= nr || nc < 0 || n <= nc || board[nr][nc] == 0) {
                        continue;
                    }
                    cnt++;
                }
                if (cnt < 3) {
                    temp[r][c]--;
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = temp[r][c];
            }
        }
    }

    static int dfs(int n, int[][] board, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        int result = 1;
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || n <= nr || nc < 0 || n <= nc || board[nr][nc] == 0 || visited[nr][nc]) {
                continue;
            }
            result += dfs(n, board, visited, nr, nc);
        }
        return result;
    }
}
