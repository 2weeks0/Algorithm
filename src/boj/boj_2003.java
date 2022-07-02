package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }

        int answer = 0;
        int left = 0;
        int right = 1;
        while (left <= right && right < arr.length) {
            int temp = arr[right] - arr[left];
            if (temp == m) {
                answer++;
                left++;
            } else if (temp < m) {
                right++;
            } else {
                left++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
