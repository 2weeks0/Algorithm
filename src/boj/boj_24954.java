package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_24954 {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] costs = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Sale>[] sales = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            sales[i] = new LinkedList<>();
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()) - 1;
                int value = Integer.parseInt(st.nextToken());
                sales[i].add(new Sale(idx, value));
            }
        }

        recursive(n, costs, sales, new boolean[n], 0, 0);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int[] costs, LinkedList<Sale>[] sales, boolean[] selected, int depth, int value) {
        if (depth == n) {
            answer = Math.min(answer, value);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            int[] tempCosts = costs.clone();
            for (Sale sale : sales[i]) {
                tempCosts[sale.idx] = Math.max(1, tempCosts[sale.idx] - sale.value);
            }
            recursive(n, tempCosts, sales, selected, depth + 1, value + costs[i]);
            selected[i] = false;
        }
    }

    static class Sale {
        int idx;
        int value;

        public Sale(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
