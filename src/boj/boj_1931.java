package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(meetings, (m1, m2) -> {
            if (m1[1] == m2[1]) {
                return Integer.compare(m1[0], m2[0]);
            }
            return Integer.compare(m1[1], m2[1]);
        });

        int cnt = 1;
        int[] last = meetings[0];
        for (int i = 1; i < n; i++) {
            if (last[1] <= meetings[i][0]) {
                last = meetings[i];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
