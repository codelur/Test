package runexercises;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Testing {


	HashMap<Integer, Integer> booksLibrary = new HashMap<Integer, Integer>();
	PriorityQueue<HashMap.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
   );
	Library library;
	public Testing() {
		library =new Library();
	}
	
	public Library getLibrary() {
		return library;
	}
	
   class Library{
	private void handleLibrary(int[] books) {
		Integer max =0;
		for(int elem: books) {
			if(elem>0) {
				if(!booksLibrary.containsKey(elem)) {
					booksLibrary.put(elem, 1);
					Map.Entry<Integer,Integer> entry =
						    new AbstractMap.SimpleEntry<Integer, Integer>(elem, 1);
					pq.add(entry);

				}else {
					int count = booksLibrary.get(elem)+1;
							
					Map.Entry<Integer,Integer> auxEntry2 = 
							new AbstractMap.SimpleEntry<Integer, Integer>(elem, booksLibrary.get(elem));
					System.out.println("auxEntry2 "+auxEntry2.toString());
					pq.remove(auxEntry2);
					Map.Entry<Integer,Integer> auxEntry = new AbstractMap.SimpleEntry<Integer, Integer>(elem, count);
					booksLibrary.put(elem, count);
					pq.add(auxEntry);
					
				}
			}else {
				
				Map.Entry<Integer,Integer> auxEntry = 
						new AbstractMap.SimpleEntry<Integer, Integer>(elem*-1, booksLibrary.get(elem*-1));
				System.out.println("auxEntry "+auxEntry.toString());
				pq.remove(auxEntry);
				booksLibrary.remove(elem*-1);
				max=0;
			}
			System.out.println(booksLibrary.toString());
			System.out.println(pq.toString());
			
			booksLibrary.entrySet()
			  .stream()
			  .sorted(Map.Entry.<Integer, Integer>comparingByKey());
			  
			booksLibrary.entrySet()
			  .stream()
			  .sorted(Map.Entry.<Integer, Integer>comparingByValue());
			
			/*if (booksLibrary.size()==0)
				max=0;
			else {
			for (Map.Entry<Integer, Integer> entry : booksLibrary.entrySet())
			{
			    if (entry.getValue() >max )
			    {
			    	max = entry.getKey();
			    }
			}}*/
			
			max = pq.peek().getKey();

			/*if (booksLibrary.size()==0)
				max=0;
			else 
				max =  Collections.max(booksLibrary.entrySet(), Map.Entry.comparingByValue()).getKey();*/

			System.out.println(max);
		}
	}
   }
	public static void main(String[] args) {
		int[]  books = {2,2,6,6,6,6,-6,6,-2,-6,-6,-6};
	//new Testing().getLibrary().handleLibrary( books);
		/*Map<Integer, Integer> booksLibraryTion = new HashMap<Integer, Integer>();
		booksLibraryTion.put(1, 10);
		booksLibraryTion.put(80, 2);
		booksLibraryTion.put(4, 1);
		booksLibraryTion.put(6, 4);
		
		/*Map<Integer, Integer> sorted = 
				booksLibraryTion.entrySet()
		  .stream()
		  .sorted(Map.Entry.<Integer, Integer>comparingByKey())
		  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
	                LinkedHashMap::new));
		
*/
		/*SortedSet<Integer> values = new TreeSet<>(booksLibraryTion.keySet());
		System.out.println(values); 
		booksLibraryTion.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue())
		  .forEach(System.out::println);

		*/
//		TreeMap<Integer, String> treemap = new TreeMap<Integer, String>(); 
//	       
//		  // assigning the values in the tree map 
//		  // using put() 
//		  treemap.put(2, "two"); 
//		  treemap.put(7, "seven"); 
//		  treemap.put(3, "three"); 
//		     
//		  // Use of ceilingEntry() 
//		  // returns 7=seven ( next greater key-value) 
//		  System.out.println("The next greater key-value of 5 is : " + treemap.ceilingEntry(5)); 
//		  Random rand = new Random(); 
//	      // Setting the upper bound to generate the
//	      // random numbers in specific range
//	      int upperbound = 25;
//	      // Generating random values from 0 - 24 
//	      // using nextInt()
//	      int int_random = rand.nextInt(upperbound); 
//		//System.out.println(sorted.toString());
		String rtString = "hdkjhfkjsdh".substring(0,1);
		Integer[] geek =new Integer[9];
		Arrays.fill(geek,0);
// Conversion of array to ArrayList
// using Arrays.asList
List<Integer> al = Collections.nCopies(4, 4);

String[] geeks = {"Rahul", "Utkarsh",
        "Shubham", "Neelam"};

List<String> a2 =
new ArrayList<String>(Arrays.asList(geeks));
System.out.println(al);

System.out.println(al);

		double p = 1/4.0;
		Double g = Math.pow(100, p);
		Integer i = (int) Math.round(g);
		
		}
	
}	
	
	



