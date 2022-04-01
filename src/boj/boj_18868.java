package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18868 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        for (int r = 0; r < m; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            loop: for (int j = i + 1; j < m; j++) {
                int[] a = arr[i];
                int[] b = arr[j];
                for (int k = 0; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (!((a[k] < a[l] && b[k] < b[l])
                                || (a[k] == a[l] && b[k] == b[l])
                                || (a[k] > a[l] && b[k] > b[l]))) {
                            continue loop;
                        }
                    }
                }
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
