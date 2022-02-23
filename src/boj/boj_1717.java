package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_1717 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr=  makeSet(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (f == 0) {
                unionSet(arr, a, b);
            } else {
                bw.append(findSet(arr, a) == findSet(arr, b) ? "YES" : "NO");
                bw.newLine();
            }
        }

        bw.close();
        br.close();
    }

    static int[] makeSet(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = i;
        }
        return result;
    }

    static int findSet(int[] arr, int a) {
        if (a == arr[a]) {
            return a;
        }
        return arr[a] = findSet(arr, arr[a]);
    }

    static boolean unionSet(int[] arr, int a, int b) {
        int rootA = findSet(arr, a);
        int rootB = findSet(arr, b);
        if (rootA == rootB) {
            return false;
        }
        arr[rootB] = rootA;
        return true;
    }
}
