package ru.electricpunch.test;

public class Test {

	private boolean isRightDirection(int rotation) {
		if (rotation > 0) 
			return true;
		else
			return false;
	}
	
	private ArraySequence getRotatedSequence(ArraySequence seq, int rotation) {
		Object[] buf = new Object[seq.tail.arguments.length+1];
		if (isRightDirection(rotation)) {
			buf[0] = seq.tail.arguments[seq.tail.arguments.length-1];
			buf[1] = seq.head;
			System.arraycopy(seq.tail.arguments, 0, buf, 2, buf.length-2);
		} else {
			buf[buf.length-1] = seq.head;
			System.arraycopy(seq.tail.arguments, 0, buf, 0, buf.length-1);
		}
		return new ArraySequence(buf);
	}
	
	public Object getAfterRotation(ArraySequence seq, int rotation, int itemNumber) {
		for (int i=0; i < Math.abs(rotation); i++) {
			seq = getRotatedSequence(seq, rotation);
			seq.init();
		}
		return seq.getElement(itemNumber);
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		Object[] arr = {"a", "b", "c", "d", "e", "f"};
		ArraySequence s = new ArraySequence(arr);
		s.init();
		System.out.println(test.getAfterRotation(s, -2, 0));
	}

}
