package com.interview.all;


import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class StackType<T> implements dataStructure {

	public Stack<T> stack;
	public StackType () {
		stack = new Stack<T>();
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	} 
	
	public int getStackSize() {
		// TODO Auto-generated method stub
		return stack.size();
	} 
	
	public T getTop() throws EmptyStackException{
		try {
			return  stack.peek();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("The stack is empty");
		}
		
		return null;
	}
	
	public int indexOf(T elem) {
		stack.push(elem);
		return stack.indexOf(elem);
		
		
	}
	
	public void add(T elem) {
		stack.add(elem);
	}
	
	public void addAll(Collection<T> c) {
		stack.addAll(c);
	}
	
	


public static void main(String[] args)
{
	StackType<Integer> integerStack = new StackType<Integer>();
	StackType<String> stringStack = new StackType<String>();
	stringStack.getTop();
	List<Integer> list = Arrays.asList(1,2,3,4,5,6,7); 
	integerStack.addAll(list);
	
	System.out.println(integerStack.toString());
	

}
}