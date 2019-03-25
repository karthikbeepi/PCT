package assignment1;

import java.util.ArrayList;
import java.util.Scanner;


public class Assignment2 {
	
	class Combo{
		int[] ar;
		Combo(int[] a)
		{
			ar = a;
		}
		void printCombo(int amt){
			for(int i: ar)
				System.out.print(i+amt+" ");
			System.out.println();
			System.out.println(valOfCombo(amt));
		}
		int valOfCombo(int amt)
		{
			int val =0;
			for(int i: ar)
			{
				val+=costOfNumber(i+amt);
			}			
			return val;
		}
		private int costOfNumber(int i) {
			
			int cost=0;
			if(i<10)
			{
				return costOfDigit(i);
			}
			else if(i<100)
			{
				cost += costTenDigit(i);
				return cost;
			}
			else if(i<1000)
			{
				cost += costOfDigit(i/100);
				cost += "HUNDRED".length();
				System.out.println("HUNDRED");
				cost += costOfNumber(i%100);
			}
			else if(i<10000)
			{
				cost += costOfDigit(i/1000);
				cost += "THOUSAND".length();
				System.out.println("THOUSAND");
				cost += costOfNumber(i%1000);
			}
			else if(i<100000)
			{
				cost += costOfNumber(i/1000);
				cost += "THOUSAND".length();
				System.out.println("THOUSAND");
				cost += costOfNumber(i%1000);
				return cost;
			}
			return -1;
		}
		private int costTenDigit(int i) {
			switch(i)
			{
			case 10: 
				System.out.println("TEN");
				return "TEN".length();
			case 11: 
				System.out.println("ELEVEN");
				return "ELEVEN".length();
			case 12: 
				System.out.println("TWELVE");
				return "TWELVE".length();
			case 13: 
				System.out.println("THIRTEEN");
				return "THIRTEEN".length();
			case 14: 
				System.out.println("FOURTEEN");
				return "FOURTEEN".length();
			case 15: 
				System.out.println("FIFTEEN");
				return "FIFTEEN".length();
			case 16: 
				System.out.println("SIXTEEN");
				return "SIXTEEN".length();
			case 17: 
				System.out.println("SEVENTEEN");
				return "SEVENTEEN".length();
			case 18: 
				System.out.println("EIGHTEEN");
				return "EIGHTEEN".length();
			case 19: 
				System.out.println("NINETEEN");
				return "NINETEEN".length();			
			}
			if(i<30)
			{
				int cost = "TWENTY".length();
				System.out.println("TWENTY");
				cost += costOfDigit(i%10);
				return cost;
			}
			else if(i<40)
			{
				int cost = "THIRTY".length();
				System.out.println("THIRTY");
				cost += costOfDigit(i%10);
				return cost;
			}
			else if(i<50)
			{
				int cost = "FORTY".length();
				System.out.println("FORTY");
				cost += costOfDigit(i%10);
				return cost;
			}
			else if(i<60)
			{
				int cost = "FIFTY".length();
				System.out.println("FIFTY");
				cost += costOfDigit(i%10);
				return cost;
			}
			else if(i<70)
			{
				int cost = "SIXTY".length();
				System.out.println("SIXTY");
				cost += costOfDigit(i%10);
				return cost;
			}
			else if(i<80)
			{
				int cost = "SEVENTY".length();
				System.out.println("SEVENTY");
				cost += costOfDigit(i%10);
				return cost;
			}
			else if(i<90)
			{
				int cost = "EIGHTY".length();
				System.out.println("EIGHTY");
				cost += costOfDigit(i%10);
				return cost;
			}
			else
			{
				int cost = "NINETY".length();
				System.out.println("NINETY");
				cost += costOfDigit(i%10);
				return cost;
			}
		}
		private int costOfDigit(int i) {
			switch(i)
			{
			case 0: 
				System.out.println("ZERO");
				return 0;
			case 1: 
				System.out.println("ONE");
				return "ONE".length();
			case 2: 
				System.out.println("TWO");
				return "TWO".length();
			case 3: 
				System.out.println("THREE");
				return "THREE".length();
			case 4: 
				System.out.println("FOUR");
				return "FOUR".length();
			case 5: 
				System.out.println("FIVE");
				return "FIVE".length();
			case 6: 
				System.out.println("SIX");
				return "SIX".length();
			case 7: 
				System.out.println("SEVEN");
				return "SEVEN".length();
			case 8:
				System.out.println("EIGHT");
				return "EIGHT".length();
			case 9: 
				System.out.println("NINE");
				return "NINE".length();
			}
			return i;
		}
	}
	
	ArrayList<Combo> c = new ArrayList<Combo>();
	
	public void CombinationRepetitionUtil(int chosen[], int arr[], int index, int r, int start, int end) { 
		int sum=0;
		for(int i=0; i<index; i++)
		{
			sum+=arr[chosen[i]];
			if(sum<0)
				return;
		}
		if (index == r ) { 
			if(sum==0)
			{
				int temp[] = new int[r];
				if(arr[chosen[0]]==arr[0]||arr[chosen[r-1]]==arr[arr.length-1]) 
				{
					for (int i = 0; i < r; i++) { 
						temp[i] = arr[chosen[i]];						
					} 
					c.add(new Combo(temp));
				}
			}
			return; 
		} 

		// One by one choose all elements (without considering 
		// the fact whether element is already chosen or not) 
		// and recur 
		for (int i = start; i <= end; i++) { 
			chosen[index] = i; 
			CombinationRepetitionUtil(chosen, arr, index + 1,r, i, end); 
		} 
		return; 
	} 

//The main function that prints all combinations of size r 
//in arr[] of size n with repitions. This function mainly 
//uses CombinationRepetitionUtil() 
	public void CombinationRepetition(int arr[], int n, int r) { 
		int chosen[] = new int[r + 1]; 
		CombinationRepetitionUtil(chosen, arr, 0, r, 0, n - 1); 
		
	} 
	
	public static void main(String[] args) {
		Assignment2 obj = new Assignment2();
		obj.getInput();
	}

	private void getInput() {
		int numberOfDataset=1;
		Scanner scan = new Scanner(System.in);
		numberOfDataset = Integer.parseInt(scan.nextLine());
		for(int i=0; i<numberOfDataset; i++)
		{
			String[] sp = scan.nextLine().split(" ");
			int periods = Integer.parseInt(sp[0]);
			int amount = Integer.parseInt(sp[1]);
			int balance = Integer.parseInt(sp[2]);
			findVal(periods, amount, balance);
			//printMinCost();
		}
		scan.close();
	}

	private void findVal(int periods, int amount, int balance) {
		Assignment2[] obj = new Assignment2[balance+1];
		for(int i=0; i<=balance; i++)
		{

			obj[i] = new Assignment2();
			int arr[] = makeArray(i);
			obj[i].CombinationRepetition(arr, arr.length, periods);
			int lowestCost = Integer.MAX_VALUE;
			for(Combo k : obj[i].c)
			{
//				k.printCombo(amount);
//				System.out.println(k.valOfCombo(amount));
				int temp = k.valOfCombo(amount);
				if(lowestCost>temp)
					lowestCost = temp;
			}
			System.out.println(lowestCost);
		}
	}

	private int[] makeArray(int i) {
		int[] ar = new int[2*i+1];
		for(int j=0; j<ar.length; j++)
		{
			ar[j] = i--;
		}
		return ar;
	}
}
