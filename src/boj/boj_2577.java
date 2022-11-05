package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2577 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        for (int i = 0; i < 3; i++) {
            num *= Integer.parseInt(br.readLine());
        }
        String s = String.valueOf(num);
        int[] arr = new int[10];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - '0']++;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        br.close();
    }
}
