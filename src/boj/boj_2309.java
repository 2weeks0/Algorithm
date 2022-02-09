package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_2309 {
    static boolean find;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        permutation(nums, new ArrayList<>(), 0, new boolean[9]);
        br.close();
    }

    static void permutation(int[] nums, List<Integer> list, int sum, boolean[] selected) throws Exception {
        if (find) {
            return;
        } else if (list.size() == 7) {
            if (sum == 100) {
                find = true;
                printAnswer(list);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (selected[i]) {
                continue;
            }

            selected[i] = true;
            list.add(nums[i]);
            permutation(nums, list, sum + nums[i], selected);
            list.remove(list.size() - 1);
            selected[i] = false;
        }
    }

    static void printAnswer(List<Integer> list) throws Exception {
        Collections.sort(list);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : list) {
            bw.append(String.valueOf(i));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
