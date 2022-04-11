package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_5607 {
    static final int MOD = 1234567891;
    static final int MAX_N = 1_000_000;
    static long[] factorial = new long[MAX_N + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        initFactorial();
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            long answer = factorial[n]
                    * power(factorial[n - r], MOD - 2) % MOD
                    * power(factorial[r], MOD - 2) % MOD;
            bw.append(String.format("#%d %d\n", t + 1, answer));
        }
        bw.close();
        br.close();
    }

    static void initFactorial() {
        factorial[0] = 1;
        for (int i = 1; i <= MAX_N; i++) {
            factorial[i] = i * factorial[i - 1] % MOD;
        }
    }

    static long power(long n, int p) {
        if (p == 0) {
            return 1;
        } else if ((p & 1) == 0) {
            long temp = power(n, p >> 1) % MOD;
            return temp * temp % MOD;
        } else {
            long temp = power(n, (p - 1) >> 1) % MOD;
            return (temp * temp % MOD) * n % MOD;
        }
    }
}
