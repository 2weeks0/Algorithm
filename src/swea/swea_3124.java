package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3124 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Edge[] edges = new Edge[e];
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(a, b, c);
            }

            bw.append('#').append(String.valueOf(t)).append(' ').append(String.valueOf(kruskal(v, edges))).append('\n');
        }
        bw.close();
        br.close();
    }

    static long kruskal(int v, Edge[] edges) {
        int[] set = makeSet(v);
        Arrays.sort(edges);

        int cnt = 0;
        long answer = 0;
        for (Edge edge : edges) {
            if (unionSet(set, edge.from, edge.to)) {
                answer += edge.weight;
                cnt++;
            }
            if (cnt == v - 1) {
                break;
            }
        }
        return answer;
    }

    static int[] makeSet(int v) {
        int[] set = new int[v];
        for (int i = 0; i < v; i++) {
            set[i] = i;
        }
        return set;
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
            return Integer.compare(this.weight, o.weight);
        }
    }
}