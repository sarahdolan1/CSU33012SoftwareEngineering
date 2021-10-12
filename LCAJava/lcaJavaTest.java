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
