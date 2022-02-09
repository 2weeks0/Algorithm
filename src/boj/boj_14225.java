package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14225 {

    static int[] cached = new int[20 * 100000 + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        recursive(n, 0, nums, 0);

        for (int i = 1; ; i++) {
            if (cached[i] == 0) {
                System.out.println(i);
                return;
            }
        }
    }

    static void recursive(int n, int idx, int[] nums, int sum) {
        if (idx == n) {
            cached[sum] = 1;
            return;
        }

        recursive(n, idx + 1, nums, sum + nums[idx]);
        recursive(n, idx + 1, nums, sum);
    }
}
