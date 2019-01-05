
public class DivisiblePairs {

	static int divisibleSumPairs(int n, int k, int[] ar) {

		int count=0;
		for(int i =0; i<ar.length; i++)
			for (int j=i+1; j<ar.length; j++)
			{
				int temp = ar[i]+ar[j];
				
				if(temp%k==0)
					{count++; System.out.println(ar[i]+ " "+ ar[j]+" : "+temp);}
			}
		return count;

    }
	
	public static void main(String[] args) {

		int[] ar = {45, 12, 43, 23, 21, 89,  34, 56, 90, 81, 47, 17, 41, 29, 24, 87,  31, 58, 93, 80 };
		System.out.println(divisibleSumPairs(20, 7, ar));
		
	}

}
