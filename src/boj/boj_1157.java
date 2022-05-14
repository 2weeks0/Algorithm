package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1157 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase(Locale.ROOT);
        int[] cnts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            cnts[c - 'a']++;
        }

        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (max <= cnts[i]) {
                if (max < cnts[i]) {
                    max = cnts[i];
                    list.clear();
                }
                list.add(i);
            }
        }

        char answer;
        if (1 < list.size()) {
            answer = '?';
        } else {
            answer = (char) (list.get(0) + 'A');
        }

        System.out.println(answer);
        br.close();
    }
}
