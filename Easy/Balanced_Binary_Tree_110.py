# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        t = helper(root, 0)
        if t == -1:
            return False
        return True


def helper(node, level):
    if node is None:
        return level
    l = helper(node.left, level + 1)
    r = helper(node.right, level + 1)
    if l == -1 or r == -1:
        return -1
    if abs(l - r) > 1:
        return -1
    return max(l, r)
