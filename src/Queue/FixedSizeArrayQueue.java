package Queue;

public class FixedSizeArrayQueue {
	//Array used to implement queue
	private int[] queueRep;
	private int size, front,rear;
	//default Length of array  used to implement queue
	private static final int CAPACITY=16;
	
	//Default Constructor
	FixedSizeArrayQueue(){
		queueRep=new int[CAPACITY];
		front=0;size=0;rear=0;
	}
	FixedSizeArrayQueue(int cap){
		queueRep=new int[cap];
		front=0;rear=0;size=0;
	}
	public int[] getQueueRep() {
		return queueRep;
	}
	public void setQueueRep(int[] queueRep) {
		this.queueRep = queueRep;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getFront() {
		return front;
	}
	public void setFront(int front) {
		this.front = front;
	}
	public int getRear() {
		return rear;
	}
	public void setRear(int rear) {
		this.rear = rear;
	}
	//insert an element at the rear of queue. method takes O(1) time
	public void enQueue(int data) {
		if(size==queueRep.length) {
			throw new IllegalStateException("Queue is Full: OVERFLOW..........");
		}
		else {
			size++;
			queueRep[rear]=data;
			//System.out.println("queue data"+queueRep[rear]);
			rear=(rear+1)%(queueRep.length);
		}
	}
	
	//Remove an element from the queue. This method runsin O(1) time.
	public int deQueue() {
		//EFFECTS : if Queue is empty throws IllegalStateException
		//else remove and return oldest element of this
		if(size==0) {
			throw new IllegalStateException("Queue is empty : UnderFlow");
		}
		else {
			size--;
			int data=queueRep[front];
			queueRep[front]=Integer.MIN_VALUE;
			front=(front+1)%(queueRep.length);
			return data;
		}
	}
	//check whether Queue is empty. the method runs in O(1) times
	public boolean isEmpty() {
		return (size==0);
	}
	//Returns the number of element in Queue. Method runs in O(1) times
	public int size() {
		return size;
	}
	//Return a String Representation of the Queue as a list of elements, with
	//the front element at the end;[....,prev, rear].this method runs in O(n)
	//time, where n is the size of the queue.
	public String toString() {
		String result="[";
		for(int i=0;i<size;i++) {
			result+=Integer.toString(queueRep[(front+i) % (queueRep.length)]);
			if(i<size-1) {
				result+=",";
			}
		}
		result+="]";
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedSizeArrayQueue fsaq=new FixedSizeArrayQueue();
		fsaq.enQueue(1);
		fsaq.enQueue(2);
		fsaq.enQueue(3);
		fsaq.enQueue(4);
		fsaq.enQueue(5);
		fsaq.enQueue(11);
		fsaq.enQueue(22);
		fsaq.enQueue(33);
		fsaq.enQueue(44);
		fsaq.enQueue(55);
		fsaq.enQueue(111);
		fsaq.enQueue(222);
		fsaq.enQueue(333);
		fsaq.enQueue(444);
		fsaq.enQueue(555);
		fsaq.enQueue(2400);
		System.out.println(fsaq.toString());
		System.out.println("After Dequing..........");
		System.out.println("Dequed int:"+fsaq.deQueue());
		System.out.println("Dequed int:"+fsaq.deQueue());
		System.out.println("Dequed int:"+fsaq.deQueue());
		System.out.println("Dequed int:"+fsaq.deQueue());
		System.out.println("Dequed int:"+fsaq.deQueue());
		System.out.println("Dequed int:"+fsaq.deQueue());
		System.out.println("Dequed int:"+fsaq.deQueue());
		System.out.println("Dequed int:"+fsaq.deQueue());
		System.out.println(fsaq.toString());
		System.out.println("After EnQueuing.......");
		fsaq.enQueue(1);
		fsaq.enQueue(2);
		fsaq.enQueue(3);
		fsaq.enQueue(4);
		fsaq.enQueue(5);
		fsaq.enQueue(11);
		fsaq.enQueue(22);
		System.out.println(fsaq.toString());

	}

}
