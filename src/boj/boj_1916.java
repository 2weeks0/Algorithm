package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        LinkedList<Edge>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, weight));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()) - 1;
        int e = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(dijkstra(n, graph, s, e));
        br.close();
    }

    static int dijkstra(int n, LinkedList<Edge>[] graph, int s, int e) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> distance[i]));
        pq.add(s);
        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            int current = pq.poll();
            if (current == e) {
                return distance[e];
            }
            if (visited[current]) {
                continue;
            }
            visited[current] = true;
            for (Edge edge : graph[current]) {
                if (distance[current] + edge.weight < distance[edge.to]) {
                    distance[edge.to] = distance[current] + edge.weight;
                    pq.add(edge.to);
                }
            }
        }
        return -1;
    }

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
