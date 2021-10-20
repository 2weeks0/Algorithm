package programmers;

import java.util.Arrays;

public class 쿼드압축_후_개수_세기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[][]{{1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}})));
    }

    static class Solution {
        public int[] solution(int[][] arr) {
            int[] answer = {0, 0};
            recursive(0, 0, arr.length, arr, answer);
            return answer;
        }

        public void recursive(int r, int c, int n, int[][] arr, int[] answer) {
            System.out.printf("r: %d, c: %d, n: %d\n", r, c, n);
            int num = arr[r][c];
            for (int dr = r; dr < r + n; dr++) {
                for (int dc = c; dc < c + n; dc++) {
                    if (num != arr[dr][dc]) {
                        recursive(r, c, n / 2, arr, answer);
                        recursive(r, c + n / 2, n / 2, arr, answer);
                        recursive(r + n / 2, c, n / 2, arr, answer);
                        recursive(r + n / 2, c + n / 2, n / 2, arr, answer);
                        return;
                    }
                }
            }
            answer[num] += 1;
        }
    }
}
