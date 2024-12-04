package com.interview.all;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Utils {
	static Random random = new Random();
	
	public static String[] getRandomStringArray(int size) {
		//create the fixed length array
		String[] result = new String[size];
		
		//used to create Strings efficiently
		StringBuilder word = new StringBuilder();
		for(int i=0;i<size;i++) {
			//choose the length for the next word in the array
			int wordLength = random.nextInt(10)+1;
			for(int j=0; j<wordLength;j++) {
				char c = (char) (random.nextInt(26) + (random.nextBoolean() ?  'A':'a'));
				word.append(c);
			}
			result[i] = word.toString();
			word = new StringBuilder();
		}
		
		String[] randomWords = IntStream.range(0, size)
                .mapToObj(i -> IntStream.range(0, new Random().nextInt(10) + 1) // Random word length
                                        .mapToObj(j -> (char) (random.nextInt(26) + (random.nextBoolean() ? 'A':'a')))
                                        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                                        .toString())
                .toArray(String[]::new);
		return randomWords;
	}
	
	public static String[] createFloatStringArray(int size) {
		
		DecimalFormat formatter = new DecimalFormat("#.##");
		String[] result = DoubleStream.generate(() -> random.nextDouble() * 100)
        .limit(size)
        .boxed()
        .map(formatter::format)
        .toArray(String[]::new);

		//ArrayList of String to array
		List<String> stringList = Arrays.asList("apple", "banana", "cherry", "date");
		String[] stringArray = stringList.stream()
                .toArray(String[]::new);
		Collections.reverse(Arrays.asList(stringArray));
		System.out.println( Arrays.toString(stringArray));
		//ArrayList of Integer to array
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> integerListOrdered = integerList.stream().collect(Collectors.toList());
		Collections.reverse(integerList.stream().sorted().collect(Collectors.toList()));
		System.out.println( integerListOrdered);
        int[] integerArray =  integerList.stream()
                                        .mapToInt(Integer::intValue)
                                        .toArray();
		
		return result;
	}
	
	public static ArrayList<String> createFloatStringArrayList(int size) {
		
		Random random = new Random();
		DecimalFormat formatter = new DecimalFormat("#.##");
		List<String> result = DoubleStream.generate(() -> random.nextDouble() * 100)
        .limit(size)
        .boxed()
        .map(formatter::format).collect(Collectors.toList());
		
		// array String to ArrayList of String 
		String[] stringArray = {"apple", "banana", "cherry", "date"};
        List<String> stringList = Arrays.stream(stringArray)
                                         .collect(Collectors.toList());
        
        
		
        // array int to ArrayList of String 
        int[] integerArray = {1, 2, 3, 4, 5};
        List<Integer> integerList = Arrays.stream(integerArray)
                                          .boxed()
                                          .collect(Collectors.toList());
        Collections.sort(integerList);
		return (ArrayList<String>) result;

	}
	
	public static String practiceMath() {
		DecimalFormat formatter = new DecimalFormat("#.##");
		
		int a = 6;
		int b = 5;
		int exponentialFactor = 2;
		DecimalFormat df = new DecimalFormat("#.##");
		String d = df.format(141.1432 *3);
		System.out.println(d);
		return formatter.format( Math.sqrt(Math.pow(a, exponentialFactor)*b));
	}
	
	public static void practiceStack() {
		Stack<Integer> s = new Stack();
		
		Stack<Integer> stack = IntStream.rangeClosed(1,9)//.generate(() -> random.nextInt(100))
        .limit(10) // Generate 10 random numbers
        .boxed()
        .collect(Collectors.toCollection(Stack::new));
		s.push(13);
		 while (!stack.isEmpty()) {
	            System.out.println(stack.pop());
	        }
		 
	}
	
	public static void practiceQueue() {
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> queue = IntStream.rangeClosed(1,9)
		        .limit(10) // Generate 10 random numbers
		        .boxed()
		        .collect(Collectors.toCollection(LinkedList::new));
		
		queue.add(13);
		while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
	}
	
	public static void practiceDequeue() {
		Deque<Integer> dequeue = IntStream.rangeClosed(1,9)//.generate(() -> random.nextInt(100))
		        .limit(10) // Generate 10 random numbers
		        .boxed()
		        .collect(Collectors.toCollection(LinkedList::new));
		int i=0;
		while (!dequeue.isEmpty()) {
			Integer integerToSprint = i%2==0?dequeue.pollFirst():dequeue.pollLast();
            System.out.println(integerToSprint);
            i++;
        }
		
	}
	
	public void mapPractice() {
		String p = "ffdkj fds f ds fds ";
		HashMap<Integer,String> map = new HashMap<>();
		String h = "";
		
		HashSet<Integer> set = new HashSet<>();
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		/*System.out.println(Arrays.toString(createFloatStringArray(10)));
		System.out.println(createFloatStringArrayList(10).toString());
		
		
		System.out.println(practiceMath());
		//practiceStack();
		practiceQueue();
		practiceDequeue();*/
		List<String> list = Arrays.asList(Integer.toString(5425436).split(""));
		Collections.reverse(list);
		
		System.out.println(list.stream().collect(Collectors.joining()));
		
		//System.out.println(Arrays.toString( getRandomStringArray(10)));
	}
	
	

}
