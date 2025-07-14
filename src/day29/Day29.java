package day29;

import java.util.ArrayList;

public class Day29 {
	
	public static void main(String[] args) {
//		int[] days = {1,2,4,5,7,29,30};
		int[] days = {1,3,4,6,8,9,10,18,19,26,27,29,30};
		int result = solutionTickets(days);
		System.out.println("result: " + result);
		
		
		
	}
	//Time = On Space = On
	public static int solutionTickets(int[] array) { 
		int result = 0;
		if (array.length <= 3) return 2 * array.length;
		if (array.length > 25) return 25;
		int maxOfRange = array[0] + 6;
		ArrayList<Integer> toBeSeven = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= maxOfRange) toBeSeven.add(array[i]);
			else {
				if (toBeSeven.get(1) + 6 >= array[i]) {
					toBeSeven.remove(0);
					maxOfRange = toBeSeven.get(0) + 6;
					result = result + 2;
					toBeSeven.add(array[i]);
				}
				else {
					if (toBeSeven.size() > 3) result  = result + 7;
					else result = result + toBeSeven.size() * 2;
					if (array[i] + 6 >= 30 ) {
						if (array.length - i  > 3) {		
							return result + 7;
						}else {
							return result + 2 * (array.length - i );
						}	
					}
					toBeSeven.clear();
					maxOfRange = array[i] + 6;
					toBeSeven.add(array[i]);
					
				}
			}

		}
		return result;
	}

}
