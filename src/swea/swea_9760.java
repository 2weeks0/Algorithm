package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class swea_9760 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = initMap();

        String[] cards = new String[5];
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++) {
                cards[i] = st.nextToken();
            }

            bw.append(String.format("#%d %s\n", t + 1, solve(cards, map)));
        }
        bw.close();
        br.close();
    }

    static Map<Character, Integer> initMap() {
        Map<Character, Integer> result = new HashMap<>();
        result.put('A', 0);
        for (int i = 2; i <= 9; i++) {
            result.put((char) (i + '0'), i - 1);
        }
        result.put('T', 9);
        result.put('J', 10);
        result.put('Q', 11);
        result.put('K', 12);
        return result;
    }

    static String solve(String[] cards, Map<Character, Integer> map) {
        Set<Character> suit = new HashSet<>();
        int[] rank = new int[13];
        for (String s : cards) {
            suit.add(s.charAt(0));
            rank[map.get(s.charAt(1))]++;
        }

        boolean isStraight = isStraight(rank);
        int suitSize = suit.size();

        if (suitSize == 1 && isStraight) {
            return "Straight Flush";
        } else if (Arrays.stream(rank).anyMatch(it -> it == 4)) {
            return "Four of a Kind";
        } else if (Arrays.stream(rank).map(it -> it == 3 ? 3 : it == 2 ? 2 : 0).sum() == 5) {
            return "Full House";
        } else if (suitSize == 1) {
            return "Flush";
        } else if (isStraight) {
            return "Straight";
        } else if (Arrays.stream(rank).anyMatch(it -> it == 3)) {
            return "Three of a kind";
        } else if (Arrays.stream(rank).map(it -> it == 2 ? 1 : 0).filter(it -> it == 1).count() == 2) {
            return "Two pair";
        } else if (Arrays.stream(rank).anyMatch(it -> it == 2)) {
            return "One pair";
        } else {
            return "High card";
        }
    }

    static boolean isStraight(int[] rank) {
        for (int i = 0; i < rank.length; i++) {
            if (rank[i] == 1) {
                for (int j = i + 1; j < i + 5; j++) {
                    if (rank[j % rank.length] != 1) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
