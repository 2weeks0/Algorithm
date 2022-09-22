package programmers;

public class pg_87946_피로도 {
    class Solution {
        static int answer;

        public int solution(int k, int[][] dungeons) {
            answer = 0;
            dfs(k, dungeons, new boolean[dungeons.length], 0);
            return answer;
        }

        void dfs(int k, int[][] dungeons, boolean[] visited, int cnt) {
            answer = Math.max(answer, cnt);
            for (int i = 0; i < dungeons.length; i++) {
                if (visited[i] || k < dungeons[i][0]) {
                    continue;
                }
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
