'''
# Tree Node
class Node:
    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None
'''
class Solution:
    values=[]
    def inorderTraversal(self, root):
        if root is None:
            return
        self.inorderTraversal(root.left)
        self.values.append(root.data)
        self.inorderTraversal(root.right)
    
    def convertToBST(self, root):
        if root is None:
            return    
        self.convertToBST(root.left)
        root.data = self.values.pop()
        self.convertToBST(root.right)
    def binaryTreeToBST(self, root):
        self.inorderTraversal(root)
        self.values.sort(reverse=True)
        self.convertToBST(root)