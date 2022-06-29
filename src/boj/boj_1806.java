package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }

        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;

        while (left < right && right < arr.length) {
            if (s <= arr[right] - arr[left]) {
                answer = Math.min(answer, right - left);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
        br.close();
    }
}
