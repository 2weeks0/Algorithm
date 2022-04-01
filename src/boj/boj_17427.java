package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_17427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += (n / i) * i;
        }

        System.out.println(answer);
        br.close();
    }
}


// 1 -> 1
// 2 -> 1 + 1 + 2 = 4