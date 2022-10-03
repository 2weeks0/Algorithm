package programmers;

import java.util.HashSet;
import java.util.Set;

public class pg_68644_두개뽑아서_더하기 {
	class Solution {
	    public int[] solution(int[] numbers) {
	        Set<Integer> set = new HashSet<>();
	        for (int i = 0; i < numbers.length; i++) {
	            for (int j = i + 1; j < numbers.length; j++) {
	                set.add(numbers[i] + numbers[j]);
	            }
	        }
	        return set.stream().mapToInt(it -> it).sorted().toArray();
	    }
	}
}
