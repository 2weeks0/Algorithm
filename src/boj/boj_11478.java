package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class boj_11478 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; i + j <= str.length(); j++) {
                set.add(str.substring(i, i + j));
            }
        }

        System.out.println(set.size());
        br.close();
    }
}
