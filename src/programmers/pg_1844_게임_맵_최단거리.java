package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class pg_1844_게임_맵_최단거리 {
    class Solution {
        public int solution(int[][] maps) {
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            int r = maps.length;
            int c = maps[0].length;

            int[][] dist = new int[r][c];
            dist[0][0] = 1;
            Queue<Point> queue = new ArrayDeque<>();
            queue.add(new Point(0, 0));

            while (!queue.isEmpty()) {
                Point current = queue.poll();
                if (current.r == r - 1 && current.c == c - 1) {
                    return dist[current.r][current.c];
                }

                for (int d = 0; d < dr.length; d++) {
                    int nr = current.r + dr[d];
                    int nc = current.c + dc[d];
                    if (nr < 0 || r <= nr || nc < 0 || c <= nc || maps[nr][nc] == 0 || dist[nr][nc] != 0) {
                        continue;
                    }
                    dist[nr][nc] = dist[current.r][current.c] + 1;
                    queue.add(new Point(nr, nc));
                }
            }
            return -1;
        }

        class Point {
            int r;
            int c;

            public Point(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }
    }
}
