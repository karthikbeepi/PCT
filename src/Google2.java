import java.util.Arrays;

public class Google2 {

	 public static int solution(int[] S, int[] E) {
		 int maxTime = findMaxTime(E);
		 int maxNoOfChairs=0;
		 for(int time=1; time<=maxTime; time++)
		 {
			 int noOfChairs =0;
			 for(int j=0; j<S.length; j++)
			 {
				 if(S[j]<=time)
					 noOfChairs++;
				 if(E[j]<=time)
					 noOfChairs--;
			 }
			 
			 if(noOfChairs>maxNoOfChairs)
				 maxNoOfChairs = noOfChairs;
		 }
		 
		 return maxNoOfChairs;
	 }
		 
	private static int findMaxTime(int[] e) {
		int max = Integer.MIN_VALUE;
		for(int i: e)
		{
			if(i>max)
				max = i;
		}
		return max;
	}

	public static void main(String[] args) {
		
		int s[] = {1,2,6,5,3};
		int e[] = {2,5,7,6,8};
		
		System.out.println(solution(s, e));
		
	}

}
