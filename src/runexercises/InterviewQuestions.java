package runexercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class InterviewQuestions {

	
	private  boolean allUnique(String s) {
		boolean result = true;
		for(int i=0;i<s.length()-1 ;i++) {
			char letter = s.charAt(i);
			String chain = s.substring(i+1);
			System.out.println(chain);
			if (chain.indexOf(letter)!= -1) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	private static boolean arePermutations(String a,String b) {
		if (a.length()!=b.length())
			return false;
		
		Map<Character, Integer> lettersMap = new HashMap<Character, Integer>();
		
		for (int i = 0; i<a.length();i++) {
			Character letterCharacter = a.charAt(i);
			if (lettersMap.containsKey(letterCharacter)) {
				lettersMap.put(letterCharacter, lettersMap.get(letterCharacter)+1);
			}else {
				lettersMap.put(letterCharacter, 1);
			}
		}
		
		for (int i = 0; i<b.length();i++) {
			Character letterCharacter = b.charAt(i);
			if (!lettersMap.containsKey(letterCharacter))
				return false;
			else {
				if(lettersMap.get(letterCharacter) ==1)
					lettersMap.remove(letterCharacter);
				else {
					lettersMap.put(letterCharacter, lettersMap.get(letterCharacter)-1);
				}
			}
		}
		
		return lettersMap.isEmpty();		
	}
	
	private static boolean isPermOfPalind(String s) {
		ArrayList<Character> letters = new ArrayList<Character>();
		for (int i = 0; i<s.length();i++) {
			Character letterCharacter = s.charAt(i);
			if (!letters.contains(letterCharacter)) 
				letters.add(letterCharacter);
			else
				letters.remove(letterCharacter);
			
		}
		return letters.size() ==0 || letters.size()==1;
	}
	
	private static String compressString(String s) {
		StringBuilder resultString = new StringBuilder();
		int letterCount = 0;
		for (int i = 0; i<s.length();i++) {
			Character letterCharacter = s.charAt(i);
			letterCount++;
			if(i+1>=s.length() || letterCharacter!=s.charAt(i+1)) {
				resultString.append(letterCharacter);
				resultString.append(letterCount);
				letterCount=0;
			}
		}
		
		return resultString.length()==s.length()?s:resultString.toString();
		
	}
	
	public static void main(String[] args) {
		String a = "aerttafra";
		
		String b = "aerttafra".chars()
			      .sorted()
			      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			      .toString();
		
		//System.out.println(compressString("aiiaiii"));
		
		LinkedList list = new LinkedList();
        for (int i = 0; i < 8; i++) {
			list.add(i);		
		}
        if (list.size() % 2 == 0)
        	list.remove(list.size()/2 -1);
        else {
        	list.remove(list.size()/2 );
		}
        System.out.println(list.toString());
	}
}
