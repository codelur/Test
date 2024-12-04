package runexercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackQuestionsTest {

	@Test
	void testMain() {
		fail("Not yet implemented");
	}
	
	public static int findNumber(int stickA,int stickB) {
		
		/*int left = 1;
		int right = (stickA + stickB) / 4; 
		int result = 0; 
		
		while(left<=right) {
			int mid = left + (right - left)/2;
			//if(mid==0)
			//	break;
			
			int sidesFromA = stickA / mid; 
			int sidesFromB = stickB / mid; 
			if (sidesFromA + sidesFromB >= 4) {
				result = mid;
				left = mid + 1;
			}else {
				right = mid -1;
			}
			
		}
		*/
		
		/*int max = (stickA + stickB) / 4; 
		System.out.println(max);
		if(max == 0) return 0;
		
		while(max>0) {
			int divA = stickA  / max; 
			int divB = stickB  / max; 
			if (divA + divB == 4)
				return max;
			else {
				max--;
			}
		}
		
		return max;*/
		int left = 1;
        int right = (stickA + stickB) / 4; 
        int result = 0;

        while (left <= right) {
            int mid =  (right + left) / 2;

            // Calculate the number of sides we can get from each stick
            int sidesFromA = stickA / mid;
            int sidesFromB = stickB / mid;
            
            // Check if we can get at least 4 equal sides
            if (sidesFromA + sidesFromB >= 4) {
                result = mid; // Update the result
                left = mid + 1; // Look for longer sides
            } else {
                right = mid - 1; // Look for shorter sides
            }
        }

        return result;
	}

	public static void main(String[] args)
    {
		System.out.println(findNumber(300,600));
    }
	

}
