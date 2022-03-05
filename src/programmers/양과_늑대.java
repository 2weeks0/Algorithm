package programmers;

import java.util.HashSet;
import java.util.Set;

public class 양과_늑대 {
    public static void main(String[] args) {
//        System.out.println(new Solution().solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}));
        System.out.println(new Solution().solution(new int[]{0,1,0,1,1,0,1,0,0,1,0}, new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}}));
    }

    static class Solution {
        static final int SHEEP = 0;
        static final int WOLF = 1;

        static int answer = 0;

        public int solution(int[] info, int[][] edges) {
            Set<Integer> nodes = new HashSet<>();
            nodes.add(0);
            recursive(info, edges, nodes, new boolean[edges.length], 1, 0);
            return answer;
        }

        void recursive(int[] info, int[][] edges, Set<Integer> nodes, boolean[] selected, int cntSheep, int cntWolf) {
            if (cntSheep <= cntWolf) {
                return;
            } else {
                answer = Math.max(answer, cntSheep);
            }

            for (int i = 0; i < edges.length; i++) {
                if (selected[i] || !nodes.contains(edges[i][0])) {
                    continue;
                }

                selected[i] = true;
                nodes.add(edges[i][1]);
                if (info[edges[i][1]] == SHEEP) {
                    recursive(info, edges, nodes, selected, cntSheep + 1, cntWolf);
                } else {
                    recursive(info, edges, nodes, selected, cntSheep, cntWolf + 1);
                }
                selected[i] = false;
                nodes.remove(edges[i][1]);
            }
        }
    }
}
