package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1120 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= b.length() - a.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(i + j)) {
                    cnt++;
                }
            }
            min = Math.min(min, cnt);
        }

        System.out.println(min);
        br.close();
    }
}
