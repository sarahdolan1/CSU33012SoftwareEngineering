//Code from https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/ 


import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	Node left, right;

	Node(int value) {
		data = value;
		left = right = null;
	}
}

public class LCA {

	Node root;
	List<Integer> nodeOnePath = new ArrayList<>();
	List<Integer> nodeTwoPath = new ArrayList<>();

	int functionLCA(int nodeOne, int nodeTwo) {
		nodeOnePath.clear();
		nodeTwoPath.clear();
		return functionLCA(root, nodeOne, nodeTwo);
	}

	private int functionLCA(Node root, int nodeOne, int nodeTwo) {
		if (!findPath(root, nodeOne, nodeOnePath) || !findPath(root, nodeTwo, nodeTwoPath)) {
			if(nodeOnePath.size() == 0 && nodeTwoPath.size() == 0) {
				if(!nodeOnePath.contains(nodeOne) && !nodeTwoPath.contains(nodeTwo)) {
					System.out.println("These nodes do not exist in the tree.");
				} else {
					System.out.println("The tree is empty.");
				}
			}
			if (nodeOnePath.size() > 0 && nodeTwoPath.size() == 0) {
				System.out.println("Node 1 is present but Node 2 is not present in the tree.");
			}
			if (nodeTwoPath.size() > 0 && nodeOnePath.size() == 0) {
				System.out.println("Node 2 is present but Node 1 is not present in the tree.");
			}
			return -1;
		}
		int index;
		for (index = 0; index < nodeOnePath.size() && index < nodeTwoPath.size(); index++) {
			if (!nodeOnePath.get(index).equals(nodeTwoPath.get(index))) {
				break;
			}
		}
		return nodeOnePath.get(index - 1);
	}

	private boolean findPath(Node root, int num, List<Integer> path) {
		if (root == null) {
			return false;	
		} else {
			path.add(root.data);
			if (root.data == num) {
				return true;
			}
			if (root.left != null && findPath(root.left, num, path)) {
				return true;
			}
			if (root.right != null && findPath(root.right, num, path)) {
				return true;
			}
			path.remove(path.size() - 1);
			return false;
		}
	}
}