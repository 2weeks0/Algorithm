package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1388 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for (int r = 0; r < n; r++) {
            String s = br.readLine();
            for (int c = 0; c < m; c++) {
                board[r][c] = s.charAt(c);
            }
        }

        int answer = 0;
        boolean[][] visited = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (visited[r][c]) {
                    continue;
                }
                dfs(n, m, board, visited, r, c);
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static void dfs(int n, int m, char[][] board, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        if (board[r][c] == '-' && c + 1 < m && board[r][c + 1] == '-' && !visited[r][c + 1]) {
            dfs(n, m, board, visited, r, c + 1);
        } else if (board[r][c] == '|' && r + 1 < n && board[r + 1][c] == '|' && !visited[r + 1][c]) {
            dfs(n, m, board, visited, r + 1, c);
        }
    }
}
