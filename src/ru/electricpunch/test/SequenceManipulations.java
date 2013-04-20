package ru.electricpunch.test;

public class SequenceManipulations {

	private Sequence sequence(final Object head, final Sequence tail) {
		return new Sequence() {

			@Override
			public Object head() {
				return head;
			}

			@Override
			public Sequence tail() {
				return tail;
			}
		};
	}

	public Sequence getInversedSequence(Sequence s) {
		Sequence inversed_s = null;
		while (s != null) {
			inversed_s = sequence(s.head(), inversed_s);
			s = s.tail();
		}
		return inversed_s;
	}

	private Sequence getSequenceFromHeads(Sequence s) {
		Sequence s2 = null;
		Object head = s.head();
		while (s.tail() != null) {
			s2 = sequence(s.tail().head(), s2);
			s = s.tail();
		}
		s2 = sequence(head, s2);
		return s2;
	}

	public Sequence shiftToLeft(Sequence s) {
		s = getSequenceFromHeads(s);
		s = getInversedSequence(s);
		return s;
	}

	public Sequence shiftToRight(Sequence s) {
		s = getInversedSequence(s);
		s = getSequenceFromHeads(s);
		return s;
	}

	public Object getElementFromSequence(Sequence s, int index) {
		for (int i = 1; i < index; i++) {
			s = s.tail();
		}
		try {
			return s.head();
		} catch (NullPointerException e) {
			return "В заданной последовательности отсутствует элемент с индексом "
					+ index;
		}
	}

	public void printSequence(Sequence s) {
		Object head;
		while (s != null) {
			head = s.head();
			s = s.tail();
			System.out.print(head + " ");
		}
		System.out.println();
	}
}
