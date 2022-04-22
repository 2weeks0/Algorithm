package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_24955 {
    static final int MOD = 1_000_000_007;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            traverse(nums, graph, new boolean[n], start, end, 0);
            bw.append(String.valueOf(answer)).append('\n');
        }
        bw.close();
        br.close();
    }

    static void traverse(int[] nums, LinkedList<Integer>[] graph, boolean[] visited, int current, int end, long value) {
        visited[current] = true;
        int num = nums[current];
        value = mulMod(value, (long) Math.pow(10, String.valueOf(num).length()));
        value = addMod(value, num);
        if (current == end) {
            answer = (int) value;
            return;
        }

        for (int next : graph[current]) {
            if (visited[next]) {
                continue;
            }
            traverse(nums, graph, visited, next, end, value);
        }
    }

    static long addMod(long a, long b) {
        long modA = a % MOD;
        long modB = b % MOD;

        if (modA == 0) {
            return modB;
        } else if (modB == 0) {
            return modA;
        } else if (modA + modB <= modA) {
            return (modA + modB - MOD) % MOD;
        } else {
            return (modA + modB) % MOD;
        }
    }

    static long mulMod(long a, long b) {
        long modA = a % MOD;
        long modB = b % MOD;

        if (modA == 0 || modB == 0) {
            return 0;
        } else if (modA == 1) {
            return modB;
        } else if (modB == 1) {
            return modA;
        }

        long temp = mulMod(modA, modB / 2);
        if (modB % 2 == 0) {
            return addMod(temp, temp);
        }
        return addMod(modA, addMod(temp, temp));
    }
}
