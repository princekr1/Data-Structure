package GeeksForgeeks.recurrsion;

import Linklist.CircularLinkedList;
import Linklist.LinkList;

import java.util.LinkedList;
import java.util.Scanner;

/* Question : i/p : n=7, k=3
7 people is sitting in circle from 0 to 6, start with 0 and kill kth count person and hand over the gun to the person next to the killed person
again repeat same till only one person is left
 */
public class JosephProblem {

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("provide input : ");
        int n=sc.nextInt();
        int k=sc.nextInt();
        int res=findWinner(n,k);
        System.out.println("person alive : "+res);
    }

    private static int findWinner(int n, int k) {
        return 0;

    }
}
