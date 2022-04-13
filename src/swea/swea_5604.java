package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_5604 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            bw.append(String.format("#%d %d\n", t + 1, getSum(b) - getSum(a - 1)));
        }
        bw.close();
        br.close();
    }

    static long getSum(long n) {
        long result = 0;
        long i = 1;
        long mod = 0;
        while (0 < n) {
            int temp = (int) (n % 10);
            n /= 10;
            for (int j = 1; j < temp; j++) {
                result += j * i * (n + 1);
            }
            result += temp * (i * n + mod + 1);
            for (int j = temp + 1; j < 10; j++) {
                result += j * i * n;
            }
            mod += temp * i;
            i *= 10;
        }
        return result;
    }
}
