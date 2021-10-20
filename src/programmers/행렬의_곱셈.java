package programmers;

public class 행렬의_곱셈 {

    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];
            for (int r = 0; r < answer.length; r++) {
                for (int c = 0; c < answer[0].length; c++) {
                    for (int i = 0; i < arr2.length; i++) {
                        answer[r][c] += arr1[r][i] * arr2[i][c];
                    }
                }
            }
            return answer;
        }
    }


}
