package PCTCodingNew;

import java.util.Scanner;

public class MaxSumSubSeq {

	int n;
	int[] ar;
	
	public static void main(String[] args) {
		MaxSumSubSeq obj = new MaxSumSubSeq();
		obj.getInput();
	}

	private void getInput() {
		Scanner scan = new Scanner(System.in);
		int noOfTest = Integer.parseInt(scan.nextLine());
		for(int i=0; i<noOfTest; i++)
		{
			String sp[] = scan.nextLine().split(" ");
			n = sp.length;
			ar = new int[n];
			for(int j=0; j<n; j++)
				ar[j] = Integer.parseInt(sp[j]);
			findMaxSubSeq();
		}
	}

	private void findMaxSubSeq() {
		
		int maxSumIncluded[] = new int[n];
		
		for(int i=0; i<n; i++)
		{
			int tempSum=0;
			for(int j=i-1; j>=0; j--)
			{
				if(ar[i]>ar[j])
				{
					tempSum+=maxSumIncluded[j];
					break;
				}
			}
			tempSum+=ar[i];
			maxSumIncluded[i] = tempSum;
		}
		System.out.println(maxSuminArray(maxSumIncluded));
	}

	private int maxSuminArray(int[] maxSumIncluded) {
		int max = Integer.MIN_VALUE;
		for(int i: maxSumIncluded)
			if(i>max)
				max = i;
		return max;
	}

}
