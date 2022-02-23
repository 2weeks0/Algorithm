package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_16398 {
    static long answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        primAlgorithm(n, graph);

        System.out.println(answer);
        br.close();
    }

    static void primAlgorithm(int n, int[][] graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            Edge edge = null;
            while (!pq.isEmpty()) {
                edge = pq.poll();
                if (!visited[edge.to]) {
                    break;
                }
            }
            if (edge == null) {
                return;
            }
            visited[edge.to] = true;
            answer += edge.weight;
            for (int j = 0; j < n; j++) {
                if (graph[edge.to][j] != 0) {
                    pq.add(new Edge(j, graph[edge.to][j]));
                }
            }

        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }
}
