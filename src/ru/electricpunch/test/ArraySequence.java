package ru.electricpunch.test;

public class ArraySequence implements Sequence {

	private Object[] arguments;

	public ArraySequence(Object[] args) {
		this.arguments = args;
	}

	@Override
	public Object head() {
		return arguments[0];
	}

	@Override
	public Sequence tail() {
		if (arguments.length <= 1)
			return null;
		else {
			Object[] tail_args = new Object[arguments.length - 1];
			System.arraycopy(arguments, 1, tail_args, 0, arguments.length - 1);
			return new ArraySequence(tail_args);
		}
	}
}
