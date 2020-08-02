import javafx.util.Pair;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new ArrayList<String>();
        Stack<Pair<TreeNode, StringBuilder>> stack = new Stack<>();
        stack.add(new Pair<>(root, new StringBuilder()));
        List<String> ret = new ArrayList<>();

        while(stack.size() > 0) {
            Pair<TreeNode, StringBuilder> p = stack.pop();
            TreeNode node = p.getKey();
            StringBuilder sb = p.getValue();

            if (!sb.toString().equals(""))
                sb = sb.append("->");
            sb = sb.append(node.val);
            if (node.left == null && node.right == null)
                ret.add(sb.toString());
            else if (node.left == null)
                stack.add(new Pair<>(node.right, new StringBuilder(sb)));
            else if (node.right == null)
                stack.add(new Pair<>(node.left, new StringBuilder(sb)));
            else {
                stack.add(new Pair<>(node.right, new StringBuilder(sb)));
                stack.add(new Pair<>(node.left, new StringBuilder(sb)));
            }
        }
        return ret;

    }
}
