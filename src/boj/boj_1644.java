package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class boj_1644 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = 2; i * j <= n; j++) {
                isPrime[i * j] = false;
            }
            list.add(i + list.get(list.size() - 1));
        }

        int answer = 0;
        int left = 0;
        int right = 1;
        while (left < right && right < list.size()) {
            int temp = list.get(right) - list.get(left);
            if (temp < n) {
                right++;
            } else if (temp == n) {
                answer++;
                left++;
            } else {
                left++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
