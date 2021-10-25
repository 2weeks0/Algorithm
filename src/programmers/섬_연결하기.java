package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 섬_연결하기 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(4, new int[][]{{2,1,5},{0,2,2},{1,3,1},{2,3,8}}));
    }


    static class Solution {
        public int solution(int n, int[][] costs) {
            Arrays.sort(costs, Comparator.comparingInt(i -> i[2]));
            boolean[] visited = new boolean[n + 1];
            int answer = 0;
            for (int[] cost : costs) {
                if (!visited[cost[0]] || !visited[cost[1]]) {
                    visited[cost[0]] = true;
                    visited[cost[1]] = true;
                    answer += cost[2];
                }
            }

            return answer;
        }
    }


}
