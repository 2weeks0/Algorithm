package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2512 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int cost = Integer.parseInt(br.readLine());
        if (sum <= cost) {
            System.out.println(Arrays.stream(arr).max().getAsInt());
        } else {
            System.out.println(binarySearch(arr, 0, cost, cost) - 1);
        }

        br.close();
    }

    static int binarySearch(int[] arr, int left, int right, int cost) {
        if (right <= left) {
            return right;
        }

        int mid = (left + right) / 2;

        int sum = 0;
        for (int i : arr) {
            sum += Math.min(i, mid);
        }

        if (sum <= cost) {
            return binarySearch(arr, mid + 1, right, cost);
        } else {
            return binarySearch(arr, left, mid, cost);
        }
    }
}
