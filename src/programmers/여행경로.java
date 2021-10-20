package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 여행경로 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
    }


    static class Solution {
        public String[] solution(String[][] tickets) {
            boolean[] visited = new boolean[tickets.length];
            String[] answer = new String[tickets.length + 1];
            answer[0] = "ICN";
            dfs(answer, 1, answer[0], tickets, visited);
            return answer;
        }

        public void dfs(String[] answer, int idx, String current, String[][] tickets, boolean[] visited) {
            System.out.println(Arrays.toString(answer));
            ArrayList<Ticket> toGo = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i] && tickets[i][0].equals(current)) {
                    toGo.add(new Ticket(tickets[i][1], i));
                }
            }
            toGo.sort(Comparator.comparing(t -> t.destination));
            toGo.forEach(it -> {
                if (answer[answer.length - 1] == null) {
                    answer[idx] = it.destination;
                    visited[it.index] = true;
                    dfs(answer, idx + 1, it.destination, tickets, visited);
                    visited[it.index] = false;
                }
            });
        }

        class Ticket {
            String destination;
            int index;

            public Ticket(String destination, int index) {
                this.destination = destination;
                this.index = index;
            }
        }
    }





}
