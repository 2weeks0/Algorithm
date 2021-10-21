package programmers;

import java.util.Arrays;
import java.util.HashSet;

public class 교점에_별_만들기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}})));
    }

    static class Solution {
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        public String[] solution(int[][] line) {
            HashSet<Pair> startPositionSet = new HashSet<>();
            findStarPositions(startPositionSet, line);
            return makeAnswer(startPositionSet);
        }

        public void findStarPositions(HashSet<Pair> startPositionSet, int[][] line) {
            for (int i = 0; i < line.length; i++) {
                for (int j = i + 1; j < line.length; j++) {
                    Pair point = findPoint(line[i], line[j]);
                    if (point != null) {
                        startPositionSet.add(point);
                    }
                }
            }
        }

        public Pair findPoint(int[] line1, int[] line2) {
            long ad_bc = (long) line1[0] * line2[1] - (long) line1[1] * line2[0];
            if (ad_bc == 0) {
                return null;
            }
            double x = (double) ((long) line1[1] * line2[2] - (long) line1[2] * line2[1]) / ad_bc;
            double y = (double) ((long) line1[2] * line2[0] - (long) line1[0] * line2[2]) / ad_bc;
            Pair point = null;
            if (x == Math.floor(x) && y == Math.floor(y)) {
                point = new Pair(Math.round(x), Math.round(y));
                minX = Math.min(minX, point.x);
                minY = Math.min(minY, point.y);
                maxX = Math.max(maxX, point.x);
                maxY = Math.max(maxY, point.y);
            }
            return point;
        }

        public String[] makeAnswer(HashSet<Pair> startPositionSet) {
            String[] answer = new String[(int) (maxY - minY + 1)];
            Arrays.fill(answer, ".".repeat((int) (maxX - minX + 1)));
            for (Pair point : startPositionSet) {
                answer[(int) (maxY - point.y)] =  replace(answer[(int) (maxY - point.y)], (int) (point.x - minX));
            }
            return answer;
        }

        public String replace(String old, int index) {
            return old.substring(0, index) + '*' + old.substring(index + 1);
        }

        class Pair {
            long x;
            long y;

            public Pair(long x, long y) {
                this.x = x;
                this.y = y;
            }
        }
    }


}
