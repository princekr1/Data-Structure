package Linklist;

public class DoubleLinkedList {
	private DLLNode head;
	private DLLNode tail;
	private int length;

	//Create an empty list
	public DoubleLinkedList() {
		tail=new DLLNode(Integer.MIN_VALUE,null,null);
		length=0;
	}

	public DLLNode getHead() {
		return head;
	}

	public void setHead(DLLNode head) {
		this.head = head;
	}

	public DLLNode getTail() {
		return tail;
	}

	public void setTail(DLLNode tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	//Get the value at a given position
		public int get(int pos) {
			return Integer.MIN_VALUE;
		}
		//find the position of the node that is equal to the given value
		public int getPosition(int data) {
			DLLNode temp=head;
			int pos=0;
			while(temp!=null) {
				if(temp.getData()==data) {
					return pos;
				}
				pos+=1;
				temp=temp.getNext();
			}
			return Integer.MIN_VALUE;
			
		}
		
		//return the length of current list
		public int length() {
			return length;
		}
		
		//insert a new value at the front of the list
		public void insert(int newValue) {
			DLLNode newNode=new DLLNode(newValue,null,null);
			if(head==null) {
				head=newNode;
				tail=newNode;
			}
			else {
				newNode.setNext(head);
				head.setPrev(newNode);
				head=newNode;
			}
			length+=1;
			
		}
		
		//Adding a new element at the rear of the list
				public void insertAtRear(int data) {
					if(head==null) {
						insert(data);
						length+=1;
						return;
					}
					else {
						DLLNode newNode=new DLLNode(data,null,null);
						newNode.setPrev(tail);
						tail.setNext(newNode);
						tail=newNode;
					}
					length+=1;
				}
				
		//Add a new Node to a given position
		public void insert(int data,int pos) {
			if(pos>=length) {
				pos=length;
				insertAtRear(data);
				return;
			}
			
			if(pos<=0||head==null) {
				insert(data);
				return;
			}
			//find the correct position and insert
			else {
				DLLNode temp=head;
				for(int i=0;i<pos-1;i++) {
					temp=temp.getNext();
				}
				DLLNode newNode=new DLLNode(data,null,null);
				newNode.setNext(temp.getNext());
				newNode.setPrev(temp);
				temp.setNext(newNode);
				temp.getNext().setPrev(newNode);
			}
			length++;
		}
		
		//Remove elements from the given position of the double Linked list
		public void remove(int pos) {
			if(head==null) {
				return;
			}
			if(pos<0) {
				pos=0;
			}
			if(pos>length-1) {
				pos=length-1;
			}
			if(pos==0) {
				removeHead();
				return;
			}
				DLLNode temp=head;
				for(int i=0;i<pos;i++) {
					System.out.println("remove:"+i+"\t"+temp.getData());
					temp=temp.getNext();
				}
				System.out.println("temp data:"+temp.getData()+"\tpos:"+pos);
				if(pos==length-1) {
					tail=tail.getPrev();
					tail.setNext(null);
					length--;
					return;
				}
			System.out.println("previous data:"+temp.getPrev().getData());
				temp.getNext().setPrev(temp.getPrev());
				System.out.println("next data:"+temp.getNext().getData());
				temp.getPrev().setNext(temp.getNext());
				
			length--;
		}
		public int removeHead() {
			if(head==null) {
				return Integer.MIN_VALUE;
			}
			System.out.println("inside remove head");
			if(head.getNext()!=null)
			{
				head=head.getNext();
				head.setPrev(null);
			}
			else {
				head=null;
			}
			length-=1;
			System.out.println("length:"+length);
			return 1;
			
		}
		
		public int removeTail() {
			return length;
			
		}
		
		//show elements of double linked list
		public void show() {
			DLLNode temp=head;
			System.out.println("list is:");
		
			for(int i=0;i<length;i++){
					System.out.println(i+"\t"+temp.getData());
					temp=temp.getNext();
				}
			
		}
		//show elements of double linked list
				public void reShow() {
					DLLNode temp=tail;
					System.out.println("list is:");
				
					for(int i=0;i<length;i++){
							System.out.println(i+"\t"+temp.getData());
							temp=temp.getPrev();
						}
					
				}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			DoubleLinkedList dll=new DoubleLinkedList();
			dll.insert(1);
			dll.show();
			dll.insert(2);
			dll.insert(3);
			dll.insert(4);
			dll.insert(5);
			dll.insert(6);
			dll.insert(7);
			dll.show();
			dll.insert(10,5);
			dll.insert(11,0);
			dll.insert(20,4);
			//System.out.println("length:"+dll.getLength());
			dll.insert(13,10);
			dll.insert(30,25);
			dll.insert(21,2);
			//System.out.println("length:"+dll.getLength());
			dll.show();
			dll.insertAtRear(100);
			dll.insertAtRear(200);
			dll.insertAtRear(300);
			//System.out.println("length:"+dll.getLength());
			dll.show();
			dll.reShow();
			
			
			
		}

}
