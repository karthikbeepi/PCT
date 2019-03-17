package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
	
	class Combo
	{
		ArrayList<Integer> c = new ArrayList<>();
		public Combo(ArrayList<Integer> g) {
			c=g;
		}
	}

	public static void main(String[] args) {

		Assignment2 obj = new Assignment2();
		obj.getInput();
		
	}

	private void getInput() {
		int numberOfDataset;
		Scanner scan = new Scanner(System.in);
		numberOfDataset = Integer.parseInt(scan.nextLine());
		for(int i=0; i<numberOfDataset; i++)
		{
			String[] sp = scan.nextLine().split(" ");
			int periods = Integer.parseInt(sp[0]);
			int amount = Integer.parseInt(sp[1]);
			int balance = Integer.parseInt(sp[2]);
			findVal(periods, amount, balance);
			printMinCost();
		}
	}

	private void printMinCost() {
		// TODO Auto-generated method stub
		
	}

	private void findVal(int periods, int amount, int balance) {
		
		ArrayList<Combo>[] values = new ArrayList[balance];
		
		for(int j=0; j<balance; j++)
		{
			values[j] = new ArrayList<Combo>();
		}
			
		for(int i)
		
	}

}
