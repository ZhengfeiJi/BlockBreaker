package hard;

import java.util.HashMap;
import java.util.HashSet;

public class FrogJump {
	public boolean canCross(int[] stones) {
		HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
		int len = stones.length;
		for(int i = 0 ; i < len ; i++) {
			map.put(stones[i], new HashSet<Integer>());
		}

		map.get(0).add(1);
		for(int i = 0 ; i < len ; i++) {
			HashSet<Integer> steps = map.get(stones[i]);
			for(int num : steps) {
				if(num+stones[i] == stones[len-1])
					return true;
				HashSet<Integer> next = map.get(num+stones[i]);
				if(next == null)
					continue;
				next.add(num);
				next.add(num+1);
				if(num > 1)
					next.add(num-1);
			}
		}
		return false;
	}
}
