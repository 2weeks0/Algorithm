package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1543 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int answer = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.startsWith(b, i)) {
                answer++;
                i += b.length() - 1;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
