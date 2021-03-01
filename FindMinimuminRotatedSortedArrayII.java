package hard;

public class FindMinimuminRotatedSortedArrayII {
public int findMin(int[] nums) {
	for(int i = 1 ; i < nums.length ; i++)
    {
    	if(nums[i-1] <= nums[i]) {
    		continue;
    	}else
    		return nums[i];
    }
    return nums[0];
    }
}
