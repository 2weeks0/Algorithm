package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int minusIdx = -1;
        for (int i = 0; i < input.length();i++) {
            if (input.charAt(i) == '-') {
                minusIdx = i;
                break;
            }
        }

        int answer = Arrays.stream(input.substring(minusIdx + 1).split("[\\-+]"))
                .map(Integer::parseInt)
                .mapToInt(i -> i)
                .sum();
        if (minusIdx != -1) {
            answer *= -1;
            answer += Arrays.stream(input.substring(0, minusIdx).split("[\\-+]"))
                    .map(Integer::parseInt)
                    .mapToInt(i -> i)
                    .sum();
        }

        System.out.println(answer);
        br.close();
    }
}
