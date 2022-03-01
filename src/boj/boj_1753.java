package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj_1753 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine()) - 1;
        List<Edge>[] graph = new List[v];
        for (int i = 0;i < v;i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, w));
        }

        int[] dist = dijkstra(graph, v, s);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) {
                bw.append("INF\n");
            } else {
                bw.append(String.valueOf(d)).append('\n');
            }
        }

        bw.close();
        br.close();
    }

    static int[] dijkstra(List<Edge>[] graph, int v, int s) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> dist[i]));
        pq.add(s);

        while (!pq.isEmpty()) {
            int current = pq.poll();
            for (Edge edge : graph[current]) {
                if (dist[current] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[current] + edge.weight;
                    pq.add(edge.to);
                }
            }
        }

        return dist;
    }

    static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
