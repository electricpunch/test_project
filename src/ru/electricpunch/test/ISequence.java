package ru.electricpunch.test;

public interface ISequence {
	
	/**Первый элемент последовательности**/
	Object head();
	
	/**Остальные элементы последовательности**/
	ISequence tail();

}
