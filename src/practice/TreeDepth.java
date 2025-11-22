package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeDepth {

    Node node;
    int length;

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }


    public int treeDepth(Node root){
        if(root==null){
            return 0;
        }

        int leftDepth=treeDepth(root.left);
        int rightDepth=treeDepth(root.right);
        return Math.max(leftDepth, rightDepth)+1;

    }

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        TreeDepth treeDepth=new TreeDepth();
        System.out.print("Enter elements in array : ");
        int n=scanner.nextInt();
        for(int i=0;i<n;i++) {
            int data = scanner.nextInt();

            // If tree is empty
            if (treeDepth.node == null) {
                treeDepth.node = new Node(data);
            } else {

                Queue<Node> q = new LinkedList<>();
                q.add(treeDepth.node);

                while (!q.isEmpty()) {

                    // Fron a front element in queue
                    Node curr = q.poll();

                    // First check left if left is null insert
                    // node in left otherwise chaeck for right
                    if (curr.left != null)
                        q.add(curr.left);
                    else {
                        curr.left = new Node(data);
                    }

                    if (curr.right != null)
                        q.add(curr.right);
                    else {
                        curr.right = new Node(data);
                    }
                }

            }
        }

        System.out.println("Input finished.");

        System.out.println("Depth : "+treeDepth.treeDepth(treeDepth.node));

    }

    //print tree
    public void printTree(Node root){
        if(root==null){
            return;
        }
        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }
}
