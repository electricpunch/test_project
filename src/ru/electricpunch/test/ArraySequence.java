package ru.electricpunch.test;

public class ArraySequence implements Sequence{
	
	Object head;
	ArraySequence tail;
	public Object[] arguments;

	public ArraySequence(Object[] args) {
		this.arguments = args;
	}
	
	/** Изменить первый элемент последовательности **/
	private void setHead(Object o) {
		this.head = o;
	}
	
	/** Изменить хвост последовательности **/
	private void setTail(Object[] arr) 
	{
		Object[] tail = new Object[arr.length-1];
		System.arraycopy(arr, 1, tail, 0, tail.length);
		this.tail = new ArraySequence(tail);
	}
	
	/** Инициализация последовательности **/
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
	
	/** Вывод последовательности на консоль **/
	public void printSequence() {
		for (int i=0; i < arguments.length; i++) {
			System.out.print(arguments[i] + " ");
		}
	}
	
	/** Получить элемент последовательности по его номеру **/
	public Object getElement(int index) {
		return arguments[index];
	}
	
}
