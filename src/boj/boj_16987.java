package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_16987 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Egg[] eggs = new Egg[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(s, w);
        }

        recursive(n, eggs, 0);

        System.out.println(answer);
        br.close();
    }

    static void recursive(int n, Egg[] eggs, int idx) {
        if (idx == n) {
            answer = Math.max(answer, (int) Arrays.stream(eggs).filter(it -> it.s <= 0).count());
            return;
        } else if (eggs[idx].s <= 0) {
            recursive(n, eggs, idx + 1);
            return;
        }

        boolean f = false;
        for (int next = 0; next < n; next++) {
            if (idx == next || eggs[next].s <= 0) {
                continue;
            }
            f = true;
            eggs[next].s -= eggs[idx].w;
            eggs[idx].s -= eggs[next].w;
            recursive(n, eggs, idx + 1);
            eggs[next].s += eggs[idx].w;
            eggs[idx].s += eggs[next].w;
        }
        if (!f) {
            recursive(n, eggs, n);
        }
    }

    static class Egg {
        int s;
        int w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
}
