package hard;

import java.util.LinkedList;
import java.util.List;

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> res = new LinkedList<>();
		helper(num, target, res, 0, 0, 0, new StringBuilder());
		return res;
	}

	private void helper(String num, int target, List<String> res, int start, long val, long pre,
			StringBuilder visited) {
		if (start == num.length()) {
			if (val == target)
				res.add(visited.toString());
			return;
		}

		int len = visited.length();
		for (int i = start; i < num.length(); i++) {
			String tmp = num.substring(start, i + 1);
			if(tmp.length() > 1 && tmp.charAt(0) == '0')
				break;
			long next = Long.parseLong(tmp);
			if (start == 0) {
				helper(num, target, res, i + 1, next, next, visited.append(next));
				visited.setLength(len);
			} else {
				helper(num, target, res, i + 1, val + next, next, visited.append('+').append(next));
				visited.setLength(len);
				helper(num, target, res, i + 1, val - next, -next, visited.append('-').append(next));
				visited.setLength(len);
				helper(num, target, res, i + 1, val - pre + pre * next, next * pre, visited.append('*').append(next));
				visited.setLength(len);
			}
		}
	}
}
