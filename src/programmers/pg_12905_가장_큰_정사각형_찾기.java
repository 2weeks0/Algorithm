package programmers;

public class pg_12905_가장_큰_정사각형_찾기 {
    class Solution {
        public int solution(int[][] board) {
            int answer = 0;
            int[][] dp = new int[board.length][board[0].length];
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[0].length; c++) {
                    if (board[r][c] == 0) {
                        continue;
                    }

                    board[r][c] = 1;
                    answer = Math.max(answer, 1);
                    if (0 <= r - 1 && 0 <= c - 1 && board[r - 1][c] != 0 && board[r - 1][c - 1] != 0 && board[r][c - 1] != 0) {
                        board[r][c] = Math.min(board[r - 1][c], Math.min(board[r - 1][c - 1], board[r][c - 1])) + 1;
                        answer = Math.max(answer, board[r][c]);
                    }
                }
            }
            return answer * answer;
        }
    }
}