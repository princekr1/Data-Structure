package Stack;

public class FixedSizeArrayStack {
	//Length of array used to implement stack
	protected int capacity;
	//default array capacity
	public static final int CAPACITY=10;
	//Array Used to Implement the stack
	protected int []stackrep;
	//index of top element of the stack in the array
	protected int top=-1;
	//initializing the stack to use this capacity
	public FixedSizeArrayStack(){
		this(CAPACITY);
	}
	
	//intialize the stack to use an array of given length
	public FixedSizeArrayStack(int cap){
		capacity=cap;
		stackrep=new int[capacity];
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
	public void  push(int data) throws Exception {
		if(getSize()==capacity) {
			throw new Exception("Stack is Full");
		}
		else {
			stackrep[++top]=data;
		}
	}
	//get the top element of stack
	public int top() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return stackrep[top];
	}
	//take an element out from the top
	public int pop() throws Exception {
		int data;
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		else {
			data=stackrep[top];
			stackrep[top--]=Integer.MIN_VALUE;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedSizeArrayStack fas=new FixedSizeArrayStack();
		try {
			fas.push(1);
			fas.push(2);
			fas.push(3);
			fas.push(4);
			fas.push(1);
			fas.push(2);
			fas.push(3);
			System.out.println("Popped item:"+fas.pop());
			System.out.println("Popped item:"+fas.pop());
			System.out.println("Popped item:"+fas.pop());
			System.out.println("Popped item:"+fas.pop());
			System.out.println("Popped item:"+fas.pop());
			System.out.println("Popped item:"+fas.pop());
			System.out.println("Popped item:"+fas.pop());
			System.out.println("Popped item:"+fas.pop());
			System.out.println("Popped item:"+fas.pop());
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println(fas.toString());
		}

	}

}
