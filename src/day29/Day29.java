package day29;

import java.util.ArrayList;

public class Day29 {
	
	public static void main(String[] args) {
		BSTree service = new BSTree();
		//----------------- Ticket home work -----------------------------------------
		int[] days = {1,2,4,5,7,29,30};
		int result = solutionTickets(days);
		System.out.println("result: " + result);	
		//----------------------------------------------------------------------------
		
		//------------------ Minimum hour home work ----------------------------------
		int[] times = {1,2,4,5,7,8};
		String minimumHour = solutionMinimumHour(times);
		System.out.println("Final hour is: " + minimumHour);
		
		//----------------------------------------------------------------------------
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
				if ( toBeSeven.size() >= 2 && toBeSeven.get(1) + 6 >= array[i]) {
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
	public static String solutionMinimumHour(int[] times) {
		BSTree service = new BSTree();
		BE8Node root = service.bstBuild(times);
		service.printByRecursion(root);
		int[] countRight = {0};
		int[] countLeft = {1};
		service.insertArray(root.right, countRight, times);
		service.insertArray(root.left, countLeft, times);
		
		if (countRight[0] < 6) {
			times[1] = root.value;
		}
		else if (countLeft[0] < 5) {
			times[0] = times[2];
			times[2] = times[4];
			times[4] = root.value;
		}
		
		for (int i : times) {
			System.out.println(i);
		}
		String mainHour = " " + times[0] +  times [1] + ":" + times[2] +  times [3] + ":" + times[4] +  times [5];
		return mainHour;
	}
}
