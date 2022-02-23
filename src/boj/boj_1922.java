package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1922 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edges);
        int cnt = 0;
        int answer = 0;
        for (Edge edge: edges) {
            if (unionSet(parents, edge.from, edge.to)) {
                answer += edge.weight;
            }
            if (cnt == n - 1) {
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static int findSet(int[] parents, int a) {
        if (a == parents[a]) {
            return a;
        }
        return parents[a] = findSet(parents, parents[a]);
    }

    static boolean unionSet(int[] parents, int a, int b) {
        int rootA = findSet(parents,a);
        int rootB = findSet(parents,b);
        if (rootA == rootB) {
            return false;
        }
        parents[rootB] = rootA;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }
}
