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
			for(Combo k : obj[i].c)
			{
				k.printCombo(amount);
			}
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
