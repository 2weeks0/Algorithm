package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class swea_5643 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                arr[a][b] = -1;
                arr[b][a] = 1;
            }

            floyd(n, arr);

            int answer = (int) Arrays.stream(arr)
                    .mapToInt(it -> (int) Arrays.stream(it).filter(i -> i == 0).count())
                    .filter(it -> it == 1)
                    .count();
            bw.append(String.format("#%d %d\n", t, answer));
        }
        bw.close();
        br.close();
    }

    static void floyd(int n, int[][] arr) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                        arr[j][i] = -1;
                    }
                }
            }
        }
    }
}
