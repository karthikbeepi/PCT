package PCT5;

import java.util.ArrayList;
import java.util.Scanner;

public class MatRot {

	int rows, cols, noOfRotations;
	int mat[][];
	
	public static void main(String args[])
	{
		MatRot ob = new MatRot();
		ob.getInput();
	}

	private void getInput() {
		
		Scanner scan = new Scanner(System.in);
		String[] sp = scan.nextLine().split(" ");
		rows = Integer.parseInt(sp[0]);
		cols = Integer.parseInt(sp[1]);
		mat = new int[rows][cols];
		noOfRotations = Integer.parseInt(sp[2]);
		for(int i=0; i<rows; i++)
		{
			sp = scan.nextLine().split(" ");
			for(int j=0; j<cols; j++)
			{
				mat[i][j] = Integer.parseInt(sp[j]);
			}
		}
		rotateMat(noOfRotations);
		printMat();
	}

	private void rotateMat(int r) {
		ArrayList<Integer> loop[] = new ArrayList[rows/2];
		for(int i=0; i<rows/2; i++)
			loop[i] = new ArrayList<Integer>();
		for(int k=0; k<rows/2; k++)
		{
			loop[k] = getLoop(k);
			for(int j=0; j<r; j++)
			{
				int temp = loop[k].get(0);
				loop[k].remove(0);
				loop[k].add(temp);
			}
			putLoop(loop[k], k);
//			for(int var: loop[k])
//				System.out.print(var+" ");
//			System.out.println();
		}
		
	}

	private void putLoop(ArrayList<Integer> arrayList, int k) {
		
		for(int i=k+1; i<cols-k; i++)
		{
			mat[k][i]= arrayList.get(0);
			arrayList.remove(0);
		}
		for(int i=k+1; i<rows-k; i++)
		{
			mat[i][cols-1-k]= arrayList.get(0);
			arrayList.remove(0);
		}
		for(int i=cols-2-k; i>=k; i--)
		{
			mat[rows-1-k][i]= arrayList.get(0);
			arrayList.remove(0);
		}
		for(int i=rows-2-k; i>=k; i--)
		{
			mat[i][k]= arrayList.get(0);
			arrayList.remove(0);
		}
		
	}

	private ArrayList<Integer> getLoop(int k) {
		ArrayList<Integer> l = new ArrayList<>();
		//l.add(mat[k][0]);
		for(int i=k+1; i<cols-k; i++)
			l.add(mat[k][i]);
		for(int i=k+1; i<rows-k; i++)
			l.add(mat[i][cols-1-k]);
		for(int i=cols-2-k; i>=k; i--)
			l.add(mat[rows-1-k][i]);
		for(int i=rows-2-k; i>=k; i--)
			l.add(mat[i][k]);
		return l;
	}

	private void printMat() {
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cols; j++)
				System.out.print(mat[i][j]+" ");
			System.out.println();
		}
	}
	
}

