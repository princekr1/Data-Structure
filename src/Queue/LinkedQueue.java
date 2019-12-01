package Queue;

public class LinkedQueue {

	private int length;
	private ListNode front,rear;
	//Create an empty Queue
	public LinkedQueue() {
		length=0;
		front=rear=null;
	}
	//Add the Specified data to the rear of the queue
	public void enQueue(int data) {
		ListNode node=new ListNode(data);
		if(isEmpty()) {
			front=node;
			System.out.println("first data: "+front.getData());
		}
		else {
			rear.setNext(node);
			//System.out.println(length+" data: "+rear.getData());
		}
		rear=node;
		//System.out.println("first rear data: "+rear.getData());
		length++;
	}
	//Remove the data at the front of the queue and returns a reference
	//to it. throws an exception if the queue is empty.
	public int deQueue() throws Exception{
		if(isEmpty()) {
			throw new Exception("Queue");
		}
		else {
			int result=front.getData();
			front=front.getNext();
			length--;
			if(isEmpty()) {
				rear=null;
			}
			return result;
		}
	}
	//Returns a reference to the data at the front of the queue.
	//Data is not removed from the queue throws an Exception 
	//if the queue is Empty
	public int First() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		else {
			return front.getData();
		}
	}
	//Return true if the queue is empty otherwise False
	public boolean isEmpty() {
		return (length==0);
	}
	
	//Return the number of elements in this Queue
	public int size() {
		return length;
	}
	//Returns a String representation of this Queue
	public String toString() {
		String result="";
		ListNode current=front;
		while(current!=null) {
			result=result+current.getData()+"\t";
			//System.out.println("Current data "+result);
			current=current.getNext();
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			LinkedQueue lq=new LinkedQueue();
			lq.enQueue(1);
			lq.enQueue(2);
			lq.enQueue(3);
			lq.enQueue(4);
			lq.enQueue(5);
			lq.enQueue(11);
			lq.enQueue(22);
			lq.enQueue(33);
			lq.enQueue(44);
			lq.enQueue(55);
			lq.enQueue(111);
			lq.enQueue(222);
			lq.enQueue(333);
			lq.enQueue(444);
			lq.enQueue(555);
			lq.enQueue(2400);
			System.out.println(lq.toString());
			
			System.out.println("After Dequing..........");
			System.out.println("Dequed int:"+lq.deQueue());
			System.out.println("Dequed int:"+lq.deQueue());
			System.out.println("Dequed int:"+lq.deQueue());
			System.out.println("Dequed int:"+lq.deQueue());
			System.out.println("Dequed int:"+lq.deQueue());
			System.out.println("Dequed int:"+lq.deQueue());
			System.out.println("Dequed int:"+lq.deQueue());
			System.out.println("Dequed int:"+lq.deQueue());
			System.out.println(lq.toString());
			System.out.println("After EnQueuing.......");
			lq.enQueue(1);
			lq.enQueue(2);
			lq.enQueue(3);
			lq.enQueue(4);
			lq.enQueue(5);
			lq.enQueue(11);
			lq.enQueue(22);
			System.out.println(lq.toString());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
