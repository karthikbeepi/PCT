package grap;

import java.util.Scanner;

public class TA2 {
	
	public static void main(String args[])
	{
		TA2 ob = new TA2();
		ob.getInput();
	}

	private void getInput() {
		
		Scanner scan = new Scanner(System.in);
		int noofDataset = Integer.parseInt(scan.nextLine());
		for(int i=0; i<noofDataset; i++)
		{
			String[] sp = scan.nextLine().split(" ");
			int n = Integer.parseInt(sp[0]);
			int amt = Integer.parseInt(sp[1]);
			int bal = Integer.parseInt(sp[2]);
			find(n, amt, bal);
		}
		scan.close();
		
	}

	private void find(int n, int amt, int bal) {
		
		int T[][] = new int[amt+bal+1][n+1];
		for(int i=0; i<=amt+bal; i++)
		{
			if()
		}
		
	}

}
