package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_6026 {
    static final int MOD = 1_000_000_007;
    static final int MAX_N = 100;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        long[] factorial = getFactorial();
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            bw.append(String.format("#%d %d\n", t + 1, solve(m, n, factorial)));
        }
        bw.close();
        br.close();
    }

    static long[] getFactorial() {
        long[] result = new long[MAX_N + 1];
        result[0] = 1;
        for (int i = 1; i <= MAX_N; i++) {
            result[i] = i * result[i - 1] % MOD;
        }
        return result;
    }


    // 전사 함수 경우의 수: sigma {(-1)^i * mCi * (m - i)^n}
    static long solve(int m, int n, long[] factorial) {
        long result = 0;
        for (int i = 0; i <= m; i++) {
            result += ((i & 1) == 0 ? 1 : -1) * nCr(m, i, factorial) * power(m - i, n) % MOD;
            result += MOD;
            result %= MOD;
        }
        return result;
    }

    // 페르마 소정리: nCr % MOD = n! * (n - r)^(MOD -2) * r^(MOD - 2)
    static long nCr(int n, int r, long[] factorial) {
        return factorial[n]
                * power(factorial[n - r], MOD - 2) % MOD
                * power(factorial[r], MOD - 2) % MOD;
    }

    static long power(long n, int p) {
        if (p == 0) {
            return 1;
        }
        if ((p & 1) == 0) {
            long temp = power(n, p >> 1);
            return temp * temp % MOD;
        } else {
            long temp = power(n, (p - 1) >> 1);
            return temp * temp % MOD * n % MOD;
        }
    }
}
