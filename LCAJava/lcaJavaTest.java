import static org.junit.Assert.*;

import org.junit.Test;

public class lcaJavaTest {

	@Test
	public void testEmptyLcaTree() {
		LCA tree = new LCA();
		assertEquals("Test Lowest common ancestor of an empty tree",-1,tree.functionLCA(0,0));
	}
	
	@Test
	public void testOneNodeLcaTree()
	{
		LCA tree = new LCA();
		tree.root = new Node(1);
		assertEquals("Test Lowest common ancestor of a one node tree",-1,tree.functionLCA(1,0));
	}
	
	@Test 
	public void testMultiNodeTree() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);
		tree.root.right.left.left = new Node(12);

		assertEquals("Test Lowest common ancestor of a 1 and 10",1,tree.functionLCA(1,10));
		assertEquals("Test Lowest common ancestor of a 9 and 5",2,tree.functionLCA(9,5));
		assertEquals("Test Lowest common ancestor of a 3 and 7",3,tree.functionLCA(3,7));
		assertEquals("Test Lowest common ancestor of a 8 and 4",4,tree.functionLCA(8,4));

	}
	@Test 
	public void testDag() {
		/*				1--------
		 * 			   /  \	     |
		 *            2     3    |
		 *            \    /     |
		 *               4       |
		 *              / \      | 
		 *             5   6     |
		 *             		\   /
		 *               	  7
		 */
		
		LCA graph = new LCA();
		Node root= new Node(1);
		Node nodeTwo= new Node(2);
		Node nodeThree = new Node(3);
		Node nodeFour = new Node(4);
		Node nodeFive= new Node(5);
		Node nodeSix = new Node(6);
		Node nodeSeven = new Node(7);
		
		
		graph.add2Graph(root);
		graph.add2Graph(nodeTwo);
		graph.add2Graph(nodeThree);
		graph.add2Graph(nodeFour);
		graph.add2Graph(nodeFive);
		graph.add2Graph(nodeSix);
		graph.add2Graph(nodeSeven);

		
		graph.addAncestors(root, nodeTwo);
		graph.addAncestors(root, nodeThree);
		graph.addAncestors(nodeTwo, nodeFour);
		graph.addAncestors(nodeThree, nodeFour);
		graph.addAncestors(nodeFour, nodeFive);
		graph.addAncestors(nodeFour, nodeSix);
		graph.addAncestors(nodeSix, nodeSeven);
		graph.addAncestors(root, nodeSeven);


		assertEquals(1, graph.functionLCADAG2(root, nodeTwo, nodeThree ));
		assertEquals(1, graph.functionLCADAG2(root, root, root ));
		assertEquals(4, graph.functionLCADAG2(root, nodeFive, nodeSix ));
		assertEquals(3, graph.functionLCADAG2(root, nodeFour, nodeThree ));
		assertEquals(1, graph.functionLCADAG2(root, root, nodeSeven ));





	}
	@Test
	public void EmptyDAG() {
		LCA graph = new LCA();
		assertEquals("Test Lowest common ancestor of an empty tree",-1,graph.functionLCA(0,0));
	}
	public void oneNodeDAG() {
		LCA graph = new LCA();
		Node root= new Node(1);
		graph.add2Graph(root);
		assertEquals(1, graph.functionLCADAG2(root, root, root ));
		
	}
	
	@Test
	public void testmissingLcaNode() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);
		tree.root.right.left.left = new Node(12);
		assertEquals("Test Lowest Common Ancestor of 1 and 8383838",-1,tree.functionLCA(1,8383838));
		
	}
	@Test 
	public void testEventree() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		
		assertEquals("Test Lowest Common Ancestor of 1 and 2",1,tree.functionLCA(1,2));
		assertEquals("Test Lowest Common Ancestor of 3 and 4",1,tree.functionLCA(3,4));


	}
	@Test 
	public void testUnEventree() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		
		assertEquals("Test Lowest Common Ancestor of 1 and 2",1,tree.functionLCA(1,2));
		assertEquals("Test Lowest Common Ancestor of 3 and 1",1,tree.functionLCA(3,1));


	}
	@Test 
	public void testLookingForSameNode() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		
		assertEquals("Test Lowest Common Ancestor of 4 and 4",4,tree.functionLCA(4,4));


	}
}
