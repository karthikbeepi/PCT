package assignment1;

import java.util.Scanner;

import assignment1.sub.Combo;

public class Assignment2 {
	
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
		sub[] obj = new sub[balance+1];
		for(int i=0; i<=balance; i++)
		{

			obj[i] = new sub();
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
