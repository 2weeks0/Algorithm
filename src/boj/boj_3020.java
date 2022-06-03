package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3020 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] botCnt = new int[h + 1];
        int[] topCnt = new int[h + 1];
        for (int i = 0; i < n / 2; i++) {
            botCnt[Integer.parseInt(br.readLine())]++;
            topCnt[Integer.parseInt(br.readLine())]++;
        }

        for (int i = h - 1; 1 <= i; i--) {
            botCnt[i] += botCnt[i + 1];
            topCnt[i] += topCnt[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            int temp = botCnt[i] + topCnt[h - i + 1];
            if (temp < min) {
                cnt = 1;
                min = temp;
            } else if (temp == min) {
                cnt++;
            }
        }

        System.out.printf("%d %d\n", min, cnt);
        br.close();
    }
}
