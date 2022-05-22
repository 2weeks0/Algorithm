package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj_1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> neverHear = new HashSet<>();
        for (int i = 0; i < n; i++) {
            neverHear.add(br.readLine());
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (neverHear.contains(str)) {
                answer.add(str);
            }
        }

        answer.sort(Comparator.naturalOrder());
        bw.append(String.valueOf(answer.size())).append('\n');
        for (String str : answer) {
            bw.append(str).append('\n');
        }
        bw.close();
        br.close();
    }
}
