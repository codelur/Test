package com.interview.all;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class convertLists {
	List<String> stringList;
	List<Integer> integerList;
	
	String[] stringArray;
	int[] integerArray;
	
	public convertLists() {
		stringList = Arrays.asList("a","b","c","d","e");
		integerList = Arrays.asList(1,2,3,4,5,6,7);
		
		stringArray = new String[]{"a","b","c","d","e"};
		integerArray  = new int[]{1,2,3,4,6,7,5};
	}
	
	public int[] integerListToArray() {
		return integerList
				.stream()
				//map if 
				.mapToInt(Integer::intValue)
				.toArray();
	}
	
	public Integer[] integerObjectListToArray() {
		return integerList
				.toArray(new Integer[0]);
	}
	
	public List<Integer> integerArrayToList() {
		 
		List<Integer> list =Arrays
		.stream(integerArray)
		//boxed for Integers
		.boxed()
		.collect(Collectors.toList());
		
		list.sort((a,b)-> a.compareTo(b));
		return list;
				
	}
	
	public String[] stringListToArray() {
		return stringList
				.toArray(new String[0]);
	}
	
	public List<String> stringArrayToList() {
		return 
				Arrays
				.stream(stringArray)
				.collect(Collectors.toList());
	}
	
	public static String timeInWords(int h, int m) {
	    // Write your code here
		String[] minutesStrings = {"", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ","ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "quarter ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};
		java.time.LocalDate today = java.time.LocalDate.of(2020, 12, 1);
		//java.time.Month.valueOf(null)
		
		
		java.time.LocalDate date = java.time.LocalDate.of(2020,2,4);
		//int p = java.time.DayOfWeek.valueOf(date.getDayOfWeek().get);
		//java.time.DayOfWeek
	        int nextHour = h+1;
	        switch(m){
	            case 0:
	                return minutesStrings[h] + "o' clock";
	            case 15:
	                return minutesStrings[m] + "past " +minutesStrings[h];    
	            case 30:
	                return "half past " + minutesStrings[h];
	            case 45:
	                return minutesStrings[60-m] + "to " + minutesStrings[nextHour];   
	            default:
	                if(m<30) {
	                    if(m<20)
	                        return minutesStrings[m] + (m==1?"minute":"minutes") +
	                                    " past "+minutesStrings[h];
	                    else
	                        return "twenty " + minutesStrings[m%20] + (m==1?"minute":"minutes") +
	                                    " past "+minutesStrings[h];
	                }else{
	                    int minutesToHour = 60 - m;
	                    if(minutesToHour<20)
	                        return minutesStrings[minutesToHour] + (m==1?"minute":"minutes") +
	                                    " to "+minutesStrings[nextHour];
	                    else
	                        return "twenty " + minutesStrings[minutesToHour%20] + (m==1?"minute":"minutes") +
	                                    " to "+minutesStrings[nextHour];
	                }
	        }
	        
	            
	    }

	public static void main(String[] args)
	{
		
		int[] numbers = {3, -2, 1, -1, 2, -3};

		
				
        Optional<Integer> closestToZero = IntStream.of(numbers)
            .boxed()
            .min(Comparator.comparingInt((Integer n) -> Math.abs(n))
                           .thenComparing(n -> -n));

        closestToZero.ifPresentOrElse(
            System.out::println,
            () -> System.out.println("Array is empty")
        );
	}
}
