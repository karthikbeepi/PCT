package Midterms;

import java.util.Scanner;

public class KnapSack1 {
	
	int n;
	int values[];
	int weights[];
	int knapsackWt;
	
	int[] T;
	
	public static void main(String[] args) {
		
		KnapSack1 obj = new KnapSack1();
		obj.getInput();
		obj.knapsack(7);
		
	}

	private void knapsack(int t) {
		
		T = new int[t+1];
		T[0] = 0;
		for(int i=1; i<=t; i++)
		{
			int temp = 0;
			for(int j=0; j<n; j++)
			{
				if(i>=weights[j])
				{
					int w = T[i-weights[j]];
					int temp1 = values[j] + w ;
					if(temp<temp1)
					{
						temp = temp1;
					}
				}
			}
			T[i] = temp;
			System.out.println(T[i]);
		}
		
		//System.out.println(T[t]);
		
	}

	private void getInput() {

		Scanner scan = new Scanner(System.in);
		n = Integer.parseInt(scan.nextLine());
		knapsackWt = Integer.parseInt(scan.nextLine());
		values = new int[n];
		weights = new int[n];
		String[] split = scan.nextLine().split(" ");
		int k=0;
		for(int i=0; i<split.length-1; i+=2)
		{
			values[k] = Integer.parseInt(split[i]);
			weights[k] = Integer.parseInt(split[i+1]);
			k++;
		}
	}

}
