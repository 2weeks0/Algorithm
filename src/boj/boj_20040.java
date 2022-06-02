package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20040 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] set = makeSet(n);

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!unionSet(set, a, b)) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }

    static int[] makeSet(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;
    }

    static int findSet(int[] set, int a) {
        int rootA = set[a];
        if (rootA == a) {
            return a;
        }
        return (set[rootA] = findSet(set, rootA));
    }

    static boolean unionSet(int[] set, int a, int b) {
        int rootA = findSet(set, a);
        int rootB = findSet(set, b);
        if (rootA == rootB) {
            return false;
        }

        set[rootB] = rootA;
        return true;
    }
}
