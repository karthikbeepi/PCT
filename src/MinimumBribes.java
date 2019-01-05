public class MinimumBribes {

	 static void minimumBribes(int[] q) {

		 int i = MinimumBribesP(q);
		 if(i<=0)
			 System.out.println("Too chaotic");
		 else
			 System.out.println(i);

	    }
	
	private static int MinimumBribesP(int[] q) {
		
		for(int i=0; i<q.length-1; i++)
		{
			if(q[i]-q[i+1]<=2&&q[i]-q[i+1]>=0)
			{
				swap(i,i+1, q);
				return 1 + MinimumBribesP(q);
			}
		}
		
		return 0;
		
	}

	private static void swap(int i, int j, int[] q) {
		int temp = q[i];
		q[i] = q[j];
		q[j]= temp;
	}

	public static void main(String[] args) {

		int[] q = {2 ,5 ,1 ,3 ,4};
		int [] p = {2 ,1 ,5 ,3 ,4};
		int[] r = {5 ,1, 2, 3, 7 ,8 ,6 ,4};
		//minimumBribes(q);
		try
		{
			minimumBribes(q);
			minimumBribes(p);
			minimumBribes(r);
			
		}catch(StackOverflowError e)
		{
			System.out.println("Too chaotic");
		}
		
	}

}
