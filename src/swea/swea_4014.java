package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_4014 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int[][] board = new int[n][n];
            for (int r = 0; r < n; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    board[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = solve(n, x, board);
            bw.append(String.format("#%d %d\n", t, answer));
        }
        bw.close();
        br.close();
    }

    static int solve(int n, int x, int[][] board) {
        int result = 0;

        outer: for (int c = 0; c < n; c++) {
            int cntEqual = 1;
            int height = board[0][c];
            for (int r = 1; r < n; r++) {
                if (height == board[r][c]) {
                    cntEqual++;
                } else if (Math.abs(height - board[r][c]) != 1) {
                    continue outer;
                } else if (height < board[r][c]) {
                    if (cntEqual < x) {
                        continue outer;
                    } else {
                        cntEqual = 1;
                        height = board[r][c];
                    }
                } else {
                    for (int cr = r; cr < r + x; cr++) {
                        if (n <= cr || board[r][c] != board[cr][c]) {
                            continue outer;
                        }
                    }
                    height = board[r][c];
                    cntEqual = 0;
                    r = r + x - 1;
                }
            }
            result++;
        }

        outer: for (int r = 0; r < n; r++) {
            int cntEqual = 1;
            int height = board[r][0];
            for (int c = 1; c < n; c++) {
                if (height == board[r][c]) {
                    cntEqual++;
                } else if (Math.abs(height - board[r][c]) != 1) {
                    continue outer;
                } else if (height < board[r][c]) {
                    if (cntEqual < x) {
                        continue outer;
                    } else {
                        cntEqual = 1;
                        height = board[r][c];
                    }
                } else {
                    for (int cc = c; cc < c + x; cc++) {
                        if (n <= cc || board[r][c] != board[r][cc]) {
                            continue outer;
                        }
                    }
                    height = board[r][c];
                    cntEqual = 0;
                    c = c + x - 1;
                }
            }
            result++;
        }

        return result;
    }
}
