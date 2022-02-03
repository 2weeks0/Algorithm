package boj;

import java.util.Scanner;

public class boj_1057 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int kim = scanner.nextInt();
        int lim = scanner.nextInt();
        int answer = 1;

        while (true) {
            int min = Math.min(kim, lim);
            int max = Math.max(kim, lim);
            if (getNextNum(min) == getNextNum(max)) {
                System.out.println(answer);
                return;
            }
            answer++;
            kim = getNextNum(kim);
            lim = getNextNum(lim);
        }
    }

    static int getNextNum(int num) {
        return num % 2 == 0 ? num / 2 : (num + 1) / 2;
    }
}
