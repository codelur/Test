package com.interview.all;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Strings {
	
	public String findShortest(String[] array) {
		
		if(array.length==1) return array[0];
		
		StringBuilder result = new StringBuilder();
		
		Arrays.sort(array);
		String first = array[0];
		String last = array[array.length-1];
		for (int i=0;i<first.length();i++) {
			if (first.charAt(i) == last.charAt(i))
				result.append(first.charAt(i));
			else
				break;
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList(Integer.toString(123456789).split(""));
		
		
		System.out.println(list.stream().collect(Collectors.joining()));

	}

}
