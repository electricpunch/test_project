package ru.electricpunch.test;

public class ArraySequence implements Sequence{
	
	Object head;
	ArraySequence tail;
	public Object[] arguments;

	public ArraySequence(Object[] args) {
		this.arguments = args;
	}
	
	/** �������� ������ ������� ������������������ **/
	private void setHead(Object o) {
		this.head = o;
	}
	
	/** �������� ����� ������������������ **/
	private void setTail(Object[] arr) 
	{
		Object[] tail = new Object[arr.length-1];
		System.arraycopy(arr, 1, tail, 0, tail.length);
		this.tail = new ArraySequence(tail);
	}
	
	/** ������������� ������������������ **/
	public void init() {
		setHead(arguments[0]);
		setTail(arguments);
	}
	
	@Override
	public Object head() {
		return this.head;
	}

	@Override
	public Sequence tail() {
		return this.tail;
	}
	
	/** ����� ������������������ �� ������� **/
	public void printSequence() {
		for (int i=0; i < arguments.length; i++) {
			System.out.print(arguments[i] + " ");
		}
	}
	
	/** �������� ������� ������������������ �� ��� ������ **/
	public Object getElement(int index) {
		return arguments[index];
	}
	
}
