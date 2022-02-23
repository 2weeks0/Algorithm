package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1647 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, weight);
        }

        System.out.println(kruskal(n, edges));
        br.close();
    }

    static int kruskal(int n, Edge[] edges) {
        int result = 0;
        int max = 0;
        int cnt = 0;

        int[] set = makeSet(n);
        Arrays.sort(edges);
        for (Edge edge: edges) {
            if (unionSet(set, edge.from, edge.to)) {
                result += edge.weight;
                max = Math.max(max, edge.weight);
                if (++cnt == n - 1) {
                    break;
                }
            }
        }

        return result - max;
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

    static int findSet(int[] set, int a) {
        if (a == set[a]) {
            return a;
        }
        return set[a] = findSet(set, set[a]);
    }

    static int[] makeSet(int n) {
        int[] result = new int[n];
        for (int i = 0 ; i < n; i++) {
            result[i] = i;
        }
        return result;
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
