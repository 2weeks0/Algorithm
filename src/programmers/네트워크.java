package programmers;

import java.util.LinkedList;

public class 네트워크 {

    class Solution {
        int answer = 0;

        public int solution(int n, int[][] computers) {
            for (int i = 0; i < n; i++) {
                bfs(i, n, computers);
            }
            return answer;
        }

        public void bfs(int start, int n, int[][] computers) {
            if (computers[start][start] == 0) {
                return;
            }

            answer++;
            LinkedList<Integer> queue = new LinkedList<>();
            queue.addLast(start);
            computers[start][start] = 0;

            while (!queue.isEmpty()) {
                int current = queue.pollFirst();

                for(int i = 0; i < n; i++) {
                    if (i != current && computers[i][i] == 1 && computers[current][i] == 1) {
                        computers[i][i] = 0;
                        queue.addLast(i);
                    }
                }
            }
        }
    }


}
