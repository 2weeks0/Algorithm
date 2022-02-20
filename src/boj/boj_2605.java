package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_2605 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = i + 1;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cnt = Integer.parseInt(st.nextToken());

            int temp = arr[i];
            int j;
            for (j = 0; j < cnt; j++) {
                arr[i - j] = arr[i - j - 1];
            }
            arr[i - j]= temp;
        }

        for (int i = 0; i < n; i ++) {
            bw.append(String.valueOf(arr[i])).append(' ');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
