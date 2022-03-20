package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15684 {
    static final int MAX_COUNT = 3;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[h][n - 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a][b] = true;
        }

        for (int i = 0; i <= 3; i++) {
            combination(n, h, graph, new int[i], i, 0, 0);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }

    static void combination(int n, int h, boolean[][] graph, int[] selected, int cntMax, int cnt, int idx) {
        if (answer != Integer.MAX_VALUE) {
            return;
        } else if (cnt == cntMax) {
            for (int i : selected) {
                int r = i / (n - 1);
                int c = i % (n - 1);
                graph[r][c] = true;
            }
            for (int s = 0; s < n; s++) {
                if (!search(n, h, graph, s)) {
                    for (int i : selected) {
                        int r = i / (n - 1);
                        int c = i % (n - 1);
                        graph[r][c] = false;
                    }
                    return;
                }
            }

            answer = cnt;
            return;
        }

        for (int i = idx; i < h * (n - 1); i++) {
            int r = i / (n - 1);
            int c = i % (n - 1);
            if (graph[r][c] || (c != 0 && graph[r][c - 1]) || (c != n - 2 && graph[r][c + 1])) {
                continue;
            }
            selected[cnt] = i;
            combination(n, h, graph, selected, cntMax, cnt + 1, i + 1);
        }
    }

    static boolean search(int n, int h, boolean[][] graph, int c) {
        int temp = c;
        for (int r = 0; r < h; r++) {
            if (temp != n - 1 && graph[r][temp]) {
                temp++;
            } else if (temp != 0 && graph[r][temp - 1]) {
                temp--;
            }
        }
        return temp == c;
    }
}
