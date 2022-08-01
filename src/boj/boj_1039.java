package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1039 {
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = (int) Math.log10(n) + 1;

        boolean[][] visited = new boolean[1_100_001][k + 1];
        visited[n][0]= true;

        recursive(n, k, l, n, 0, visited);
        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, int k, int l, int num, int cnt, boolean[][] visited) {
        visited[num][cnt] = true;
        if (cnt == k) {
            answer = Math.max(answer, num);
            return;
        }

        for (int i = l - 1; 0 <= i; i--) {
            int left = (num / (int) Math.pow(10, i)) % 10;
            for (int j = i - 1; 0 <= j; j--) {
                int right = (num / (int) Math.pow(10, j)) % 10;
                if (i == l - 1 && right == 0) {
                    continue;
                }
                int temp = num;
                temp += -left * (int) Math.pow(10, i) + right * (int) Math.pow(10, i);
                temp += left * (int) Math.pow(10, j) - right * (int) Math.pow(10, j);
                if (visited[temp][cnt + 1]) {
                    continue;
                }
                recursive(n, k, l, temp, cnt + 1, visited);
            }
        }
    }
}
