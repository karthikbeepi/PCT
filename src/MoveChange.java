import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveChange {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String curMove = br.readLine().toUpperCase();
		String powMove = br.readLine().toUpperCase();
		char[] cM = curMove.toCharArray();
		char[] pM = powMove.toCharArray();
		int count=0;
		for(int i=0; i<curMove.length(); i++)
		{
			if(pM[i]-cM[i]<0)
			{
				if(pM[i]-cM[i]>13)
				{
					cM[i] = (char)((int)cM[i] + 13); 
				}
				else
				{
					
				}
			}
			else
			{
				
			}
		}
		
	}

}
