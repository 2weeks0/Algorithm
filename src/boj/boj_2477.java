package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2477 {
    static final int EAST = 1;
    static final int WEST = 2;
    static final int SOUTH = 3;
    static final int NORTH = 4;

    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int[] cnt = new int[5];
        Deque<Line> deque = new ArrayDeque<>();

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            deque.addLast(new Line(d, l));
            cnt[d]++;
        }

        if (cnt[EAST] == 2 && cnt[SOUTH] == 2) {
            calculate(deque, new int[]{EAST, SOUTH, NORTH, WEST});
        } else if (cnt[SOUTH] == 2 && cnt[WEST] == 2) {
            calculate(deque, new int[]{SOUTH, WEST, EAST, NORTH});
        } else if (cnt[WEST] == 2 && cnt[NORTH] == 2) {
            calculate(deque, new int[]{WEST, NORTH, SOUTH, EAST});
        } else {
            calculate(deque, new int[]{NORTH, EAST, WEST, SOUTH});
        }

        System.out.println(k * Math.abs(a - b));
        br.close();
    }

    static void calculate(Deque<Line> deque, int[] directions) {
        while (a == 0 || b == 0) {
            Line line1 = deque.pollFirst();
            Line line2 = deque.pollFirst();
            assert line1 != null;
            assert line2 != null;
            if (a == 0 && line1.d == directions[0] && line2.d == directions[1]) {
                a = line1.l * line2.l;
            } else if (line1.d == directions[2] && line2.d == directions[3]) {
                b = line1.l * line2.l;
            }
            deque.addLast(line1);
            deque.addFirst(line2);
        }
    }

    static class Line {
        int d;
        int l;

        public Line(int d, int l) {
            this.d = d;
            this.l = l;
        }
    }
}
