package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_16943 {
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        Integer[] nums = new Integer[a.length()];
        for (int i = 0; i < a.length(); i++) {
            nums[i] = a.charAt(i) - '0';
        }

        Arrays.sort(nums, Comparator.reverseOrder());
        permutation(b, nums, 0, 0, new boolean[nums.length]);

        System.out.println(answer);
        br.close();
    }

    static void permutation(int b, Integer[] nums, int idx, int value, boolean[] selected) {
        if (answer != -1) {
            return;
        } else if (idx == nums.length && value < b) {
            answer = value;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (selected[i] || (value == 0 && nums[i] == 0)) {
                continue;
            }
            selected[i] = true;
            permutation(b, nums, idx + 1, value * 10 + nums[i], selected);
            selected[i] = false;
        }
    }
}
