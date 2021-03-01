package hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		preorder(root,sb,' ','n');
		return sb.toString();
	}
	
	private void preorder(TreeNode root, StringBuilder sb, char sign, char n) {
		if(root == null) {
			sb.append(n).append(sign);
			return;
		}
		
		sb.append(root.val);
		sb.append(sign);
		preorder(root.left,sb,sign,n);
		preorder(root.right,sb,sign,n);
	}

	public TreeNode deserialize(String data) {
		Queue<String> nodes = new LinkedList<>();
		String[] nodesString = data.split(" ");
		nodes.addAll(Arrays.asList(nodesString));;
		return build(nodes);
	}

	private TreeNode build(Queue<String> nodes) {
		String node = nodes.poll();
		if(node.equals("n"))
			return null;
		else {
			TreeNode current =new TreeNode(Integer.valueOf(node));
			current.left = build(nodes);
			current.right = build(nodes);
			return current;
		}
	}
	//in order trversal practice...
//	public String serialize(TreeNode root) {
//		StringBuilder sb = new StringBuilder();
//		TreeNode p = root;
//		Stack<TreeNode> tree = new Stack<>();
//		tree.push(p);
//		p = p.left;
//		while (!tree.isEmpty()) {
//			while (p != null) {
//				tree.push(p);
//				p = p.left;
//			}
//			
//			sb.append('n');
//			p = tree.pop();
//			sb.append(p.val);
//			p = p.right;
//		}
//		return sb.toString();
//	}


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
