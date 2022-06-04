package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] answer = {0, Integer.MAX_VALUE};

        for (int i = 0; i < n; i++) {
            int idx = binarySearch(arr, 0, n - 1, -arr[i]);

            for (int j = 0; j <= 1; j++) {
                int target = idx - j;
                if (i == target || target < 0) {
                    continue;
                }

                if (Math.abs(arr[i] + arr[target]) < Math.abs(answer[0] + answer[1])) {
                    answer[0] = arr[i];
                    answer[1] = arr[target];
                }
            }
        }

        Arrays.sort(answer);
        System.out.printf("%d %d\n", answer[0], answer[1]);
        br.close();
    }

    static int binarySearch(int[] arr, int left, int right, int value) {
        if (right <= left) {
            return right;
        }

        int mid = (left + right) / 2;
        if (value < arr[mid]) {
            return binarySearch(arr, left, mid, value);
        } else {
            return binarySearch(arr, mid + 1, right, value);
        }
    }
}
