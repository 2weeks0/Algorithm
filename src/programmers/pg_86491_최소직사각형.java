package programmers;

public class pg_86491_최소직사각형 {
    class Solution {
        public int solution(int[][] sizes) {
            int min = 0;
            int max = 0;
            for (int[] size : sizes) {
                max = Math.max(max, Math.max(size[0], size[1]));
                min = Math.max(min, Math.min(size[0], size[1]));
            }
            return min * max;
        }
    }
}
