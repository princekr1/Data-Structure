package Linklist;

public class DLLNode {
	int data;
	DLLNode prev;
	DLLNode next;
	
	public DLLNode(int data) {
		this.data=data;
	}
	
	public DLLNode(int data, DLLNode prev, DLLNode next) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DLLNode getNext() {
		return next;
	}
	public void setNext(DLLNode next) {
		this.next = next;
	}
	public DLLNode getPrev() {
		return prev;
	}
	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}
	
}
