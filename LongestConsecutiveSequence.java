package hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	/**
	 * sorting O(nlogn)
	 * @param nums
	 * @return
	 */
//	public int longestConsecutive(int[] nums) {
//		if(nums.length < 2)
//			return nums.length;
//        Arrays.sort(nums);
//        int max = 1;
//        int cur = 1;
//        for(int i = 1 ; i<nums.length;i++)
//        {
//            if(nums[i] == nums[i-1])
//                continue;
//        	if(nums[i]-nums[i-1]==1)
//        	{
//        		cur++;
//        		max = max > cur ? max : cur;
//        	}else
//        		cur = 1;
//        }
//        return max;
//    }
	
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int max = 0;
		int cur = 0;
		
		for(int num : nums)
			set.add(num);
		for(int i = 0 ;i <nums.length ;i++) {
			if(set.contains(nums[i]-1))
				continue;
			else {
				int temp = nums[i];
				while(set.contains(temp))
				{
					cur++;
					temp++;
				}
				max = max > cur ? max : cur;
				cur = 0;
			}
		}
		return max;
    }
}
