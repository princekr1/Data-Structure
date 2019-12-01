package Linklist;

public class LinkList {
	ListNode head;
	private int length=0;
	public synchronized ListNode getHead() {
		return head;
	}
	public synchronized void insertAtBeginning(ListNode node) {
		node.setNext(head);
		head=node;
		length++;
		System.out.print("length:"+length+"\n");
	}
	public synchronized void insertAtEnd(ListNode node) {
		if(head==null) {
			head=node;
		}
		else {
			ListNode p,q;
			for(p=head;(q=p.getNext())!=null;p=q);
			p.setNext(node);
			length++;
			
		}
	}
	public synchronized void insertAtPosition(ListNode node,int pos) {
		if(pos<0) {
			pos=0;
		}
		if(pos>=length) {
			pos=length;
		}
		
		//if list is empty make it one element
		if(head==null) {
			head=node;
		}
		//adding at the front of the list
		else if(pos==0){
			node.setNext(head);
			head=node;
		}
		//find correct position and insert
		else {
			ListNode curr=head;
			for(int i=1;i<pos;i++) {
				curr=curr.getNext();
			}
			node.setNext(curr.getNext());
			curr.setNext(node);
		}
		length+=1;
	}
	public synchronized void show() {
		ListNode curr=head;
		System.out.println("list is:");
		if(curr==null) {
			System.out.println("List is Empty\n");
		}
		while(curr!=null) {
			System.out.println(curr.getData()+"\t");
			curr=curr.getNext();
		}
	}
	//remove and return the node at the head of the list
	public synchronized ListNode deleteAtBeginning() {
		ListNode node =head;
		if(node !=null) {
			head=node.getNext();
			node.setNext(null);
			length--;
		}
		else {
			System.out.println("List is empty");
			return null;
		}
		return node;
	}
	
	//remove and return of given position
	public synchronized ListNode deleteAtPos(int pos) {
		ListNode curr=head,q=null;
		
		if(head==null) {
			System.out.println("List is empty");
			return null;
		}
		if(pos<0) {
			pos=0;
			return null;
		}
		if(pos>=length) {
			pos=length-1;
		}
		
		//removing the head element
		if(pos==0) {
			head=head.getNext();
			curr.setNext(null);
			return curr;
		}
		else {
			ListNode p = head;
			for(int i=1;i<pos;i++) {
				p=p.getNext();
			}
			q=p.getNext();
			p.setNext(p.getNext().getNext());
		}
		length--;
		
	return q;
		
	}
	
	//remove and return node at the end of the list
	public synchronized ListNode deleteAtEnd() {
		ListNode node =head,p,q;
		if(node==null) {
			return null;
		}
		if(node.getNext()==null) {
			head=null;
			length--;
			return node;
		}
		if(node !=null) {
			for(p=head;(q=p.getNext().getNext())!=null;p=p.getNext());
			node=p.getNext();
			p.setNext(null);
			length--;
			
		}
		return node;
	}
	//remove a node matching the specific node from the list
	public synchronized void removeMatched(ListNode node) {
		System.out.println("inside remove func:"+node.getData());
		if(head==null) {
			return;
		}
		if(node.getData()==head.getData()) {
			head=head.getNext();
			return;
		}
		ListNode p=head,q=null;
		while((q=p.getNext())!=null) {
			if(node.getData()==q.getData()) {
				p.setNext(q.getNext());
				return;
			}
			p=q;
		}
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
	public int gtLength() {
		return length;
	}
	//find position of first value that is equal to given value
	public int getPosition(int data) {
		ListNode curr=head;
		if(head==null) {
			return -1;
		}
		int pos=0;
		while(curr!=null) {
			if(data==curr.getData()) {
				return pos;
			}
			curr=curr.getNext();
			pos++;
		}
	
		return Integer.MIN_VALUE;
		
	}
	//Reverse the list
	public ListNode reverseList(ListNode h) {
		ListNode curr=h,prev = null,next=null;
		if(h==null) {
			return curr;
		}
		while(curr!=null) {
			next=curr.getNext();
			curr.setNext(prev);
			prev=curr;
			curr=next;
		}
		return prev;
	}
	public void clearList() {
		head=null;
		length=0;
	}
	public static void main(String args[]) {
		LinkList list=new LinkList();
		ListNode node=new ListNode(1);
		list.insertAtBeginning(node);
		list.insertAtEnd(new ListNode(2));
		list.insertAtEnd(new ListNode(3));
		list.insertAtEnd(new ListNode(4));
		//list.insertAtBeginning(node);
		list.insertAtBeginning(new ListNode(1));
		list.show();
		list.insertAtPosition(new ListNode(6),0);
		list.insertAtPosition(new ListNode(7),-3);
		list.insertAtPosition(new ListNode(15),13);
		list.insertAtPosition(new ListNode(8),5);
		list.insertAtPosition(new ListNode(25),2);
		list.insertAtPosition(new ListNode(40),3);
		list.insertAtPosition(new ListNode(32),7);
		
		list.show();
		/*System.out.println(list.deleteAtBeginning().getData());
		System.out.println(list.deleteAtBeginning().getData());
		System.out.println(list.deleteAtBeginning().getData());
		System.out.println(list.deleteAtEnd().getData());
		System.out.println(list.deleteAtEnd().getData());
		list.show();
		System.out.println(list.deleteAtPos(0).getData());
		System.out.println(list.deleteAtPos(1).getData());
		//System.out.println(list.deleteAtPos(3).getData());
		list.show();
		System.out.println("remove from list");
		list.removeMatched(new ListNode(1));
		list.removeMatched(new ListNode(32));
		list.removeMatched(new ListNode(3));
		list.show();
		System.out.println(list.toString(list.getHead()));
		System.out.println(list.getPosition(2));
		System.out.println(list.getPosition(8));
		System.out.println(list.getPosition(32));*/
		//ListNode reversenode=list.reverseList(list.getHead());
		//System.out.println(list.toString(reversenode));
		list.clearList();
		list.show();
		
	}
}
