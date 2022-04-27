package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj_1719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Edge>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, weight));
            graph[b].add(new Edge(a, weight));
        }

        for (int i = 0; i < n; i++) {
            int[] result = dijkstra(n, graph, i);
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    bw.append('-');
                } else {
                    bw.append(String.valueOf(getValue(result, j) + 1));
                }
                bw.append(' ');
            }
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    static int getValue(int[] result, int i) {
        int temp = i;
        while (temp != result[temp]) {
            temp = result[temp];
        }
        return temp;
    }

    static int[] dijkstra(int n, LinkedList<Edge>[] graph, int s) {
        int[] result = new int[n];
        Arrays.fill(result, -1);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(i -> dist[i]));
        pq.add(s);

        while (!pq.isEmpty()) {
            int current = pq.poll();
            for (Edge edge : graph[current]) {
                if (dist[current] + edge.weight < dist[edge.to]) {
                    result[edge.to] = current == s ? edge.to : current;
                    dist[edge.to] = dist[current] + edge.weight;
                    pq.add(edge.to);
                }
            }
        }

        return result;
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

