# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def diameterOfBinaryTree(self, root):
        v = [0]
        helper(root, max_val=v)
        return v[0]

def helper(node, max_val):
    if node is None:
        return 0
    left = helper(node.left, max_val)
    right = helper(node.right, max_val)
    max_val[0] = max(max_val[0], left + right)
    return max(right, left) + 1
