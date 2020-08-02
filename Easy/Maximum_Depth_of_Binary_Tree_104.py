# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxDepth(self, root):
        return maxHelper(root, 0)

def maxHelper(node, level):
    if node is None:
        return level
    return max(maxHelper(node.left, level + 1), maxHelper(node.right, level + 1))

