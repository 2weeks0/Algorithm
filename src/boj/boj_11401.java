package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11401 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] factorialArr = getFactorialArr(n);
        System.out.println(nCr(n, k, factorialArr));
        br.close();
    }

    static int[] getFactorialArr(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            result[i] = (int) ((long) i * result[i - 1] % MOD);
        }
        return result;
    }

    static int nCr(int n, int r, int[] factorialArr) {
        return (int) ((long) factorialArr[n]
                * power(factorialArr[n - r], MOD - 2) % MOD
                * power(factorialArr[r], MOD - 2) % MOD);
    }

    static int power(int n, int p) {
        if (p == 0) {
            return 1;
        } else if ((p & 1) == 0) {
            int temp = power(n, p >> 1);
            return (int) ((long) temp * temp % MOD);
        } else {
            int temp = power(n, (p - 1) >> 1);
            return (int) ((long) temp * temp % MOD * n % MOD);
        }
    }
}
