import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PCT2Adv {

	private int rows, cols, emptyCells, noOfGen;
	private char[][] mat;
	private char[][] newMat;

	public static void main(String[] args) throws NumberFormatException, IOException {

		PCT2Adv obj = new PCT2Adv();
		obj.getInput();
		for(int i=0; i<obj.noOfGen; i++)
			obj.performGen();
		System.out.println(obj.findNoOfOrg());
		
	}

	private int findNoOfOrg() {
		int countOrg=0;
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
				if(mat[i][j]=='@')
					countOrg++;
		return countOrg;
	}

	private void performGen() {
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				if(mat[i][j]=='#')
					checkReproduce(i, j);
				else
					checkSurvival(i, j);
			}
		}
		mat = newMat;
	}

	private void checkSurvival(int i, int j) {
		int countOrg=0;
		for(int row=i-1; row<=i+1; row++)
		{
			for(int col=j-1; col<=j+1; col++)
			{
				if(row<0||col<0||row>=rows||col>=cols||(row==i&&col==j))
					continue;
				else if(mat[row][col]=='@')
					countOrg++;
			}
		}
		if(countOrg<=1 || countOrg>=4)
			newMat[i][j]='#';
	}

	private void checkReproduce(int i, int j) {
		int countOrg=0;
		for(int row=i-1; row<=i+1; row++)
		{
			for(int col=j-1; col<=j+1; col++)
			{
				if(row<0||col<0||row>=rows||col>=cols)
					continue;
				else if(mat[row][col]=='@')
					countOrg++;
			}
		}
		if(countOrg==3)
			newMat[i][j]='@';
	}

	private void getInput() throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		rows = Integer.parseInt(temp[0]);
		cols = Integer.parseInt(temp[1]);
		mat = new char[rows][cols];
		newMat = new char[rows][cols];
		for(int i=0; i<rows; i++)
		{
			String t = br.readLine();
			for(int j=0; j<cols; j++)
			{
				if(t.charAt(j)=='#')
					mat[i][j]='#';
				else
					mat[i][j]='@';
			}
		}
		for(int i=0; i<rows; i++)
			for(int j=0; j<cols; j++)
				newMat[i][j] = mat[i][j];
		noOfGen = Integer.parseInt(br.readLine());
	}

}
