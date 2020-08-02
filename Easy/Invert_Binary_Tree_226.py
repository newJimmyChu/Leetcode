# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def invertTree(self, root):
        if root is None:
            return None
        t = copy.copy(root.left)
        root.left = invertTree(root.right)
        root.right = invertTree(t)
        return root
