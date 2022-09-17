package programmers;

public class pg_12913_땅따먹기 {
  class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = land[i][j] + max(dp, i, j);
            }
        }
        
        return max(dp, dp.length, -1);
    }
    
    int max(int[][] dp, int i, int j) {
        int result = 0;
        for (int k = 0; k < 4; k++) {
            if (k == j) {
                continue;
            }
            result = Math.max(result, dp[i - 1][k]);
        }
        return result;
    }
}
}