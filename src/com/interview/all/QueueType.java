package com.interview.all;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueType implements dataStructure {

	
	private Queue<String> q;
	
	public QueueType(){
		q = new LinkedList<String>();
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	public void exercise() {
		q.add("name");
		q.offer(name);
		q.poll();
		String topString = q.peek();
		
	}
	
	public void deque() {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.push(5);
		deque.offer(8);
		deque.offer(7);
		System.out.println(deque.getFirst());
		System.out.println(deque.getLast());
		System.out.println(deque.pollFirst());
		System.out.println(deque.pollFirst());
		
		
	}
	
	public static void main(String[] args)
	{	QueueType queueType =  new QueueType();
		queueType.deque();
	}
}
