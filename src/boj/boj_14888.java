package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[n - 1];
        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                arr[idx++] = i;
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        do {
            int value = num[0];
            for (int i = 1; i < n; i++) {
                switch (arr[i - 1]) {
                    case 0:
                        value += num[i];
                        break;
                    case 1:
                        value -= num[i];
                        break;
                    case 2:
                        value *= num[i];
                        break;
                    case 3:
                        value /= num[i];
                        break;
                }
            }
            max = Math.max(max, value);
            min = Math.min(min, value);
        } while (nextPermutation(arr));

        System.out.printf("%d\n%d\n", max, min);
    }
    static boolean nextPermutation(int[] arr) {
        int left = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                left = i;
                break;
            }
        }

        if (left == -1) {
            return false;
        }

        int right = left + 1;
        for (int i = arr.length - 1; i >= right; i--) {
            if (arr[left] < arr[i]) {
                right = i;
                break;
            }
        }

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        for (int i = left + 1; i <= (arr.length + left) / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length + left - i];
            arr[arr.length + left - i] = temp;
        }
        return true;
    }
}
