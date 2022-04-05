package swea;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1767 {
    static final int EMPTY = 0;
    static final int CORE = 1;
    static final int LINE = 2;
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    static int answerCntCore = 0;
    static int answerCntLine = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            answerCntCore = 0;
            answerCntLine = Integer.MAX_VALUE;
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];
            List<Core> coreList = new ArrayList<>(n);
            int cntCore = 0;

            for (int r = 0; r < n; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    int value = Integer.parseInt(st.nextToken());
                    board[r][c] = value;
                    if (value == CORE) {
                        if (r == 0 || r == n - 1 || c == 0 || c == n - 1) {
                            cntCore++;
                        } else {
                            coreList.add(new Core(r, c));
                        }
                    }
                }
            }

            recursive(n, board, coreList, cntCore, 0, 0);
            bw.append(String.format("#%d %d\n", t, answerCntLine));
        }
        bw.close();
        br.close();
    }

    static void recursive(int n, int[][] board, List<Core> coreList, int cntCore, int cntLine, int depth) {
        if (depth == coreList.size()) {
            if (answerCntCore == cntCore) {
                answerCntLine = Math.min(answerCntLine, cntLine);
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        System.out.print(board[r][c] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println();
            } else if (answerCntCore < cntCore) {
                answerCntCore = cntCore;
                answerCntLine = cntLine;
            }
            return;
        }

        Core core = coreList.get(depth);
        outer: for (int d = 0; d < dr.length; d++) {
            int r = core.r;
            int c = core.c;
            int cntLineAdded = 0;
            while (0 <= r + dr[d] && r + dr[d] < n && 0 <= c + dc[d] && c + dc[d] < n) {
                r += dr[d];
                c += dc[d];
                cntLineAdded++;
                if (board[r][c] != EMPTY) {
                    r -= dr[d];
                    c -= dc[d];
                    while (!(r == core.r && c == core.c)) {
                        board[r][c] = EMPTY;
                        r -= dr[d];
                        c -= dc[d];
                    }
                    continue outer;
                }
                board[r][c] = LINE;
            }
            recursive(n, board, coreList, cntCore + 1, cntLine + cntLineAdded, depth + 1);
            while (!(r == core.r && c == core.c)) {
                board[r][c] = EMPTY;
                r -= dr[d];
                c -= dc[d];
            }
        }
        recursive(n, board, coreList, cntCore, cntLine, depth + 1);
    }

    static class Core {
        int r;
        int c;

        public Core(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

