package ru.electricpunch.test;

public class Test {

	private boolean isLeftDirection(int rotations) {
		if (rotations < 0)
			return true;
		else
			return false;
	}

	private Object getAfterRotation(Sequence s, int rotations, int index) {
		SequenceManipulations manipulation = new SequenceManipulations();
		if (isLeftDirection(rotations))
			for (int i = rotations; i < 0; i++) {
				s = manipulation.shiftToLeft(s);
			}
		else
			for (int i = rotations; i > 0; i--) {
				s = manipulation.shiftToRight(s);
			}
		return manipulation.getElementFromSequence(s, index);
	}

	public static void main(String[] args) {
		Test test = new Test();
		Sequence s = new ArraySequence(new Object[] { "a", "b", "c" });
		System.out.println(test.getAfterRotation(s, 1, 1));
	}
}
