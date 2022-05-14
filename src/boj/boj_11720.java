package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_11720 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += str.charAt(i) - '0';
        }
        System.out.println(answer);
        br.close();
    }
}
