package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_25332 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sumA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sumA[i] = Integer.parseInt(st.nextToken());
            if (0 < i) {
                sumA[i] += sumA[i - 1];
            }
        }

        int[] sumB = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sumB[i] = Integer.parseInt(st.nextToken());
            if (0 < i) {
                sumB[i] += sumB[i - 1];
            }
        }

        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            int diff = sumA[i] - sumB[i];
            answer += map.getOrDefault(diff, 0);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        System.out.println(answer);
        br.close();
    }
}
