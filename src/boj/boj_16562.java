package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16562 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] costs = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int[] set = makeSet(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            unionSet(set, costs, a, b);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int root = findSet(set, i);
            if (costs[root] != -1) {
                sum += costs[root];
                costs[root] = -1;
            }
        }

        System.out.println(sum <= k ? sum : "Oh no");
        br.close();
    }

    static int[] makeSet(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;
    }

    static int findSet(int[] set, int a) {
        int rootA = set[a];
        if (rootA == a) {
            return a;
        }
        return (set[rootA] = findSet(set, rootA));
    }

    static void unionSet(int[] set, int[] costs, int a, int b) {
        int rootA = findSet(set, a);
        int rootB = findSet(set, b);
        if (rootA == rootB) {
            return;
        }

        if (costs[rootA] < costs[rootB]) {
            set[rootB] = rootA;
        } else {
            set[rootA] = rootB;
        }
    }
}
