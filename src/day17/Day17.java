package day17;
import java.util.*;

public class Day17 {
	
	//exercise 1
	
	
	
	
	
	
	
	//exercise 2 -  Time Complexity =  On - Space Complexity = O2n + 2
	
	public static int exerciseTwoSolution(ArrayList<Integer> array) {
		int result = 0;
		HashMap<Integer, Integer> uniqueValue = new HashMap<>();
		
		for (int i = 0; i < array.size(); i++) {
			
			
			if (!uniqueValue.containsKey(array.get(i))) {
				uniqueValue.put(array.get(i), i);
			}
			else {
				result = Math.max(result, i - uniqueValue.get(array.get(i)));				
			}			
		}
		return result;
	}
	
	
	
	//main 
	
	public static void main(String[] args) {
		
		//exercise 1
		//[2, 1, 4, 3, 2, 1, 1, 4]
		//L = 2 and R = 4, 
		//expected output  = 3
		
		
		
		//exercise 2
		ArrayList<Integer> exerciseTwoArray = new ArrayList<Integer>(Arrays.asList(5,2,5,5,7,6,2,5));
		
		int resultExTwo = exerciseTwoSolution(exerciseTwoArray);
		
		System.out.println(resultExTwo);
		
	}
	
	
	
	

}
