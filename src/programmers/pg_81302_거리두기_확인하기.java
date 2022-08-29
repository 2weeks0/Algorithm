package programmers;

public class pg_81302_거리두기_확인하기 {
    class Solution {
        static int[] dr, dc;
        public int[] solution(String[][] places) {
            dr = new int[]{0, 1, 0, -1};
            dc = new int[]{1, 0, -1, 0};

            int[] answer = {1, 1, 1, 1, 1};
            outer: for (int i = 0; i < places.length; i++) {
                boolean[][] visited = new boolean[5][5];
                for (int r = 0; r < 5; r++) {
                    for (int c = 0; c < 5; c++) {
                        if (places[i][r].charAt(c) != 'P') {
                            continue;
                        }
                        if (!dfs(places[i], visited, r, c, 0)) {
                            answer[i] = 0;
                            continue outer;
                        }
                    }
                }
            }

            return answer;
        }

        boolean dfs(String[] place, boolean[][] visited, int r, int c, int depth) {
            if (depth == 2) {
                return true;
            }
            
            visited[r][c] = true;
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || 5 <= nr || nc < 0 || 5 <= nc || visited[nr][nc] || place[nr].charAt(nc) == 'X') {
                    continue;
                }

                if (place[nr].charAt(nc) == 'P') {
                    return false;
                }

                if (!dfs(place, visited, nr, nc, depth + 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
