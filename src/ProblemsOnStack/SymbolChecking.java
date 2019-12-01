/*%%%%%%%%%%%%%%%%%%PROBLEM DTAILS%%%%%%%%%%%%%%
 check whether a given equation has balance symbols or not 
 check open and close Delimiters
 example: [a+b(c+d)+d-{e-f}]
 ans:equation has balance symbols*/

package ProblemsOnStack;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

import Linklist.ListNode;
import Stack.LinkedStack;

public class SymbolChecking {
	private int length;
	private ListNode top;
	class ListNode{
		private String data;
		private ListNode next;
		public ListNode(){
			data=null;
			next=null;
		}
		public ListNode(String data){
			
			this.data=data;
		}
		
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public ListNode getNext() {
			return next;
		}
		public void setNext(ListNode next) {
			this.next = next;
		}
		
		
	}
	//Constructor: creates an empty stack
		public SymbolChecking(){
			top=null;
			length=0;
		}
		public int length() {
			return length;
		}
		//Adds the specified data to the head
		public void push(String data) {
			ListNode temp=new ListNode(data);
			temp.setNext(top);
			top=temp;
			length++;
		}
		
		//Remove the data at the top of this stack and returns a
		//reference to it. Throws an EmptyStackException if the stack is empty
		public String pop() throws EmptyStackException {
			if(isEmpty()) {
				throw new EmptyStackException();
			}
			else {
				String result=top.getData();
				top=top.getNext();
				length--;
				return result;
			}
		}
		//Returns a reference to the data at the top of this stack
		//throw an EmptyStackException if the stack is empty
		public String peek() throws EmptyStackException{
			if(isEmpty()) {
				throw new EmptyStackException();
			}
			return top.getData();
		}
		public boolean isEmpty() {
			return (length==0);
		}
		
		//return a string representation of the collection in the from of ["str1","str2",...]
			public String toString(ListNode l) {
				String result="[";
				if(l==null) {
					return result+"]";
				}
				else {
					result=result+l.getData();
					ListNode curr=l.getNext();
					while(curr!=null) {
						result=result+","+curr.getData();
						curr=curr.getNext();
					}
				}
				return result+"]";
				
			}
			
			//checking symbols
			public void symbolChecking(String str) {
				SymbolChecking syc=new SymbolChecking();
				for(int i=str.length()-1;i>=0;i--) {
					System.out.println("inside for loop:"+str.charAt(i));
					if(str.charAt(i)=='(') {
						System.out.println("inside for loop1:"+str.charAt(i));
						if(!syc.isEmpty()&& syc.peek().equals(")")) {
							syc.pop();
						}
						else {
							break;				}
					}
					if(str.charAt(i)=='{') {
						if(!syc.isEmpty()&& syc.peek().equals("}")) {
							syc.pop();
						}
						else {
							break;
						}
					}
					if(str.charAt(i)=='[') {
						if(!syc.isEmpty()&& syc.peek().equals("]")) {
							syc.pop();
						}
						else {
							break;
						}
					}
					else {
						if(str.charAt(i)==')'||str.charAt(i)=='}'||str.charAt(i)==']') {
							syc.push(str.charAt(i)+"");
						}
						
					}
					System.out.println(syc.toString(syc.top));
				}
				System.out.println(syc.toString(syc.top));
				if(syc.isEmpty()) {
					System.out.println("symbols are matched");
				}
				else {
					System.out.println("symbols are not matched");
				}
				
			}
			public void prefix(String str) {
				SymbolChecking syc=new SymbolChecking();
				String s="";
				for(int i=0;i<str.length();i++) {
					if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/') {
						s=s+str.charAt(i);
					}
					else if(str.charAt(i)==')') {
						while(true) {
							
							if(syc.pop().equals("(")) {
								break;
							}
							s=s+syc.pop();
						}
						
					}
					else {
						System.out.println("inside else:");
						//syc.push(str.charAt(i)+"");
						//System.out.println("inside else:"+syc.peek());
						while(true) {
							if(syc.isEmpty()) {
								break;
							}
							s=s+syc.pop();
							syc.push(str.charAt(i)+"");
						}
					}
				}
				System.out.println("postfix:"+s);
			}
	
	public static void main(String args[]) throws Exception {
		String str;
		System.out.println("enter equation");
		Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		SymbolChecking sbc=new SymbolChecking();
		//sbc.symbolChecking(str);
		sbc.prefix(str);
	}

	

}
