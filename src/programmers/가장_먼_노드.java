package programmers;

import java.util.LinkedList;

public class 가장_먼_노드 {

    class Solution {
        public int solution(int n, int[][] edge) {
            return bfs(n, edge);
        }

        public int bfs(int n, int[][] edge) {
            int[] distance = new int[n];
            LinkedList<Integer> queue = new LinkedList<>();
            queue.addLast(0);
            distance[0] = 1;

            while (!queue.isEmpty()) {
                int current = queue.pollFirst();
                for (int[] e : edge) {
                    if ((e[0] - 1 == current && distance[e[1] - 1] == 0)) {
                        distance[e[1] - 1] = distance[current] + 1;
                        queue.addLast(e[1] - 1);
                    } else if (e[1] - 1 == current && distance[e[0] - 1] == 0) {
                        distance[e[0] - 1] = distance[current] + 1;
                        queue.addLast(e[0] - 1);
                    }
                }
            }

            int max = 0;
            int cnt = 0;
            for (int d : distance) {
                System.out.printf("%d ", d);
                if (max < d) {
                    cnt = 1;
                    max = d;
                } else if (max == d) {
                    cnt++;
                }
            }
            return cnt;
        }
    }


}
