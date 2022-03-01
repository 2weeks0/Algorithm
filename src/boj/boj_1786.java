package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class boj_1786 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        List<Integer> result = kmp(text, pattern, getPi(pattern));

        bw.append(String.valueOf(result.size()));
        for (int idx: result) {
            bw.append('\n').append(String.valueOf(idx + 1));
        }

        bw.close();
        br.close();
    }

    static int[] getPi(char[] pattern) {
        int[] pi = new int[pattern.length];

        for (int i = 1, j = 0; i < pattern.length; i++) {
            while (0 < j && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }

            if (pattern[i] == pattern[j]) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    static List<Integer> kmp(char[] text, char[] pattern, int[] pi) {
        List<Integer> result = new LinkedList<>();

        for (int i = 0, j = 0; i < text.length; i++) {
            while (0 < j && text[i] != pattern[j]) {
                j = pi[j - 1];
            }

            if (text[i] == pattern[j]) {
                if (j == pattern.length - 1) {
                    result.add(i - j);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        return result;
    }
}
