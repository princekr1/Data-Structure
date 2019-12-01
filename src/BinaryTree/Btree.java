package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Btree {
	BinaryTreeNode root;
	Btree(){
		root=null;
	}
	//insert an element level order traversal
	public BinaryTreeNode insertInBinaryTreeLevel(BinaryTreeNode root,int data) {
		BinaryTreeNode curr=root;
		BinaryTreeNode newNode=new BinaryTreeNode(data);
		if(root==null) {
			root=newNode;
			return root;
		}
		else {
			Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
			q.offer(root);
			while(!q.isEmpty()) {
				BinaryTreeNode tmp=q.poll();
				if(tmp!=null) {
					if(tmp.left!=null) {
						q.offer(tmp.left);
					}
					else {
						tmp.left=newNode;
						return root;
					}
				}
				if(tmp.right!=null) {
					q.offer(tmp.right);
				}
				else {
					tmp.right=newNode;
					return root;
				}
			}
		}
		return root;
		
	}
	public void preOrder(BinaryTreeNode root) {
		if(root!=null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			
			preOrder(root.right);
		}
	}
	public void inOrder(BinaryTreeNode root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	public void postOrder(BinaryTreeNode root) {
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
		}
	}
	public void levelOrder(BinaryTreeNode root) {
		
			Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
			q.offer(root);
			while(!q.isEmpty()) {
				BinaryTreeNode tmp=q.poll();
				System.out.print(tmp.data+" ");
				if(tmp!=null) {
					if(tmp.left!=null) {
						q.offer(tmp.left);
					}
				}
				if(tmp.right!=null) {
					q.offer(tmp.right);
				}
			}
		
	}
	public void levelOrderAvg(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		int sum=0,count=0;
		while(!q.isEmpty()) {
			Queue<BinaryTreeNode> qtemp=new LinkedList<BinaryTreeNode>();
			sum=0;
			count=0;
			while(!q.isEmpty()) {
			
				BinaryTreeNode tmp=q.poll();
				sum=sum+tmp.data;
				count++;
				if(tmp!=null) {
					if(tmp.left!=null) {
						qtemp.offer(tmp.left);
					}
				}
				if(tmp.right!=null) {
					qtemp.offer(tmp.right);
				}
			}
			q=qtemp;
			System.out.println("Sum: "+sum+"\tCount:"+count);
		}
	
	}
	public void leafNode(BinaryTreeNode root) {
		if(root.left==null && root.right==null) {
			System.out.print(root.data+" ");
		}
		else {
			if(root.right==null && root.left!=null) {
				leafNode(root.left);
			}
			if(root.right!=null && root.left==null) {
				leafNode(root.right);
			}
			if(root.right!=null && root.left!=null) {
				leafNode(root.left);
				leafNode(root.right);
			}
			
		}
		
	}
	//iteration pre order traversal
	public void preOrderIteration(BinaryTreeNode root) {
		if(root==null) {
			return;
		}
		
		Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
		s.push(root);
		while(!s.isEmpty()) {
			BinaryTreeNode temp=s.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null) {
				s.push(temp.right);
			}
			if(temp.left!=null) {
				s.push(temp.left);
			}
		}
	}
	//iteration In order traversal
	public void inOrderIteration(BinaryTreeNode root) {
			
			
			Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
			BinaryTreeNode current=root;
			Boolean done=false;
			while(!done) {
				if(current!=null) {
					s.push(current);
					current=current.left;
				}
				else {
					if(s.isEmpty()) {
						done=true;
					}
					else {
						current=s.pop();
						System.out.print(current.data+" ");
						current=current.right;
					}
				}
			}
		}
	//iteration pre order traversal
	public void postOrderIteration(BinaryTreeNode root) {
			if(root==null) {
				return;
			}
			
			Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
			Stack<BinaryTreeNode> stemp=new Stack<BinaryTreeNode>();
			s.push(root);
			while(!s.isEmpty()) {
				
				BinaryTreeNode temp=s.pop();
				stemp.push(temp);
				//System.out.print(temp.data+" ");
				if(temp.left!=null) {
					s.push(temp.left);
				}
				if(temp.right!=null) {
					s.push(temp.right);
				}
			}
			while(!stemp.isEmpty()) {
				System.out.print(stemp.pop().data+" ");
			}
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Btree bt=new Btree();
		bt.root=bt.insertInBinaryTreeLevel(bt.root, 1);
		bt.root=bt.insertInBinaryTreeLevel(bt.root, 2);
		bt.root=bt.insertInBinaryTreeLevel(bt.root, 3);
		bt.root=bt.insertInBinaryTreeLevel(bt.root, 4);
		bt.root=bt.insertInBinaryTreeLevel(bt.root, 5);
		bt.root=bt.insertInBinaryTreeLevel(bt.root, 6);
		System.out.println("PreOrder traversal:");
		bt.preOrder(bt.root);
		System.out.println("\nInOrder traversal:");
		bt.inOrder(bt.root);
		System.out.println("\nPostOrder traversal:");
		bt.postOrder(bt.root);
		System.out.println("\nLevelOrder traversal:");
		bt.levelOrder(bt.root);
		System.out.println("\nlevel order avg:");
		bt.levelOrderAvg(bt.root);
		System.out.println("\nLeaf node:");
		bt.leafNode(bt.root);
		System.out.println("\nPreOrder traversal iteration :");
		bt.preOrderIteration(bt.root);
		System.out.println("\nInOrder traversal iteration :");
		bt.inOrderIteration(bt.root);
		System.out.println("\nPostOrder traversal iteration :");
		bt.postOrderIteration(bt.root);
		
	}

}
