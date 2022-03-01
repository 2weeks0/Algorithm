package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_2635 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> before = new ArrayList<>(30000);
        List<Integer> after = new ArrayList<>(30000);
        for (int i = n / 2; i <= n; i++) {
            after.clear();
            after.add(n);
            after.add(i);
            int idx = 0;
            while (0 <= after.get(idx) - after.get(idx + 1)) {
                after.add(after.get(idx) - after.get(idx + 1));
                idx++;
            }

            if (before.size() < after.size()) {
                before.clear();
                before.addAll(after);
            } else if (after.size() < before.size()) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(before.size()).append('\n');
        for (int num : before) {
            sb.append(num).append(' ');
        }
        System.out.println(sb);
        br.close();
    }
}
