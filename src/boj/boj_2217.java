package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2217 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] ropes = new Integer[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes, (i1, i2) -> Integer.compare(i2, i1));

        int answer = ropes[0];
        for (int i = 1; i < n; i++) {
            answer = Math.max(answer, (i + 1) * ropes[i]);
        }

        System.out.println(answer);
        br.close();
    }
}
