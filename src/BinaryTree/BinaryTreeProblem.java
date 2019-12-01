/*Problems on Binary tree*/
package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeProblem implements BinaryTreeProblemMethod {
	

	//Finding maximum element in Binary tree

	@Override
	public int maxInBinaryTreeUsingRecurrsion(BinaryTreeNode root) {
		if(root!=null) {
			int leftmax=maxInBinaryTreeUsingRecurrsion(root.left);
			int rightmax=maxInBinaryTreeUsingRecurrsion(root.right);
			System.out.println("leftmax: "+leftmax+"\trightmax: "+rightmax);
			return (((leftmax>rightmax)?leftmax:rightmax)>root.data)?((leftmax>rightmax)?leftmax:rightmax):root.data;
		}
		return 0;
	}

	@Override
	public int maxInBinaryTreeUsingIteration(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		int max=Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			BinaryTreeNode temp=q.poll();
			if(temp.data>max) {
				max=temp.data;
				System.out.println("temp data :"+temp.data+"\tmax :"+max);
			}
			if(temp.left!=null) {
				q.offer(temp.left);
			}
			if(temp.right!=null) {
				q.offer(temp.right);
			}
		}
		return max;
	}
	
	@Override
	public boolean searchElementUsingRecurrsion(BinaryTreeNode root,int data) {
		if(root==null) {
			return false;
		}
		if(root.data==data) {
			return true;
		}
		return (searchElementUsingRecurrsion(root.left,data)||searchElementUsingRecurrsion(root.right,data));
	}

	@Override
	public boolean searchElementUsingIteration(BinaryTreeNode root,int data) {
		Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
		s.push(root);
		while(!s.isEmpty()) {
			BinaryTreeNode temp=s.pop();
			if(temp.data==data) {
				return true;
			}
			if(temp.left!=null) {
				s.push(temp.left);
			}
			if(temp.right!=null) {
				s.push(temp.right);
			}
			
		}
		return false;
	}
	@Override
	public BinaryTreeNode insertInTreeIteration(BinaryTreeNode root, int data) {
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			BinaryTreeNode temp=q.poll();
			if(temp.left!=null) {
				q.offer(temp.left);
			}
			else {
				temp.left=new BinaryTreeNode(data);
				return root;
			}
			if(temp.right!=null) {
				q.offer(temp.right);
			}
			else {
				temp.right=new BinaryTreeNode(data);
				return root;
			}
		}
		return root;
		
	}
	//Size of tree
	@Override
	public int sizeRecurrsion(BinaryTreeNode root) {
		if(root==null) {
			return 0;
		}
		int left=sizeRecurrsion(root.left);
		int right=sizeRecurrsion(root.right);
		return 1+left+right;
		
	}
	
	@Override
	public int sizeIteration(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return 0;
		}
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		int count=0;
		while(!q.isEmpty()) {
			BinaryTreeNode temp=q.poll();
			count++;
			if(temp.left!=null) {
				q.offer(temp.left);
			}
			if(temp.right!=null) {
				q.offer(temp.right);
			}
			
		}
		return count;
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
		System.out.println("LevelOrder traversal:");
		bt.levelOrder(bt.root);
		System.out.println("\nMaximum element in Tree : "
				+ ""+new BinaryTreeProblem().maxInBinaryTreeUsingRecurrsion(bt.root)+"\n");
		System.out.println("\nMaximum element in Tree : "
				+ ""+new BinaryTreeProblem().maxInBinaryTreeUsingIteration(bt.root)+"\n");
		System.out.println("\nelement in Tree : "
				+ ""+new BinaryTreeProblem().searchElementUsingRecurrsion(bt.root,2)+"\n");
		System.out.println("\nelement in Tree : "
				+ ""+new BinaryTreeProblem().searchElementUsingRecurrsion(bt.root,7)+"\n");
		System.out.println("\nelement in Tree : "
				+ ""+new BinaryTreeProblem().searchElementUsingIteration(bt.root,6)+"\n");
		System.out.println("\nelement in Tree : "
				+ ""+new BinaryTreeProblem().searchElementUsingIteration(bt.root,7)+"\n");
		bt.root=bt.insertInBinaryTreeLevel(bt.root, 7);
		System.out.println("LevelOrder traversal:");
		bt.levelOrder(bt.root);
		Btree bt1=new Btree();
		bt1.root=bt1.insertInBinaryTreeLevel(bt1.root, 1);
		bt1.root=bt1.insertInBinaryTreeLevel(bt1.root, 2);
		bt1.root=bt1.insertInBinaryTreeLevel(bt1.root, 3);
		bt1.root=bt1.insertInBinaryTreeLevel(bt1.root, 4);
		bt1.root=bt1.insertInBinaryTreeLevel(bt1.root, 5);
		System.out.println("\nSize of  Tree : "
				+ ""+new BinaryTreeProblem().sizeRecurrsion(bt1.root)+"\n");
		System.out.println("\nSize of  Tree(Iteration) : "
				+ ""+new BinaryTreeProblem().sizeIteration(bt.root)+"\n");
		new BinaryTreeProblem().reverseLevelOrder(bt.root);
		System.out.println("\nSize of  Tree(Iteration) : "
				+ ""+new BinaryTreeProblem().maxDepthRecursive(bt.root)+"\n");
		System.out.println("\nSize of  Tree(Iteration) : "
				+ ""+new BinaryTreeProblem().maxDepthIterative(bt.root)+"\n");
		System.out.println("\nMin Size of  Tree(Iteration) : "
				+ ""+new BinaryTreeProblem().minDepthRecursive(bt1.root)+"\n");
		System.out.println("\n Min Size of  Tree(Iteration) : "
				+ ""+new BinaryTreeProblem().minDepthIterative(bt1.root)+"\n");
		System.out.println("\n Diameter of  Tree(Iteration) : "
				+ ""+new BinaryTreeProblem().diameterTree(bt.root)+"\n");
		//System.out.println("level order");
		//bt.levelOrder(new BinaryTreeProblem().mirrorOfBinaryTree(bt.root));
		new BinaryTreeProblem().printAllAncestors(bt.root,bt.root.left.right);
	}

	@Override
	public void deleteBinaryTree(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		root=null; //taken care by garbage collector
		
	}

	@Override
	public void reverseLevelOrder(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> stk=new Stack<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			BinaryTreeNode temp=q.poll();
			
			if(temp.right!=null) {
				q.offer(temp.right);
			}
			if(temp.left!=null) {
				q.offer(temp.left);
			}
			stk.push(temp);
			
		}
		while(!stk.isEmpty()) {
			System.out.print(stk.pop().data+" ");
		}
		System.out.println();
	}

	@Override
	public int maxDepthRecursive(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return 0;
		}
		//compute depth of each subtree
		int leftDepth=maxDepthRecursive(root.left);
		int rightDepth=maxDepthRecursive(root.right);
		return (leftDepth>rightDepth)?1+leftDepth:1+rightDepth;
	}

	@Override
	public int maxDepthIterative(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		int height=0,count=0;
		while(1==1) {
			count=q.size();
			if(count==0) {
				return height;
			}
			else {
				height++;
			}
			while(count>0) {
				BinaryTreeNode temp=q.poll();
				if(temp.left!=null) {
					q.offer(temp.left);
				}
				if(temp.right!=null) {
					q.offer(temp.right);
				}
				count--;
			}
		}
		
	}

	@Override
	public int minDepthRecursive(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return 0;
		}
		int leftmin=minDepthRecursive(root.left);
		int rightmin=minDepthRecursive(root.right);
		return (leftmin<rightmin)?1+leftmin:1+rightmin;
	}

	@Override
	public int minDepthIterative(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return 0;
		}
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		int count=0,minHeight=0,prevcount=count;
		q.offer(root);
		while(1==1) {
			count=q.size();
			if(count<prevcount*2) {
				return minHeight;
			}
			else {
				prevcount=count;
			}
			if(count==0) {
				return minHeight;
			}
			
			else {
				minHeight++;
			}
			while(count>0) {
				BinaryTreeNode temp=q.poll();
				if(temp.left!=null) {
					q.offer(temp.left);
				}
				if(temp.right!=null) {
					q.offer(temp.right);
				}
				count--;
			}
		}
	}

	@Override
	public int diameterTree(BinaryTreeNode root) {
		if(root==null) {
			return 0;
		}
		// TODO Auto-generated method stub
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		int count=0,level=0;
		while(1==1) {
			count=q.size();
			if(count==0) {
				return level;
			}
			else {
				if(count>level) {
					level=count;
				}
			}
			while(count>0) {
				BinaryTreeNode temp=q.poll();
				if(temp.left!=null) {
					q.offer(temp.left);
				}
				if(temp.right!=null) {
					q.offer(temp.right);
				}
				count--;
			}
			
		}
	}
	

	@Override
	public BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root) {
		BinaryTreeNode temp;
		if(root!=null) {
			mirrorOfBinaryTree(root.left);
			mirrorOfBinaryTree(root.right);
			//Swap the Pointer in this node
			temp=root.left;
			root.left=root.right;
			root.right=temp;
		}
		return root;
	}

	@Override
	public void printPaths(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String printPaths(BinaryTreeNode root, BinaryTreeNode child, BinaryTreeNode parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean printAllAncestors(BinaryTreeNode root, BinaryTreeNode node) {
		// TODO Auto-generated method stub
		if(root==null) {
			return false;
		}
		if(root.left==node||root.right==node||printAllAncestors(root.left,node)||printAllAncestors(root.right,node)) {
			System.out.print(root.data+" ");
			return true;
		}
		return false;
	}
}
