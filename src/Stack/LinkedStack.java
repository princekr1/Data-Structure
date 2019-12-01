package Stack;

import java.util.EmptyStackException;

import Linklist.ListNode;

public class LinkedStack {
	private int length;
	private ListNode top;
	
	//Constructor: creates an empty stack
	public LinkedStack(){
		top=null;
		length=0;
	}
	public int length() {
		return length;
	}
	//Adds the specified data to the head
	public void push(int data) {
		ListNode temp=new ListNode(data);
		temp.setNext(top);
		top=temp;
		length++;
	}
	
	//Remove the data at the top of this stack and returns a
	//reference to it. Throws an EmptyStackException if the stack is empty
	public int pop() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			int result=top.getData();
			top=top.getNext();
			length--;
			return result;
		}
	}
	//Returns a reference to the data at the top of this stack
	//throw an EmptyStackException if the stack is empty
	public int peek() throws EmptyStackException{
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStack ls=new LinkedStack();
		ls.push(1);
		ls.push(2);
		ls.push(3);
		ls.push(4);
		ls.push(5);
		ls.push(6);
		ls.push(7);
		ls.push(8);
		System.out.println(ls.toString(ls.top));
		ls.pop();
		ls.pop();
		ls.pop();
		ls.pop();
		ls.pop();
		System.out.println(ls.toString(ls.top));
		
	}

}
