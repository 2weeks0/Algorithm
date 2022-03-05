package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16637 {
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        if (n == 1) {
            answer = arr[0] - '0';
        } else {
            recursive(n, arr, 1, new boolean[n]);
        }


        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, char[] arr, int opIdx, boolean[] selected) {
        if (n <= opIdx) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i += 2) {
                 if (i != n - 1 && selected[i + 1]) {
                    int num = operate(arr[i] - '0', arr[i + 2] - '0', arr[i + 1]);
                    deque.add(num);
                    i += 2;
                } else {
                    deque.add(arr[i] - '0');
                }
            }

            int result = deque.pollFirst();
            for (int i = 1; i < n; i += 2) {
                if (!selected[i]) {
                    result = operate(result, deque.pollFirst(), arr[i]);
                }
            }
            answer = Math.max(answer, result);
            return;
        }

        selected[opIdx] = true;
        recursive(n, arr, opIdx + 4, selected);
        selected[opIdx] = false;
        recursive(n, arr, opIdx + 2, selected);
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
