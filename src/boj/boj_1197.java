package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1197 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, weight);
        }

        System.out.println(kruskal(v, edges));
        br.close();
    }

    static int kruskal(int v, Edge[] edges) {
        int result = 0;
        int[] set = makeSet(v);
        Arrays.sort(edges);

        for (Edge edge: edges) {
            if (unionSet(set, edge.from, edge.to)) {
                result += edge.weight;
            }
        }
        return result;
    }

    static int[] makeSet(int v) {
        int[] result = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            result[i] = i;
        }
        return result;
    }

    static int findSet(int[] set, int a) {
        if (a == set[a]) {
            return a;
        }
        return set[a] = findSet(set, set[a]);
    }

    static boolean unionSet(int[] set, int a, int b) {
        int rootA = findSet(set, a);
        int rootB = findSet(set, b);
        if (rootA == rootB) {
            return false;
        }
        set[rootB] = rootA;
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
