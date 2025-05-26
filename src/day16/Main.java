package day16;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arrayA = new ArrayList<>(Arrays.asList(5,4,1,2,6,5,1)) ;
		ArrayList<Integer> arrayB = new ArrayList<>(Arrays.asList(2)) ;
		
		int result = Solution(arrayA, arrayB);
		System.out.println(result);
		
	}
	
	public static int Solution(ArrayList<Integer> arrayA, ArrayList<Integer> arrayB ) {
		if ( arrayA.size() > arrayB.size() * 6 || arrayB.size() >  arrayA.size() * 6) {
			
			return -1;
		}
		ArrayList<Integer> newArrayA = new ArrayList<Integer>(arrayA);
		ArrayList<Integer> newArrayB = new ArrayList<Integer>(arrayB);
		Collections.sort(newArrayA);
		Collections.sort(newArrayB);
		
		int sumA = sumCaculator(newArrayA);
		int sumB = sumCaculator(newArrayB);
		
		if (sumA > sumB) {
			return comparationMethod(sumA -sumB, newArrayA, newArrayB);
		}
		else {
			return comparationMethod(sumB -sumA, newArrayB, newArrayA);
		}
		
		
	}
	
	
	public static int sumCaculator(ArrayList<Integer> array) {
		
		int sum = 0;
		for (int i = 0; i < array.size(); i++) {
			sum = sum + array.get(i);
		}
		return sum;
		
	}
public static void printArray(ArrayList<Integer> array, String content) {
		for (int i = 0; i < array.size(); i++) {
			System.out.println(content + array.get(i));
		}
		
		
	}
	
	public static int comparationMethod( int value, ArrayList<Integer> bigger,ArrayList<Integer> smaller ) {
		int count = 0;
		
		if (value > smaller.size() * 6 || bigger.size() == (smaller.size() * 6)) {
			for (int i = 0; i < smaller.size(); i++) {
				if (smaller.get(i ) != 6 ) {
					smaller.set(i,6);
					count = count +1;
//					System.out.println("count : " + count);
				}
			}
			
			value = smaller.size()*6;
			
		}
		
		int index = 0;
		
		int biggerLength = bigger.size() - 1 ;
		do {
		
			if (bigger.get(biggerLength - index) != 1) {
				if (bigger.size() == (smaller.size() * 6)) {
//					System.out.println("run");
//					System.out.println("index value : " + bigger.get(biggerLength - index));
					count +=  1;
					value = value -1;
//					System.out.println("count : " + count);
					
					
				}
				else if (value >= bigger.get(biggerLength - index)) {
					count = count + 1;
					value =  value - (bigger.get( biggerLength -  index) - (bigger.get(biggerLength -  index) - 1));
//					System.out.println(count);
				}
				
				else {
					count = count + 1;
					value = value - bigger.get( biggerLength -  index);
//					System.out.println("count : " + count);
				}
			}
			index++;
		} while (value > 0 && index < biggerLength );
		return count;
	}
	
	
}
