package programmers;

public class 순위 {
    class Solution {
        int[][] map;
        public int solution(int n, int[][] results) {
            initMap(n, results);
            floydWarshall(n);
            return getAnswer(n);
        }

        public void initMap(int n, int[][] results) {
            map = new int[n][n];
            for (int[] result : results) {
                map[result[0] - 1][result[1] - 1]++;
            }
        }

        public void floydWarshall(int n) {
            for (int k = 0; k < n; k++) {
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        if (map[r][k] == 1) {
                            map[k][r] = -1;
                        }
                        if (map[k][c] == 1) {
                            map[c][k] = -1;
                        }
                        if (map[r][k] == 1 && map[k][c] == 1) {
                            map[r][c] = 1;
                            map[c][r] = -1;
                        }
                    }
                }
            }
        }

        public int getAnswer(int n) {
            int answer = 0;
            for (int r = 0; r < n; r++) {
                int cntOfZero = 0;
                for (int c = 0; c < n; c++) {
                    if (map[r][c] == 0) {
                        cntOfZero++;
                    }
                }
                if (cntOfZero == 1) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
