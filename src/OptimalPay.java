import java.util.Scanner;

public class OptimalPay {

	int noOfDenom;
	int[] denom;
	int amount;
	int[] vals;
	int[][] countVal;
	
	public static void main(String[] args) {

		OptimalPay obj = new OptimalPay();
		obj.getInput();
	
	}

	private void getInput() {
		Scanner scan = new Scanner(System.in);
		noOfDenom = Integer.parseInt(scan.nextLine());
		denom = new int[noOfDenom];
		String[] sp = scan.nextLine().split(" ");
		for(int i=0; i<noOfDenom; i++)
			denom[i] = Integer.parseInt(sp[i]);
		amount = Integer.parseInt(scan.nextLine());
		vals = new int[amount+1];
		countVal = new int[amount+1][noOfDenom];
		for(int i=0; i<=amount; i++)
			findOptimal(i);
		for(int j=0; j<noOfDenom; j++)
			System.out.print(denom[j]+" : "+countVal[amount][j]+" ");
		System.out.println();
	}

	private int findOptimal(int amt) {
		int min = 999;
		if(amt<0)
			return 99999;
		if(amt==0)
		{
			vals[amt] = 0;
			for(int i=0; i<noOfDenom; i++)
				countVal[amt][i] = 0;
			return 0;
		}
		for(int i=0; i<noOfDenom; i++)
		{
			int temp = 999;
			if(amt-denom[i]>=0)
				temp = 1 + vals[amt-denom[i]];
			if(temp<min)
			{
				min = temp;
				for(int j=0; j<noOfDenom; j++)
					if(amt-denom[i]>=0)
						countVal[amt][j] = countVal[amt-denom[i]][j];
				countVal[amt][i]++;
			}
			
		}
		vals[amt] = min;
		return min;
	}
}
