package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15681 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int q = Integer.parseInt(st.nextToken());

        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new LinkedList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            lists[u].add(v);
            lists[v].add(u);
        }

        int[] dp = new int[n];
        recursive(lists, dp, r, -1);

        for (int i = 0; i < q; i++) {
            int u = Integer.parseInt(br.readLine()) - 1;
            bw.append(String.valueOf(dp[u])).append('\n');
        }

        bw.close();
        br.close();
    }

    static void recursive(List<Integer>[] lists, int[] dp, int child, int parent) {
        if (dp[child] != 0) {
            return;
        }

        dp[child] = 1;
        for (int next : lists[child]) {
            recursive(lists, dp, next, child);
        }

        if (parent != -1) {
            dp[parent] += dp[child];
        }
    }
}
