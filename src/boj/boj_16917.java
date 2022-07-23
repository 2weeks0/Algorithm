package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16917 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int answer = 0;
        if (a + b < 2 * c) {
            answer = a * x + b * y;
        } else if (x < y) {
            answer = x * 2 * c + Math.min((y - x) * b, (y - x) * 2 * c);
        } else {
            answer = y * 2 * c + Math.min((x - y) * a, (x - y) * 2 * c);
        }
        System.out.println(answer);
        br.close();
    }
}
