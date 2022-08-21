package programmers;

class pg_1829_카카오_프렌즈_컬러링북 {

    public static void main(String[] args) {
        new Solution().solution(6, 4, new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
    }

    static class Solution {
        static int numberOfArea;
        static int maxSizeOfOneArea;

        static int[] dr;
        static int[] dc;

        public int[] solution(int m, int n, int[][] picture) {
            init();
            boolean[][] visited = new boolean[m][n];
            for (int cr = 0; cr < m; cr++) {
                for (int cc = 0; cc < n; cc++) {
                    if (visited[cr][cc] || picture[cr][cc] == 0) {
                        continue;
                    }
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(cr, cc, m, n, picture, visited));
                }
            }
            return new int[]{numberOfArea, maxSizeOfOneArea};
        }

        void init() {
            numberOfArea = 0;
            maxSizeOfOneArea = 0;
            dr = new int[]{0, 1, 0, -1};
            dc = new int[]{1, 0, -1, 0};
        }

        int dfs(int cr, int cc, int m, int n, int[][] picture, boolean[][] visited) {
            visited[cr][cc] = true;
            int result = 1;
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if (nr < 0 || m <= nr || nc < 0 || n <= nc || visited[nr][nc] || picture[cr][cc] != picture[nr][nc]) {
                    continue;
                }
                result += dfs(nr, nc, m, n, picture, visited);
            }
            return result;
        }
    }
}