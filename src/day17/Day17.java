package day17;
import java.util.*;

public class Day17 {
	
	//exercise 1
public static int exerciseOneSolution(ArrayList<Integer> array, int left, int right) {
		
		int result = 0;
		HashMap<Integer, Integer> leftAndRight = new HashMap<>();
		//make collection
		for (int i = 0; i < array.size(); i++) {
			
			if (array.get(i) == left | array.get(i) == right) {
				if (leftAndRight.get(left) != 0 || leftAndRight.get(right) != 0) {
					checkNative(left, right, array);
					
				}
			}
			
			
			
		}
		
		
		//filter
		
		
		return result;
	}
	
	
	public static int checkNative(int left, int right, ArrayList<Integer> array) {
		ArrayList<Integer> newArray = new ArrayList<>(Math.max(right,left) + 1);
		int result = -1;
		int i = Math.min(right, left);
		int j = 0;
		
		do {
			
			
			
		} while (i < Math.max(right, left) + 1);
		
		return result;
		
	}
	
	
	
	
	
	
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
		
		ArrayList<Integer> exerciseOneArray = new ArrayList<Integer>(Arrays.asList(2, 1, 4, 3, 2, 1, 1, 4));
		
		int leftNumber = 2;
		int rightNumber = 4;
		
		int resultExOne = exerciseOneSolution(exerciseOneArray, leftNumber, rightNumber);
		
		
		
		
		
		//exercise 2
		ArrayList<Integer> exerciseTwoArray = new ArrayList<Integer>(Arrays.asList(5,2,5,5,7,6,2,5));
		
		int resultExTwo = exerciseTwoSolution(exerciseTwoArray);
		
		System.out.println(resultExTwo);
		
	}
	
	
	
	

}
