package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_12886 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[3];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sum += nums[i];
        }

        if (sum % 3 == 0) {
            dfs(nums, new boolean[1501][1501], sum / 3);
        }
        System.out.println(answer);
        br.close();
    }

    static void dfs(int[] nums, boolean[][] visited, int target) {
        if (answer == 1) {
            return;
        } else if (Arrays.stream(nums).allMatch(i -> i == target)) {
            answer = 1;
            return;
        }
        visited[nums[0]][nums[1]] = true;

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (nums[i] < nums[j]) {
                    moveStone(nums, visited, target, j, i);
                } else if (nums[j] < nums[i]) {
                    moveStone(nums, visited, target, i, j);
                }
            }
        }
    }

    static void moveStone(int[] nums, boolean[][] visited, int target, int big, int small) {
        nums[big] -= nums[small];
        nums[small] *= 2;
        if (0 <= nums[small] && 0 <= nums[big] && !visited[nums[0]][nums[1]]) {
            dfs(nums, visited, target);
        }
        nums[small] /= 2;
        nums[big] += nums[small];
    }
}
