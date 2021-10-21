package programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class 전력망_둘로_나누기 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }

    static class Solution {
        public int solution(int n, int[][] wires) {
            int answer = 101;
            int a;
            int b;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited, false);
                a = -1;
                b = -1;
                for (int j = 0; j < n; j++) {
                    if (!visited[j]) {
                        int cnt = bfs(j, i, wires, visited);
                        if (a == -1) {
                            a = cnt;
                        } else {
                            b = cnt;
                        }
                    }
                }
                System.out.printf("i: %d, a: %d, b: %d\n", i, a, b);
                if (a != -1 && b != -1) {
                    answer = Math.min(answer, Math.abs(a - b));
                }
            }
            return answer;
        }

        public int bfs(int start, int skip, int[][] wires, boolean[] visited) {
            int result = 1;
            LinkedList<Integer> queue = new LinkedList<>();
            queue.addLast(start);
            visited[start] = true;

            while (!queue.isEmpty()) {
                int current = queue.pollFirst();

                for (int i = 0; i < wires.length; i++) {
                    if (i != skip) {
                        if (wires[i][0] - 1 == current && !visited[wires[i][1] - 1]) {
                            visited[wires[i][1] - 1] = true;
                            queue.addLast(wires[i][1] - 1);
                            result++;

                        } else if (wires[i][1] - 1 == current && !visited[wires[i][0] - 1]) {
                            visited[wires[i][0] - 1] = true;
                            queue.addLast(wires[i][0] - 1);
                            result++;

                        }
                    }
                }
            }
            return result;
        }
    }


}
