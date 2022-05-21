package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_10953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(",");
            bw.append(String.valueOf(Integer.parseInt(split[0]) + Integer.parseInt(split[1]))).append('\n');
        }

        bw.close();
        br.close();
    }
}
