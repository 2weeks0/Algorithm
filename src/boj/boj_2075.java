package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2075 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer>[] stacks = new Stack[n];
        for (int i = 0; i < n; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                stacks[j].add(Integer.parseInt(st.nextToken()));
            }
        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            int idx = 0;
            max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (max < stacks[j].peek()) {
                    max = stacks[j].peek();
                    idx = j;
                }
            }
            stacks[idx].pop();
        }
        System.out.println(max);
        br.close();
    }
}
