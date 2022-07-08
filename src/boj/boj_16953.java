package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while (true) {
            if (a == b) {
                break;
            } else if (b % 10 == 1) {
                b /= 10;
            } else if (b != 0 && b % 2 == 0) {
                b /= 2;
            } else {
                cnt = -1;
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
        br.close();
    }
}
