public class JumpingClouds {

	public static void main(String[] args) {

		int[] cloudVal = {0 ,0, 1, 0, 0 ,1 ,0};
		findMinimumJump(cloudVal);	
		
	}

	private static void findMinimumJump(int[] cloudVal) {
		int count =0;
		count++;
		for(int i=1; i<cloudVal.length-2; i++)
		{
			if(cloudVal[i]==1&&cloudVal[i+1]==0)
			{
				i++;
				count++;
				continue;
			}
			
			if(cloudVal[i]==0)
			{
				if(cloudVal[i+1]==0)
				{
					count++;
					i++;
					continue;
				}
			}
		}
		
		count++;
		
		System.out.println(count);
	}

}
