package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_5800 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int gap = 0;
            for (int j = 1; j < n; j++) {
                gap = Math.max(gap, arr[j] - arr[j - 1]);
            }

            bw.append("Class ").append(String.valueOf(i + 1)).append('\n')
                    .append("Max ").append(String.valueOf(arr[n - 1]))
                    .append(", Min ").append(String.valueOf(arr[0]))
                    .append(", Largest gap ").append(String.valueOf(gap)).append('\n');
        }
        bw.close();
        br.close();
    }
}
