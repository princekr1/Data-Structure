package Stack;

public class DynamicArrayStack {
	//Length of the array used to implement the stack
	protected int capacity;
	//default array capacity
	public static final int CAPACITY=16; //power of 2
	public static int MINCAPACITY=1<<15; //power of 2
	
	//Array used to implement the stack
	public int []stackRep;
	//index of the top element of the stack in the array
	public int top =-1;
	//initialize stack to use an array of default length
	public DynamicArrayStack() {
		this(CAPACITY);
	}
	
	//initialize stack to use an array of default length
		public DynamicArrayStack(int cap) {
			this.capacity=cap;
			stackRep=new int[capacity];		//Compiler may give waning but it's ok
		}
		
	//Return the number of elements in the stack this method runs in a O(1) time
		public int size() {
			return (top+1);
		}
		
		//tests whether the stack is empty
		public boolean isEmpty() {
			return (top<0);
			
		}
		//insert an element at the top of stack
		public void push(int data) {
			if(size()==capacity) {
				expand();
			}
			stackRep[++top]=data;
		}
		private void expand() {
			System.out.println("inside expand#####################");
			int length=size();
			int[] newStack=new int[length<<1];
			System.arraycopy(stackRep, 0, newStack, 0, length);
			stackRep=newStack;
		}
		
		//Dynamic array operation: shrink to 1/2 if more then 3/4 is empty
		private void shrink() {
			int length=top+1;
			if(length<=MINCAPACITY || top<<2 >=length) {
				return;
			}
			length=length+(top<<1);		//Still means shrink to at 1/2 or less of the heap
			if(top<=MINCAPACITY) length=MINCAPACITY;
			int []newStack=new int[length];
			System.arraycopy(stackRep, 0, newStack, 0, length);
			stackRep=newStack;
			
		}
		//get the top element of stack
		public int top() throws Exception{
			if(isEmpty()) {
				throw new Exception("Stack is Empty");
			}
			return stackRep[top];
		}
		//take an element out from the top
		public int pop() throws Exception {
			int data;
			if(isEmpty()) {
				throw new Exception("Stack is Empty");
			}
			else {
				data=stackRep[top];
				stackRep[top--]=Integer.MIN_VALUE;
				return data;
			}
		}
		
		//return a string representation of stack
		public String toString() {
			String s;
			s="[";
			if(size()>0) {
				s+=stackRep[0];
			}
			if(size()>1) {
				for(int i=1;i<=top;i++) {
				s+=","+stackRep[i];
				}
			}
			return s+"]";
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicArrayStack das=new DynamicArrayStack();
		try {
		das.push(1);
		das.push(2);
		das.push(3);
		das.push(4);
		das.push(1);
		das.push(2);
		das.push(3);
		das.push(1);
		das.push(2);
		das.push(3);
		das.push(4);
		das.push(1);
		das.push(2);
		das.push(3);
		das.push(1);
		das.push(2);
		das.push(3);
		das.push(4);
		das.push(1);
		das.push(2);
		das.push(3);
		das.push(1);
		das.push(2);
		das.push(3);
		das.push(4);
		das.push(1);
		das.push(2);
		das.push(3);
		System.out.println(das.toString());
		System.out.println("Popped item:"+das.pop());
		System.out.println("Popped item:"+das.pop());
		System.out.println("Popped item:"+das.pop());
		System.out.println("Popped item:"+das.pop());
		System.out.println("Popped item:"+das.pop());
		System.out.println("Popped item:"+das.pop());
		System.out.println("Popped item:"+das.pop());
		System.out.println("Popped item:"+das.pop());
		System.out.println("Popped item:"+das.pop());
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	finally {
		System.out.println(das.toString());
	}


	}

}
