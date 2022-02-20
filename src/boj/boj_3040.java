package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_3040 {
    static boolean findAnswer;
    static int SIZE_ORIGIN = 7;
    static int SIZE_FAKE = 9;
    static int SUM = 100;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[SIZE_FAKE];
        for (int i = 0; i < SIZE_FAKE; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        combination(arr, 0, 0, new int[SIZE_ORIGIN]);
    }

    static void combination(int[] arr, int cnt, int idx, int[] selected) {
        if (findAnswer) {
            return;
        } else if (SIZE_ORIGIN == cnt) {
            if (Arrays.stream(selected).sum() == SUM) {
                findAnswer = true;
                StringBuilder sb = new StringBuilder();
                Arrays.stream(selected).forEach(it -> sb.append(it).append('\n'));
                System.out.print(sb);
            }
            return;
        }

        for (int i = idx; i < SIZE_FAKE; i++) {
            selected[cnt] = arr[i];
            combination(arr, cnt + 1, i + 1, selected);
        }
    }
}
