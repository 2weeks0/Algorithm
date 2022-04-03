package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_15659 {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arr = {2, 3, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] ops = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        recursive(n, nums, ops, new ArrayList<>(), 0);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }

    // 1 3 0 0 2
    // 1 - 0 + 4 + 30
    static void recursive(int n, int[] nums, int[] ops, List<Integer> list, int depth) {
        if (depth == n - 1) {
            Stack<Integer> stack = new Stack<>();
            stack.add(nums[0]);
            for (int i = 1; i < n; i++) {
                int op = list.get(i - 1);
                int num = nums[i];
                if (op == 2 || op == 3) {
                    stack.add(operate(stack.pop(), num, op));
                } else {
                    stack.add(op);
                    stack.add(num);
                }
            }

            int answer = 0;
            while (stack.size() != 1) {
                int b = stack.pop();
                int op = stack.pop();
                answer += operate(0, b, op);
            }
            answer += stack.pop();
            max = Math.max(max, answer);
            min = Math.min(min, answer);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) {
                continue;
            }
            ops[i]--;
            list.add(i);
            recursive(n, nums, ops, list, depth + 1);
            list.remove(list.size() - 1);
            ops[i]++;
        }
    }

    static int operate(int a, int b, int opIdx) {
        switch (opIdx) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            default:
            case 3:
                return a / b;
        }
    }
}
