import java.util.Arrays;

public class ArrayManip {

	public static void main(String[] args) {

		int n = 10;
		int[][] queries = {{1,5,3}, {4,8,7},  {6,9,1}}; 
		System.out.println(arrayManipulation(n, queries, 3));
	}
	
	static long arrayManipulation(int n, int[][] queries, int m) {

		long givenAr[] = new long[n];
		long max = Long.MIN_VALUE;
		Arrays.fill(givenAr, 0);
		
		for(int i=0; i<m; i++)
		{
				for(int j=queries[i][0]; j<=queries[i][1]; j++)
				{
					givenAr[j-1]+=queries[i][2];	
					if(j==m&&max<givenAr[j-1])
						max = givenAr[j-1];
				}
		}
		
//		for(int i=0; i<n-1; i++)
//			if(givenAr[i]>givenAr[i+1])
//			{
//				long temp = givenAr[i];
//				givenAr[i] = givenAr[i+1];
//				givenAr[i+1] = temp;
//			}

		return max;
    }

}
