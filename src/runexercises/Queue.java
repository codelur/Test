package runexercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.NonReadableChannelException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hamcrest.Matcher;

public class Queue  {
	//firstStack will have the elems of the stack
	public Stack<Integer> firstStack;
	//secondStack will be used to retrieve the first elem FIFO
	public Stack<Integer> secondStack;
	AnimalQueue pAnimalQueue = new AnimalQueue();
	public Queue () {
		firstStack = new Stack<Integer>();
		secondStack = new Stack<Integer>();
	}
	
	public int size () {
		return firstStack.size() + secondStack.size();
	}
	
	public void add(Integer value) {
		firstStack.push(value);
	}
	
	public void shiftStacks() {
		if (secondStack.isEmpty()) {
			while(!firstStack.isEmpty()) {
				secondStack.push(firstStack.pop());
			}
				
		}
	}
	
	public Integer peek() {
		shiftStacks();
		return secondStack.peek();
	}
	
	public Integer remove() {
		shiftStacks();
		return secondStack.pop();	
	}
	
	public void sortStack(Stack<Integer> unsorted) {
		Stack<Integer> orderedStack = new Stack<Integer>();
		while (!unsorted.isEmpty()) {
			Integer topInteger = unsorted.pop();
			while(!orderedStack.empty() && orderedStack.peek()>topInteger) {
				unsorted.push(orderedStack.pop());
			}
			orderedStack.push(topInteger);
		}
		while (!orderedStack.empty())
			unsorted.push(orderedStack.pop());
	}
	
	abstract class Animal{
		boolean type;
		int position;
		public Animal(boolean isDog,int position){
			this.type = isDog;
			this.position = position;
		}
		public Animal(boolean isDog) {
			this.type = isDog;
		}
		public boolean isType() {
			return type;
		}
		public void setType(boolean type) {
			this.type = type;
		}
		public int getPosition() {
			return position;
		}
		public void setPosition(int position) {
			this.position = position;
		}
		
	}
	
	public class Dog extends Animal{
		public  Dog() {
			super(true);
		}
	}
	public class Cat extends Animal{
		public  Cat() {
			super(false);
		}
	}
	
	
	
	public class AnimalQueue{
		LinkedList<Animal> dogs;
		LinkedList<Animal> cats;
		private int order = 0;
		
		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order = order;
		}

		public AnimalQueue() {
			// TODO Auto-generated constructor stub
			dogs = new LinkedList<Animal>();
			//dogs.add(new Dog());
			cats = new LinkedList<Animal>();		
		}
		
		public void enqueue(Animal a) {
			a.setPosition(order);
			order++;
			if (a instanceof Dog)
				dogs.add(a);
			if (a instanceof Cat)
				cats.add(a);
				
		}
		//cats and dogs list are always in order
		//RISK: dequeuing an animal will change order
		//if top, all good,
		//if not, assign the other list to the last order
		public Animal dequeueAny() {
			if (dogs.size()==0)
				return this.dequeueCat();
			if (cats.size()==0)
				return this.dequeueDog();
			if (dogs.peek().getPosition()<cats.peek().getPosition())
				return dogs.poll();
			else 
				return cats.poll();
			
		}
		
		public Animal dequeueDog() {
			return dogs.poll();
		}
		
		public Animal dequeueCat() {
			return cats.poll();
		}
	}
	
	
	class entryComparator implements Comparator<Map.Entry<Integer,Integer>> {
	    public int compare(Map.Entry<Integer,Integer> s1, Map.Entry<Integer,Integer> s2)
	    {
	        return  s2.getValue() - s1.getValue();
	    }
	}
	
	class entryComparator2 implements Comparator<Integer> {
	    public int compare(Integer s1,Integer s2)
	    {
	        return  s2 - s1;
	    }
	}
	
	public static int nonDivisibleSubset(int k, List<Integer> s) {
	    // Write your code here
	        for (int i=0;i<s.size();i++)
	            s.set(i, s.get(i)%k);
	            
	        
	        HashSet<Integer> set = new HashSet<>(s);
	        System.out.println(set);
	        int result = 0;
	        for (int i =0;i<set.size();i++){
	            int rest = s.get(i);
	            System.out.println(rest);
	            if (rest == 0 || (k%2 == 0 && rest == k/2)){
	                result++;
	                set.remove(rest);
	            }else{
	                result += Math.max(Collections.frequency(s, rest), 
	                            Collections.frequency(s, k-rest));
	                set.remove(rest);
	                set.remove(k-rest);            
	            }
	            
	        }
	        return result;
	    }
	
	public static void findIndexes(String mainString, String subString) {
        Pattern pattern = Pattern.compile(subString);
        java.util.regex.Matcher matcher = pattern.matcher(mainString);

        System.out.println("Indexes of \"" + subString + "\" in the main string:");

        while (matcher.find()) {
            int startIndex = matcher.start();
            System.out.println("Found at index: " + startIndex);
        }
    }
	
	//The function needs a String "FilePath" that specifies the location of the .txt file
	public static String readPyramid(String filePath) {
		//StringBuffer class has a better performance for appending strings
		//compared to a String Object
		StringBuffer resultBuffer = new StringBuffer();
		//We use a word to store the pair Integer and String of each line of the txt file
        //It'll have O(1) time complexity when accessing the HashMap
        HashMap<Integer, String> dictionary = new HashMap<Integer, String>();
		//We open the txt file for reading
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Read each line until the end of the file
            while ((line = br.readLine()) != null) {            	
            	String[] words = line.split(" ");           	
            	dictionary.put(Integer.parseInt(words[0]), words[1]);
            }
        } catch (IOException e) {
            // Handle any IO exceptions
            e.printStackTrace();
        }
		//count is the variable to use as a key to retrieve the value of an entry in the HashMap
		int count=0;
		//i is the value the will keep track of the number of elems in each row of the pyramid structure
		int i=1;
		while (count<dictionary.size()) {
			count +=i;
			resultBuffer.append(count + ": " + dictionary.get(count) + "\r\n");
			i++;			
		}
		
		return resultBuffer.toString();
	}

	
	public static void main(String[] args)
    {	Queue p = new Queue();
    
    
    int[] resultA = new int[] {1,2,3,4,5};
	System.out.println(resultA[0]);
	List<Integer> resultL = Arrays.stream(resultA).boxed().collect(Collectors.toList());
	System.out.println(resultL.get(0));
	int[] resultB = resultL.stream().mapToInt(Integer::valueOf).toArray();	
	System.out.println(resultB[0]);
	
	String[] resultS = new String[] {"1","2","3","4"};
	System.out.println(resultA[0]);
	List<String> resultSL = Arrays.stream(resultS).collect(Collectors.toList());
	//ArrayList<String> resultSL2 = new ArrayList<String>(resultSL);
	System.out.println(resultSL.get(0));
	String[] resultSB = resultSL.toArray(String[]::new);	
	System.out.println(resultB[0]);
	
    //p.pAnimalQueue.dequeueAny();
    
    
    /*SortedMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>((i1, i2) -> i1.compareTo(i2));
    treeMap.put(1, 2);
	treeMap.put(2,4);	
	treeMap.put(3,3);
	treeMap.put(6,1);
	treeMap.put(5,3);
    
	SortedSet<java.util.Map.Entry<Integer, Integer>> sorted = 
			new TreeSet<>(java.util.Map.Entry.comparingByValue()/*new Comparator<Map.Entry<Integer, Integer>>() {  
	            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {  
	                return  o2.getValue() == o1.getValue()?o1.getKey() - o2.getKey():o2.getValue() - o1.getValue() ;  
	            }  
	        });
	
	sorted.addAll(treeMap.entrySet());  
	//sorted.add(Map.entry(7,0) );
	System.out.println(treeMap); 
	//sorted.remove(sorted.first());
	for (Map.Entry<Integer, Integer> entry : sorted) {  
        System.out.println(entry.getKey() + ": " + entry.getValue());  
    }  
	
	class MyComparator2 implements Comparator<Integer>
	{
	    public int compare( Integer x, Integer y )
	    {
	        return y - x;
	    }
	}

	PriorityQueue minHeap=new PriorityQueue();
	PriorityQueue maxHeap=new PriorityQueue( new MyComparator2());*/
    /*List<Integer> list = new ArrayList<Integer>();
         
    list.add(422346306);
    list.add(940894801);
    list.add(696810740);
    list.add(862741861);
    list.add(85835055);
    list.add(313720373);
    int num = nonDivisibleSubset(9, list);
    System.out.println(num);*/
    //System.out.println(readPyramid("C:\\Users\\codel\\Downloads\\coding_qual_input.txt"));
    /*String string = "02-03-04-05-06-07-";
    String[] list = string.split("-");
    System.out.println(list.length);
    for (String string2 : list) {
		System.out.println(string2);
		
	}
    List<Integer> list2 = new ArrayList<Integer>();
    list2.add(434);
    int[] pIntegers = list2.stream().mapToInt(Integer::new).toArray();
    List<Integer> list3 = Arrays.stream(pIntegers)
    		.boxed().collect(Collectors.toList());;
    		
    		List<Integer> numbers = Stream.iterate(1, n -> n + 1)
                    .limit(9)
                    .collect(Collectors.toList());
    System.out.println(pIntegers[0]);
    int high = 2100000000;
    int low = 2000000000;
    System.out.println(1%3);
    System.out.println("mid using / 2   = " + ((low + high) / 2));
     //System.out.println(n);
    List<String> strings = new ArrayList<String>();
    strings.add("Hola");

    String[] pStrings = strings.toArray(new String[] {});
    List<String> strings2 =  Arrays.asList(pStrings);
    System.out.println(strings2.get(0));
    System.out.println(pStrings[0]);*/
    }
}
