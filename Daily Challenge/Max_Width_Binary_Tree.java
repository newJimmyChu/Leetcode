/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) 
        	return 0;
        if (root.left == null && root.right == null)
        	return 1;

        int ret = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        
        int level = 0, maximum = Integer.MIN_VALUE, minimum = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {

        	int queueSize = queue.size();
        	for (int i = 0; i < queueSize; i ++) {
        		Pair<TreeNode, Integer> cur = queue.poll();
        		TreeNode node = cur.getKey();
        		int val = cur.getValue();
        		if (node.left != null)
        			queue.offer(new Pair(node.left, 2 * val));
        		if (node.right != null)
        			queue.offer(new Pair(node.right, 2 * val + 1));
        		
        		maximum = Math.max(maximum, val);
        		minimum = Math.min(minimum, val);
        		
        	}
        	//System.out.println(maximum);
        	//System.out.println(minimum);
        	ret = Math.max(ret, maximum - minimum + 1);

        	maximum = Integer.MIN_VALUE;
        	minimum = Integer.MAX_VALUE;
        }
        return ret;

    }

}