package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_17608 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; 0 <= i; i--) {
            if (stack.isEmpty() || stack.peek() < arr[i]) {
                stack.push(arr[i]);
            }
        }

        System.out.println(stack.size());
        br.close();
    }
}
