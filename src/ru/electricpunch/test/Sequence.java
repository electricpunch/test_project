package ru.electricpunch.test;

public class Sequence implements ISequence{
	
	Object head;
	Sequence tail;
	Object[] arguments;

	public Sequence(Object[] args) {
		this.arguments = args;
		this.init(args);
	}
	
	private void setHead(Object o) {
		this.head = o;
	}
	
	private void setTail(Object[] arr) 
	{
		Object[] tail = new Object[arr.length-1];
		System.arraycopy(arr, 1, tail, 0, tail.length);
		this.tail = new Sequence(tail);
	}
	
	public void init(Object[] arr) {
		setHead(arr[0]);
		setTail(arr);
	}
	
	
	@Override
	public Object head() {
		return this.head;
	}

	@Override
	public ISequence tail() {
		return this.tail;
	}
	
	public void printSequence() {
		for (int i=0; i < arguments.length; i++) {
			System.out.print(arguments[i] + " ");
		}
	}

	
}
