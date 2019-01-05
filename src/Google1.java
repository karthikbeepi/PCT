
public class Google1 {

	public static int solution(int[] A) {
     
		int reached=0;
		int endOfArray=0;
		for(int i=0; i<A.length; i++)
		{
			endOfArray = i;
			do
			{
				endOfArray = jumpOdd(A, endOfArray);
				endOfArray = jumpEven(A, endOfArray);
			}while(endOfArray<A.length-1);
			
			if(endOfArray==A.length)
				reached++;
		}
		
		return reached;
		
    }

	private static int jumpEven(int[] a, int i) {
		int endPos=i;
		int maximum = Integer.MIN_VALUE;
		for(int pos= i; pos<a.length; pos++)
		{
			int k=3;
			while(pos+k<a.length)
			{
				int temp = a[pos+k]-a[pos];
				if(temp > maximum)
				{
					maximum = temp;
					endPos = pos+k;
				}
				
				k+=2;

			}
			if(pos+k>=a.length)
				return pos+k;
		}
		
		return endPos;
	}

	private static int jumpOdd(int[] a, int i) {
		
		int endPos=i;
		int minimum = Integer.MAX_VALUE;
		for(int pos= i; pos<a.length; pos++)
		{
			int k=2;
			while(pos+k<a.length)
			{
				int temp = a[pos+k]-a[pos];
				if(temp < minimum)
				{
					minimum = temp;
					endPos = pos+k;
				}
				
				k+=2;

			}
			if(pos+k>=a.length)
				return pos+k;
		}
		
		return endPos;
	}

	public static void main(String[] args) {

		int[] A = {10,13,12,15};
		int[] B = {10,15, 12, 13};
		System.out.println(solution(A));
		System.out.println(solution(B));
	}

}
