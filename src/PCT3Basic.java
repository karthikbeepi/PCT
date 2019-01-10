import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PCT3Basic {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int noOfV = Integer.parseInt(s[0]);
		int noOfH = Integer.parseInt(s[1]);
		int[][] verticalLines = new int[noOfV][3];
		int[][] horizontalLines = new int[noOfH][3];
		for(int i=0; i<noOfV; i++)
		{
			s = br.readLine().split(" ");
			verticalLines[i][0] = Integer.parseInt(s[0]);
			verticalLines[i][1] = Integer.parseInt(s[1]);
			verticalLines[i][2] = Integer.parseInt(s[2]);
		}
		for(int i=0; i<noOfH; i++)
		{
			s = br.readLine().split(" ");
			horizontalLines[i][0] = Integer.parseInt(s[0]);
			horizontalLines[i][1] = Integer.parseInt(s[1]);
			horizontalLines[i][2] = Integer.parseInt(s[2]);
		}
		int noOfIntersect =0;
		for(int i=0; i<noOfV; i++)
		{
			for(int j=0; j<noOfH; j++)
			{
				noOfIntersect += checkIfIntersect(verticalLines[i], horizontalLines[j]);
			}
		}
		
		System.out.println(noOfIntersect);
		
	}

	private static int checkIfIntersect(int[] vl, int[] hl) {
		
		for(int i = vl[1]; i<=vl[2]; i++)
		{
			for(int j= hl[1]; j<=hl[2]; j++)
			{
				if(i==hl[0]&&j==vl[0])
					return 1;
			}
		}
		
		return 0;
	}

}
