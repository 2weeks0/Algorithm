package programmers;

public class pg_49994_방문_길이 {
    class Solution {
        public int solution(String dirs) {
            int answer = 0;

            boolean[][] visitedHorizon = new boolean[11][10];
            boolean[][] visitedVertical = new boolean[10][11];
            int[] pos = new int[2];
            for (int i = 0; i < dirs.length(); i++) {
                char c = dirs.charAt(i);
                if (c == 'L' && pos[1] != -5 && !visitedHorizon[pos[0] + 5][--pos[1] + 5]) {
                    visitedHorizon[pos[0] + 5][pos[1] + 5] = true;
                    answer++;
                } else if (c == 'R' && pos[1] != 5 && !visitedHorizon[pos[0] + 5][pos[1]++ + 5]) {
                    visitedHorizon[pos[0] + 5][pos[1] - 1 + 5] = true;
                    answer++;
                } else if (c == 'U' && pos[0] != 5 && !visitedVertical[pos[0]++ + 5][pos[1] + 5]) {
                    visitedVertical[pos[0] - 1 + 5][pos[1] + 5] = true;
                    answer++;
                } else if (c == 'D' && pos[0] != -5 && !visitedVertical[--pos[0] + 5][pos[1] + 5]) {
                    visitedVertical[pos[0] + 5][pos[1] + 5] = true;
                    answer++;
                }
            }
            return answer;
        }
    }
}