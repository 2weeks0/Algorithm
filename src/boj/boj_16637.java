package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_16637 {
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();


        if (n == 1) {
            answer = arr[0] - '0';
        } else if (n == 3) {
            answer = operate(arr[0] - '0', arr[2] - '0', arr[1]);
        } else {
            recursive(n, arr, 1, arr[0] - '0');
        }


        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, char[] arr, int idx, int value) {
        if (idx == n) {
            answer = Math.max(answer, value);
            return;
        }

        for (int i = idx; i < n; i += 2) {
            int a = operate(value, arr[i + 1] - '0', arr[i]);
            recursive(n, arr, i + 2, operate(value, arr[i + 1] - '0', arr[i]));
        }
    }

    static int operate(int a, int b, char c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
            default:
                return a * b;
        }
    }
}
