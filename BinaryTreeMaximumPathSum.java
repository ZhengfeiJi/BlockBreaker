package hard;

public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		helper(root);
		return max;
	}
	
	private int helper(TreeNode node)
	{
		if(node == null)
			return 0;
		int left = Math.max(0, helper(node.left));
		int right = Math.max(0, helper(node.right));
		max = Math.max(left+right+node.val, max);
		return Math.max(left,right) + node.val;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
