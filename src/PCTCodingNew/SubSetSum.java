package PCTCodingNew;

import java.util.Scanner;

public class SubSetSum {

	int n;
	int ar[];
	int sum;
	
	public static void main(String[] args) {

		SubSetSum obj = new SubSetSum();
		obj.getInput();
		
	}

	private void getInput() {
		Scanner scan = new Scanner(System.in);
		int noOfDataSets = Integer.parseInt(scan.nextLine());
		for(int i=0; i<noOfDataSets; i++)
		{
			String[] sp = scan.nextLine().split(" ");
			n = Integer.parseInt(sp[0]);
			sum = Integer.parseInt(sp[1]);
			ar = new int[n];
			sp = scan.nextLine().split(" ");
			for(int k=0; k<n; k++)
				ar[k] = Integer.parseInt(sp[k]);
			findSubSetSum();
		}
	}

	private void findSubSetSum() {
		int mat[][] = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=i+1; j<n; j++)
			{
				for(int k=i; k<=j; k++)
				{
					mat[i][j] += ar[k];
				}
			}
		
		for(int i=0; i<n; i++)
			for(int j=i+1; j<n; j++)
			{
				if(mat[i][j]==sum)
					System.out.println((i+1)+" "+(j+1));
			}
	}


}
