package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2628 {
    static final int HORIZON = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        List<Integer> boundW = new ArrayList<>();
        List<Integer> boundH = new ArrayList<>();
        boundW.add(0);
        boundW.add(w);
        boundH.add(0);
        boundH.add(h);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == HORIZON) {
                boundH.add(b);
            } else {
                boundW.add(b);
            }
        }

        Collections.sort(boundW);
        Collections.sort(boundH);

        int maxW = 0;
        for (int i = 0; i < boundW.size() - 1; i++) {
            maxW = Math.max(maxW, boundW.get(i + 1) - boundW.get(i));
        }
        int maxH = 0;
        for (int i = 0; i < boundH.size() - 1; i++) {
            maxH = Math.max(maxH, boundH.get(i + 1) - boundH.get(i));
        }

        System.out.println(maxH * maxW);
        br.close();
    }
}
