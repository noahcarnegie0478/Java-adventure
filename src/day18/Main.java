package day18;

public class Main {
	public static void main(String[] args) {
	int[] moneyPaper = {500,200,100,50,20,10,5,2,1};
	int cashNumer = findMoneys(moneyPaper, 467);
	System.out.println(cashNumer);
	}
	public static int findMoneys(int[] moneyPaper, int value) {
		int cashNumber = 0;	
		for (int i = 0; i < moneyPaper.length; i++) {		
			if (value / moneyPaper[i] > 0) {
				cashNumber = cashNumber + (value / moneyPaper[i]);
				value = value % moneyPaper[i];		
				
			}		
		}	
		return cashNumber;
	}
	

}
