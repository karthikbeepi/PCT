
public class Hiking {

	public static void main(String args[])
	{
		System.out.println(findValleys("DDUUDDUDUUUD"));
	}

	private static int findValleys(String string) {
		
		int count =0;
		int[] pos = new int[string.length()];
		pos[0] = 0;
		for(int i=1; i<string.length()-4; i++)
		{
			pos[i] = pos[i-1];
			if(string.charAt(i)=='U')
				pos[i]+=1;
			else
				pos[i]-=1;
		}
		
		for(int i=0; i<string.length()-4; i++)
		{
			if(pos[i]==0&&pos[i+2]==-2)
				count++;
		}
		
		return count;
		
	}
	
	
}
