package programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class 배달 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(6, new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}	, 4));
    }


    static class Solution {
        int[][] map = null;

        public int solution(int N, int[][] road, int K) {
            initMap(N, road, K);
            bfs(N, K);
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                if (map[i][i] <= K) {
                    System.out.println(i);
                    answer++;
                }
            }
            return answer;
        }

        public void initMap(int N, int[][] road, int K) {
            map = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(map[i], K + 1);
            }
            for (int[] ints : road) {
                map[ints[0]][ints[1]] = Math.min(map[ints[0]][ints[1]], ints[2]);
                map[ints[1]][ints[0]] = Math.min(map[ints[1]][ints[0]], ints[2]);
            }
        }

        public void bfs(int N, int K) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.addLast(1);
            map[1][1] = 0;

            while (!queue.isEmpty()) {
                int current = queue.pollFirst();
                for (int next = 2; next <= N; next++) {
                    if (map[current][current] + map[current][next] < map[next][next]) {
                        map[next][next] = map[current][current] + map[current][next];
                        queue.addLast(next);
                    }
                }
            }
        }

        public void printMap(int N) {
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    System.out.printf("%d ", map[r][c]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }


}
