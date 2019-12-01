package Linklist;

public class CircularLinkedList {
	private CLLNode tail;
	private int length;
	CircularLinkedList(){
		length=0;
		tail=null;
	}
	
	//Add elements to the head of list
	void addToHead(int data) {
		CLLNode node=new CLLNode(data);
		if(tail==null) {
			tail=node;
			tail.setNext(tail);
		}
		else {
			node.setNext(tail.getNext());
			tail.setNext(node);
		}
		length++;
	}
	
	//Add to tell data
	void addToTail(int data) {
		addToHead(data);
		tail=tail.getNext();
	}
	
	//return data at the head of list
	public int peek() {
		return tail.getNext().getData();
	}
	//return data at the tail of list
		public int tailPeek() {
			return tail.getData();
		}
	//remove from head
		public void removeFromHead() {
			if(tail==null) {
				return;
			}
			else {
				if(tail.getNext()==tail) {
					tail=null;
				}
				else {
					tail.setNext(tail.getNext().getNext());
				}
			}
			length--;
		}
		//remove from tail
		void removeFromTail() {
			CLLNode temp=tail;
			if(tail==null) {
				return;
			}
			if(temp.getNext()==null) {
				tail=null;
				length--;
				return;
			}
			while(temp.getNext()!=tail) {
				temp=temp.getNext();
			}
			temp.setNext(tail.getNext());
			tail=temp;
			length--;
		}
		
		//return and remove element equal to given data
		public int removeGivenData(int data) {
			if(tail==null) {
				return Integer.MIN_VALUE;
			}
			else {
				if(tail.getData()==data) {
					removeFromTail();
					return data;
				}
				CLLNode temp=tail.getNext(),prev=tail;
				while(temp.getNext()!=tail) {
				
					if(temp.getData()==data) {
						prev.setNext(temp.getNext());
						return temp.getData();
					}
					prev=temp;
					temp=temp.getNext();
				}
				
			}
			return Integer.MIN_VALUE;
			
		}
		
		//Find the current length of CLL
		public int size() {
			return length;
		}
		
		//Return a String representation of this Collection
		public String toString() {
			String result="[";
			if(tail==null) {
				return result+"]";
			}
			result=result+tail.getNext().getData();
			CLLNode temp=tail.getNext().getNext();
			while(temp!=tail) {
				result=result+","+temp.getData();
				temp=temp.getNext();
				
			}
			return result+","+tail.getData()+"]";
			
		}
	//show element in circular linked list
	void show() {
		CLLNode temp=tail.getNext();
		while(tail!=temp) {
			System.out.print(temp.getData()+"\t");
			temp=temp.getNext();
		}
		System.out.println(temp.getData());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList cll=new CircularLinkedList();
		cll.addToHead(1);
		cll.addToHead(2);
		cll.addToHead(3);
		cll.addToHead(4);
		cll.addToTail(5);
		cll.addToTail(6);
		cll.addToTail(7);
		cll.show();
		//cll.removeFromHead();
		//cll.removeFromHead();
		//cll.show();
		//cll.removeFromTail();
		//cll.removeFromTail();
		//cll.show();
		//cll.removeGivenData(2);
		//cll.removeGivenData(5);
		//cll.show();
		System.out.println(cll.toString());

	}

}
