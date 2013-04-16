package ru.electricpunch.test;

public interface Sequence {
	
	/**Первый элемент последовательности**/
	Object head();
	
	/**Остальные элементы последовательности**/
	Sequence tail();

}
