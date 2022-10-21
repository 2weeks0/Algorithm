package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2902 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s.charAt(0));
        }
        System.out.println(sb);
        br.close();
    }
}
