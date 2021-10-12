import unittest
import LCA

class testLCAPython(unittest.TestCase):
    def testEmptyLcaTree(self):
        root = None
        self.assertEqual(-1,node.lowestCommonAncestor(root,4,5),'this in an empty tree therefore returns -1')

    def testOneNodeTree(self):
        root = node.Node(1)
        self.assertEqual(-1,node.lowestCommonAncestor(root,0,1),'Test Lowest common ancestor of a one node tree')
   
   
    def testMultiNodeTree(self):
        root = node.Node(1)
        root.left = node.Node(2)
        root.right = node.Node(3)
        root.left.left = node.Node(4)
        root.left.right = node.Node(5)
        root.right.left = node.Node(6)
        root.right.right = node.Node(7)
        self.assertEqual(1, node.lowestCommonAncestor(root, 1, 3))
        self.assertEqual(3, node.lowestCommonAncestor(root, 6, 7))
        self.assertEqual(1, node.lowestCommonAncestor(root, 3, 5))
    
    def testInvalidNode(self):
        root = node.Node(1)
        root.left = node.Node(2)
        root.right = node.Node(3)
        root.left.left = node.Node(4)
        root.left.right = node.Node(5)
        root.right.left = node.Node(6)
        root.right.right = node.Node(7)
        self.assertEqual(-1, node.lowestCommonAncestor(root, 666, 7))
