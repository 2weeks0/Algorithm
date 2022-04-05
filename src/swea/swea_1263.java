package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1263 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] graph = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int w = Integer.parseInt(st.nextToken());
                    graph[r][c] = (w == 1) ? 1 : (r == c ? 0 : Integer.MAX_VALUE) ;
                }
            }

            floyd(n, graph);
            int answer = Arrays.stream(graph).mapToInt(it -> Arrays.stream(it).sum()).min().getAsInt();

            bw.append(String.format("#%d %d\n", t, answer));
        }
        bw.close();
        br.close();
    }

    static void floyd(int n, int[][] graph) {
        for (int k = 0; k < n; k++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (graph[r][k] != Integer.MAX_VALUE && graph[k][c] != Integer.MAX_VALUE) {
                        graph[r][c] = Math.min(graph[r][c], graph[r][k] + graph[k][c]);
                    }
                }
            }
        }
    }
}
