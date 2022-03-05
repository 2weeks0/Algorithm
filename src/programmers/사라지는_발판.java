package programmers;


import java.util.LinkedList;
import java.util.List;

public class 사라지는_발판 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{1, 1, 1},{1,1,1},{1,1,1}}, new int[]{1, 0}, new int[]{1, 2}));
//        System.out.println(new Solution().solution(new int[][]{{1, 1, 1, 1}}, new int[]{0, 0}, new int[]{0, 3}));
//        System.out.println(new Solution().solution(new int[][]{{0, 1, 1, 0}, {1, 1, 1, 1}}, new int[]{1, 0}, new int[]{1, 3}));
//        System.out.println(new Solution().solution(new int[][]{{0, 1, 1, 0}, {1, 1, 1, 1}, {0, 0, 1, 0}}, new int[]{1, 0}, new int[]{1, 3}));
//        System.out.println(new Solution().solution(new int[][]{{1, 1, 1},{1,0,1},{1,1,1}}, new int[]{1, 0}, new int[]{1, 2}));
//        System.out.println(new Solution().solution(new int[][]{{1, 1, 1},{1,1,1},{1,0,1}}, new int[]{1, 0}, new int[]{1, 2}));
//        System.out.println(new Solution().solution(new int[][]{{0, 1, 1},{1,1,1},{1,0,1}}, new int[]{1, 0}, new int[]{1, 2}));
    }

    static class Solution {
        static final int[] dr = {0, 1, 0, -1};
        static final int[] dc = {1, 0, -1, 0};

        static int n;
        static int m;
        static int[][] board;

        public int solution(int[][] board, int[] aLoc, int[] bLoc) {
            Solution.board = board;
            n = board.length;
            m = board[0].length;
            return recursive(new Point(aLoc[0], aLoc[1]), new Point(bLoc[0], bLoc[1]), 0).cnt;
        }


        Result recursive(Point move, Point stop, int cnt) {
            if (board[move.r][move.c] == 0) {
                return new Result(false, cnt);
            }

            List<Point> movablePointList = getMovablePointList(move.r, move.c);
            if (movablePointList.isEmpty()) {
                return new Result(false, cnt);
            }

            boolean canWin = false;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            board[move.r][move.c] = 0;
            for (Point point : movablePointList) {
                Result result = recursive(stop, point, cnt + 1);

                canWin |= !result.canWin;
                if (!result.canWin) {
                    min = Math.min(min, result.cnt);
                } else {
                    max = Math.max(max, result.cnt);
                }
            }
            board[move.r][move.c] = 1;

            return new Result(canWin, canWin ? min : max);
        }

        static boolean isInRange(int r, int c) {
            return 0 > r || r >= n || 0 > c || c >= m;
        }

        List<Point> getMovablePointList(int moveR, int moveC) {
            List<Point> result = new LinkedList<>();
            for (int i = 0; i < 4; i++) {
                int nr = moveR + dr[i];
                int nc = moveC + dc[i];
                if (isInRange(nr, nc) || board[nr][nc] == 0) {
                    continue;
                }
                result.add(new Point(nr, nc));
            }
            return result;
        }

        static class Point {
            int r;
            int c;

            public Point(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }

        static class Result {
            boolean canWin;
            int cnt;

            public Result(boolean canWin, int cnt) {
                this.canWin = canWin;
                this.cnt = cnt;
            }
        }
    }
}
