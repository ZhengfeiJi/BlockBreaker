package hard;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	/**
	 * recursive way
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ans = new LinkedList<Integer>();
		helper(ans,root);
		return ans;
	}

	private void helper(List<Integer> ans, TreeNode node) {
		// TODO Auto-generated method stub
		if(node == null)
			return;
		helper(ans,node.left);
		helper(ans,node.right);
		ans.add(node.val);
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
