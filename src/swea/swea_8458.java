package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_8458 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        outer:
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            boolean[] isEvens = new boolean[n];
            int maxDist = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dist = Math.abs(x) + Math.abs(y);
                isEvens[i] = (dist & 1) == 0;
                if (maxDist < dist) {
                    maxDist = dist;
                }
            }

            boolean isEven = isEvens[0];
            for (int i = 1; i < n; i++) {
                if (isEvens[i] != isEven) {
                    bw.append(String.format("#%d %d\n", t, -1));
                    continue outer;
                }
            }

            int sum = 0;
            int i = 0;
            while (true) {
                if (maxDist == sum || (maxDist < sum && (Math.abs(maxDist - sum) & 1) == 0)) {
                    break;
                }
                sum += ++i;
            }
            bw.append(String.format("#%d %d\n", t, i));
        }
        bw.close();
        br.close();
    }
}
