package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            if ((n % i) == 0) {
                k--;
                if (k == 0) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
