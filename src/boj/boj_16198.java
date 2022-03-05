package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16198 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recursive(n, arr, new boolean[n], 0, 0);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int[] arr, boolean[] selected, int cnt, int value) {
        if (cnt == n - 2) {
            answer = Math.max(answer, value);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            if (selected[i]) {
                continue;
            }

            selected[i] = true;
            int left = i - 1;
            while (selected[left]) {
                left--;
            }
            int right = i + 1;
            while (selected[right]) {
                right++;
            }
            recursive(n, arr, selected, cnt + 1, value + arr[left] * arr[right]);
            selected[i] = false;
        }
    }
}
