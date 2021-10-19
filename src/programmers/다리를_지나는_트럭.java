package programmers;

import java.util.LinkedList;

public class 다리를_지나는_트럭 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(20, 10000, new int[]{1,1,1,1,1,1,1,1,1}));
    }

    static class Solution {
        final LinkedList<Integer> truckQueue = new LinkedList<>();
        final LinkedList<Integer> onBridgeQueue = new LinkedList<>();

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            init(bridge_length, truck_weights);
            return solve(weight);
        }

        public void init(int bridge_length, int[] truck_weights) {
            for (int truck : truck_weights) {
                truckQueue.addLast(truck);
            }
            for (int i = 0; i < bridge_length; i++) {
                onBridgeQueue.addLast(0);
            }
        }

        public int solve(int weight) {
            int result = 0;
            int sum = 0;
            while (!truckQueue.isEmpty() || sum != 0) {
                if (truckQueue.isEmpty()) {
                    sum -= onBridgeQueue.pollFirst();
                    onBridgeQueue.addLast(0);
                    result++;
                } else if (sum + truckQueue.peekFirst() > weight) {
                    sum -= onBridgeQueue.pollFirst();
                    if (sum + truckQueue.peekFirst() <= weight) {
                        int truck = truckQueue.pollFirst();
                        onBridgeQueue.addLast(truck);
                        sum += truck;
                    } else {
                        onBridgeQueue.addLast(0);
                    }
                    result++;
                } else {
                    int truck = truckQueue.pollFirst();
                    sum -= onBridgeQueue.pollFirst();
                    onBridgeQueue.addLast(truck);
                    sum += truck;
                    result++;
                }

                System.out.printf("%d: ", result);
                onBridgeQueue.forEach(it -> System.out.printf("%d ", it));
                System.out.println();
            }
            return result;
        }
    }
}
