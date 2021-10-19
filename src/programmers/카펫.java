package programmers;

import java.util.Arrays;

public class 카펫 {

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(new Solution().solution(24, 24)));
    }

    static class Solution {
        public int[] solution(int brown, int yellow) throws Exception {
            for (int i = 1; i <= Math.sqrt(yellow); i++) {
                if (yellow % i == 0 && (i + 2) * (yellow / i + 2) == brown + yellow) {
                    return new int[]{i, yellow / i};
                }
            }
            throw new Exception();
        }
    }

}
