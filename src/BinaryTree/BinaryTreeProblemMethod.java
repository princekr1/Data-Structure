package BinaryTree;

public interface BinaryTreeProblemMethod {
	//Maximum Element in Binary Tree
	public int maxInBinaryTreeUsingRecurrsion(BinaryTreeNode root);
	public int maxInBinaryTreeUsingIteration(BinaryTreeNode root);
	
	//searching an element in binary tree
	public boolean searchElementUsingRecurrsion(BinaryTreeNode root, int n);
	public boolean searchElementUsingIteration(BinaryTreeNode root, int n);
	
	//insert an element in Binary tree
	public BinaryTreeNode insertInTreeIteration(BinaryTreeNode root, int data);
	
	//size of binary tree
	public int sizeRecurrsion(BinaryTreeNode root);
	public int sizeIteration(BinaryTreeNode root);
	
	//Delete BinaryTree
	public void deleteBinaryTree(BinaryTreeNode root);
	
	//reverse level order traversal
	public void reverseLevelOrder(BinaryTreeNode root);
	
	//Find the height or depth of binary Tree
	public int maxDepthRecursive(BinaryTreeNode root);
	public int maxDepthIterative(BinaryTreeNode root);
	
	//Find the minimum depth of the binary tree
	public int minDepthRecursive(BinaryTreeNode root);
	public int minDepthIterative(BinaryTreeNode root);
	
	//Find the diameter of tree
	public int diameterTree(BinaryTreeNode root);
	
	//printout all it's root to leaf path
	public void printPaths(BinaryTreeNode root);
	
	//find mirror of binary Tree
	public BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root);
	//find all ancestors
	public boolean printAllAncestors(BinaryTreeNode root, BinaryTreeNode node);
	String printPaths(BinaryTreeNode root, BinaryTreeNode child, BinaryTreeNode parent);
	
	
	
	
	
	
	
}
