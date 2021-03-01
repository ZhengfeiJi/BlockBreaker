package hard;

import java.util.Stack;

public class LongestValidParentheses {
	
	public int longestValidParentheses(String s) {
		int res = 0;
		int startidx = -1 ;
        Stack<Integer> stack = new Stack<>();
        char[] chararr =s.toCharArray();
        int len = chararr.length;
        for(int i = 0 ; i < len ; i++)
        {
        	if(chararr[i] == '(')
        		stack.push(i);
        	else {
        		if(stack.isEmpty()) {
        			startidx = i;
        		}else {
        			stack.pop();
        			int sgmt;
        			if(stack.isEmpty())
        				sgmt = i-startidx;
        			else
        				sgmt = i - stack.peek();
        			res = res > sgmt ? res : sgmt;
        		}
        	}
        }
        return res;
    }
	
	/**
	 * dp not working for now
	 */
//	public int longestValidParentheses(String s) {
//		int len = s.length();
//		int[] dp = new int[len+1];
//		dp[0]=0;
//		for(int i = 0;i<s.length();i++)
//		{
//			if(s.charAt(i) == '(')
//				dp[i+1] = dp[i];
//			else {
//				if(i==0)
//					continue;
//				if(s.charAt(i-2*dp[i-1]-1) == '(')
//					dp[i+1] = dp[i] +1+dp[i-dp[i]-1];
//				else
//					dp[i+1] = 0;
//			}
//		}
//		int res = 0;
//		for(int i=0;i< dp.length;i++)
//		{
//			if(dp[i] > res)
//				res = dp[i]*2;
//		}
//		return res;
//    }
}
