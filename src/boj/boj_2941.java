package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2941 {
    static final String[] alphabets = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (String s : alphabets) {
            str = str.replace(s, "a");
        }
        System.out.println(str.length());
        br.close();
    }
}
