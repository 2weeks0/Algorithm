package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 삼각_달팽이 {

    public static void main(String[] args) {
            System.out.println(Arrays.toString(new Solution().solution(1)));
    }

    static class Solution {
        int cnt = 1;
        int r = -1;
        int c = 0;

        public int[] solution(int n) {
            int[][] answer = new int[n][n];
            int prevR = -1;
            int prevC = 0;
            while (true) {
                r++;
                drawVertical(n, answer);
                drawHorizontal(n, answer);
                drawDiagonal(answer);
//                for (int r = 0; r < n; r++) {
//                    for (int c = 0; c < n; c++) {
//                        System.out.printf("%d ", answer[r][c]);
//                    }
//                    System.out.println();
//                }
//                System.out.printf("%d, %d\n", r, c);
                if (prevR == r && prevC == c) {
                    break;
                } else {
                    prevR = r;
                    prevC = c;
                }

            }

            List<Integer> result = new ArrayList<>();
            for (int dr = 0; dr < n; dr++) {
                for (int dc = 0; dc <= dr; dc++) {
                    result.add(answer[dr][dc]);
                }
            }
            return result.stream().mapToInt(it -> it).toArray();
        }

        public void drawVertical(int n, int[][] answer) {
            while (true) {
                if (r < n && answer[r][c] == 0) {
                    answer[r][c] = cnt++;
                    r++;
                } else {
                    r--;
                    c++;
                    return;
                }
            }
        }

        public void drawHorizontal(int n, int[][] answer) {
            while (true) {
                if (c < n && answer[r][c] == 0) {
                    answer[r][c] = cnt++;
                    c++;
                } else {
                    c--;
                    return;
                }
            }
        }

        public void drawDiagonal(int[][] answer) {
            while (0 <= r - 1 && 0 <= c - 1 && answer[r - 1][c - 1] == 0) {
                answer[--r][--c] = cnt++;
            }
        }
    }
}
