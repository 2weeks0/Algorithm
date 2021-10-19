package programmers;


public class 등굣길 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(4, 3, new int[][]{{1, 2}}));
    }

    static class Solution {
        public int solution(int m, int n, int[][] puddles) {
            var map = new int[n][m];
            map[0][0] = 1;
            for (int[] puddle : puddles) {
                map[puddle[1] - 1][puddle[0] - 1] = -1;
            }
            init(m, n, map);
            return map[n - 1][m - 1];
        }

        public void init(int m, int n, int[][] map) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (map[r][c] == -1) {
                        continue;
                    }
                    if (r == 0 && 0 < c) {
                        map[r][c] = map[r][c - 1] == -1 ? 0 : map[r][c - 1];
                    } else if (0 < r && c == 0) {
                        map[r][c] = map[r - 1][c] == -1 ? 0 : map[r - 1][c];
                    } else if (0 < r) {
                        map[r][c] =(int) (((long) ((map[r - 1][c] == -1 ? 0 : map[r - 1][c]) + (map[r][c - 1] == -1 ? 0 : map[r][c - 1]))) % 1000000007);

                    }
                }
            }
        }
    }


}
