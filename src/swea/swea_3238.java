package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_3238 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            long[] factorial = new long[p + 1];
            factorial[0] = 1;
            for (int i = 1; i <= p; i++) {
                factorial[i] = i * factorial[i - 1] % p;
            }

            int answer = 1;
            while (0 < n || 0 < r) {
                int tempN = (int) (n % p);
                int tempR = (int) (r % p);

                if (tempN < tempR) {
                    answer = 0;
                    break;
                }

                answer = (int) (answer * factorial[tempN] % p
                        * power(factorial[tempN - tempR], p - 2, p) % p
                        * power(factorial[tempR], p - 2, p) % p);
                n /= p;
                r /= p;
            }
            bw.append(String.format("#%d %d\n", t + 1, answer));
        }
        bw.close();
        br.close();
    }

    static long power(long n, int p, int MOD) {
        if (p == 0) {
            return 1;
        } else if ((p & 1) == 0) {
            long temp = power(n, p >> 1, MOD) % MOD;
            return temp * temp % MOD;
        } else {
            long temp = power(n, (p - 1) >> 1, MOD) % MOD;
            return (temp * temp % MOD) * n % MOD;
        }
    }
}
