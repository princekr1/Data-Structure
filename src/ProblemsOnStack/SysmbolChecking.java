/*%%%%%%%%%%%%%%%%%%PROBLEM DTAILS%%%%%%%%%%%%%%
 check whether a given equation has balance symbols or not 
 check open and close Delimiters
 example: [a+b(c+d)+d-{e-f}]
 ans:equation has balance symbols*/

package ProblemsOnStack;

import java.util.Scanner;

import Linklist.ListNode;
import Stack.LinkedStack;

public class SysmbolChecking {
	//Length of array used to implement stack
		protected int capacity;
		//default array capacity
		public static final int CAPACITY=20;
		//Array Used to Implement the stack
		protected String []stackrep;
		//index of top element of the stack in the array
		protected int top=-1;
		//initializing the stack to use this capacity
		public SysmbolChecking(){
			this(CAPACITY);
		}
		
		//intialize the stack to use an array of given length
		public SysmbolChecking(int cap){
			capacity=cap;
			stackrep=new String[capacity];
		}
		//return the top element inpex
		public int getSize() {
			return (top+1);
		}
		//check stack is empty takes O(1) time to run
		public boolean isEmpty() {
			return (top<0);
		}
		//check stack is full
		public boolean isFull() {
			return (top>capacity-1);
		}
		//insert an element at the top
		public void  push(String data) throws Exception {
			if(getSize()==capacity) {
				throw new Exception("Stack is Full");
			}
			else {
				stackrep[++top]=data;
			}
		}
		//get the top element of stack
		public String top() throws Exception{
			if(isEmpty()) {
				throw new Exception("Stack is Empty");
			}
			return stackrep[top];
		}
		//take an element out from the top
		public String pop() throws Exception {
			String data;
			if(isEmpty()) {
				throw new Exception("Stack is Empty");
			}
			else {
				data=stackrep[top];
				stackrep[top--]=null;
				return data;
			}
		}
		
		//return a string representation of stack
		public String toString() {
			String s;
			s="[";
			if(getSize()>0) {
				s+=stackrep[0];
			}
			if(getSize()>1) {
				for(int i=1;i<=top;i++) {
				s+=","+stackrep[i];
				}
			}
			return s+"]";
		}
	public static void main(String args[]) throws Exception {
		String str;
		System.out.println("enter equation");
		Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		SysmbolChecking syc=new SysmbolChecking();
		
		for(int i=0;i<str.length();i++) {
			
			String popstr=str.substring(i, i+1);
			//System.out.println(popstr);
			if(popstr.equals("(")||popstr.equals(")")||popstr.equals("{")||popstr.equals("}")||popstr.equals("[")||popstr.equals("]")) {
				//System.out.println(popstr);
				syc.push(popstr);
			}
			
			
		}
		System.out.println(syc.toString());
		SysmbolChecking syc1=new SysmbolChecking();
		int len=syc.top;
		for(int i=0;i<len+1;i++) {
			String pop=syc.top();
			if(pop.equals(")")||pop.equals("}")||pop.equals("]")) {
				//System.out.println(pop);
				syc1.push(syc.pop());
			}
			else {
				if(!syc1.isEmpty()) {
					String s1=syc.top();
					String s2=syc1.top();
					System.out.println("inside else:\ts1:"+s1+"\ts2"+s2);
					
					if(s1.equals("(") && s2.equals(")")){
						syc1.pop();
						syc.pop();
					}
					if(s1.equals("{") && s2.equals("}")){
						syc1.pop();
						syc.pop();
					}
					if(s1.equals("[") && s2.equals("]")){
						syc1.pop();
						syc.pop();
					}
				}
				
			}
			
		}
		System.out.println(syc.toString());
		System.out.println(syc1.toString());
		if(syc.isEmpty() && syc1.isEmpty()) {
			System.out.println("Sysmbol are matched");
		}
		else {
			System.out.println("symbols are not matched");
		}
		
	}

	

}
