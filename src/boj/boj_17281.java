package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_17281 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inning = Integer.parseInt(br.readLine());
        int[][] arr = new int[inning][9];

        for (int i = 0; i < inning; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permutation(inning, arr, new int[9], new boolean[9], 0);

        System.out.println(answer);
        br.close();
    }

    static void permutation(int inning, int[][] arr, int[] permutation, boolean[] selected, int idx) {
        if (idx == 9) {
            answer = Math.max(answer, calculate(inning, arr, permutation));
            return;
        }

        if (idx == 3) {
            selected[0] = true;
            permutation[idx] = 0;
            permutation(inning, arr, permutation, selected, idx + 1);
        } else {
            for (int i = 1; i < 9; i++) {
                if (selected[i]) {
                    continue;
                }
                selected[i] = true;
                permutation[idx] = i;
                permutation(inning, arr, permutation, selected, idx + 1);
                selected[i] = false;
            }
        }
    }

    static int calculate(int inning, int[][] arr, int[] permutation) {
        int result = 0;
        int cntOut = 0;
        int idx = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 3; i++) {
            deque.addLast(0);
        }

        int lastInning = 0;
        while (cntOut != 3 * inning) {
            int currentInning = cntOut / 3;
            if (currentInning != lastInning) {
                clear(deque);
                lastInning = currentInning;
            }
            if (arr[currentInning][permutation[idx]] == 0) {
                cntOut++;
            } else {
                result += hit(deque, arr[currentInning][permutation[idx]]);
            }
            idx = (idx + 1) % 9;
        }

        return result;
    }

    static int hit(Deque<Integer> deque, int n) {
        int result = deque.pollFirst();
        deque.addLast(1);
        for (int i = 0; i < n - 1; i++) {
            result += deque.pollFirst();
            deque.addLast(0);
        }
        return result;
    }

    static void clear(Deque<Integer> deque) {
        for (int i = 0; i < 3; i++) {
            deque.pollFirst();
            deque.addLast(0);
        }
    }
}
