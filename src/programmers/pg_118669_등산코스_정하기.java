package programmers;

import java.nio.file.Path;
import java.util.*;

public class pg_118669_등산코스_정하기 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().solution(6, new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}, new int[]{1, 3}, new int[]{5})));
        System.out.println(Arrays.toString(new Solution().solution(7, new int[][]{{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}}, new int[]{1}, new int[]{2, 3, 4})));
//        System.out.println(Arrays.toString(new Solution().solution(5, new int[][]{{1, 3, 10}, {1, 4, 20}, {2, 3, 4}, {2, 4, 6}, {3, 5, 20}, {4, 5, 6}}, new int[]{1, 2}, new int[]{5})));
    }

    static class Solution {
        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            List<Path>[] graph = new LinkedList[n];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new LinkedList<>();
            }

            boolean[] isSummit = new boolean[n];
            for (int summit : summits) {
                isSummit[summit - 1] = true;
            }

            for (int[] path : paths) {
                int a = path[0] - 1;
                int b = path[1] - 1;
                int dist = path[2];

                graph[a].add(new Path(b, dist));
                graph[b].add(new Path(a, dist));
            }

            return dijkstra(n, graph, gates, isSummit);
        }

        int[] dijkstra(int n, List<Path>[] graph, int[] gates, boolean[] isSummit) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            boolean[] visited = new boolean[n];

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                if (dist[a] == dist[b]) {
                    return Integer.compare(a, b);
                }
                return Integer.compare(dist[a], dist[b]);
            });

            for (int gate : gates) {
                pq.add(gate - 1);
                dist[gate - 1] = 0;
            }

            while (!pq.isEmpty()) {
                int current = pq.poll();
                if (isSummit[current]) {
                    return new int[]{current + 1, dist[current]};
                } else if (visited[current]) {
                    continue;
                }
                visited[current] = true;

                for (Path path : graph[current]) {
                    if (Math.max(dist[current], path.dist) < dist[path.to]) {
                        dist[path.to] = Math.max(dist[current], path.dist);
                        pq.add(path.to);
                    }
                }
            }
            return null;
        }

        class Path {
            int to;
            int dist;

            public Path(int to, int dist) {
                this.to = to;
                this.dist = dist;
            }
        }
    }
}
