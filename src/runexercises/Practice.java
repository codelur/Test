package runexercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.CharacterConversion;

import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.LinkedList;

public class Practice {
	
	public static int numSquaresDP(int n, int[] perfectSquares) {
        if(n<0)
            return 0;
        
        if(perfectSquares[n]!=-1)
            return perfectSquares[n];
        
        	
        int min = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            min = Math.min(min,1+numSquaresDP(n-(i*i),perfectSquares));
            
        }
        return perfectSquares[n] = min;
    }
	
	public static String solution(String notation) {
	    int[] indexInRow = new int[8];
	    String[] currentNotation = notation.split("/");
	    String[] result = new String[8];
	    Arrays.fill(result, "");
	    for (int j=0;j<8;j++){
	        for (int i=currentNotation.length-1;i>=0;i--){
	            Character c = currentNotation[i].charAt(indexInRow[i]);
	            if(Character.isDigit(c)){
	                Integer numOfEmpties = Integer.parseInt(c+"");
	                
	                //update the string of the original chess board
	                if(numOfEmpties==1){
	                    //currentNotation[i] = currentNotation[i].substring(1);
	                    indexInRow[i]++;
	                }
	                else{
	                    numOfEmpties--;
	                    currentNotation[i] = currentNotation[i].substring(0,j) + 
	                    		numOfEmpties + currentNotation[i].substring(j+1);
	                }
	                
	                //update the string of the result
	                if(result[j].length()==0){
	                    result[j] ="1";
	                }else {
	                    Character lastCharacterInResult = result[j].charAt(result[j].length()-1);
	                    if(Character.isDigit(lastCharacterInResult)){
	                        Integer lastNumberInResult = Integer.parseInt(lastCharacterInResult+"")+1;
	                        result[j] = result[j].substring(0,result[j].length()-1) + lastNumberInResult;
	                    }else{
	                        result[j] += "1";
	                    }
	                }
	            
	            //add a character at the end    
	            }else{
	                result[j] += c;
	                indexInRow[i]++;
	            }

	        }
	    }
	    
	    return "";
	}  
	
	
	
	
	public static void main(String[] args)
	{
		String[] stringArray = {"", "one ", "two ", "three ", "four ", 
				"five ", "six ", "seven ", "eight ", "nine ","ten "};
		
		int[] intArray = {1,2,3,4,5,6,7,8};
		
		List<String> stringArrayList = Arrays.stream(stringArray).collect(Collectors.toList());
		
		List<Integer> integerArrayList = Arrays.stream(intArray).boxed().toList();
		
		int[] intArrayBack = integerArrayList.stream().mapToInt(Integer::valueOf).toArray();
		

		System.out.println(Character.compare('b', 'a'));
		
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		
		//solution("2kr3r/pp1nbppp/3p1n2/q1pPp1B1/4P1b1/2N2N2/PPP1BPPP/R2Q2RK");
		//System.out.println("tdsg".substring(0,-1));
	
	}
}
