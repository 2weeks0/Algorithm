package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        outer: for (int t = 0; t < tc; t++) {
            String pattern = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] arr = line.substring(1, line.length() - 1).split(",");

            boolean reversed = false;
            int left = 0;
            int right = n;
            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                if (c == 'R') {
                    reversed = !reversed;
                } else if (right <= left) {
                    bw.append("error\n");
                    continue outer;
                } else if (reversed) {
                    right--;
                } else {
                    left++;
                }
            }

            bw.append("[");
            if (!reversed) {
                for (int i = left; i < right; i++) {
                    bw.append(arr[i]);
                    if (i != right - 1) {
                        bw.append(",");
                    }
                }
            } else {
                for (int i = right - 1; left <= i; i--) {
                    bw.append(arr[i]);
                    if (i != left) {
                        bw.append(",");
                    }
                }
            }
            bw.append("]\n");
        }

        bw.close();
        br.close();
    }
}
