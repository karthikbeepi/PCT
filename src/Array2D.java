
public class Array2D {

	public static void main(String[] args) {

		int[][] ar = {{1 ,1 ,1 ,0 ,0 ,0},{0 ,1 ,0 ,0 ,0 ,0},{1 ,1 ,1 ,0 ,0 ,0}, {0 ,0 ,2 ,4 ,4 ,0}, {0 ,0 ,0 ,2 ,0 ,0}, {0 ,0 ,1 ,2 ,4 ,0}};
		System.out.println("\n"+findMaxHG(ar));
		for(int[] a : ar)
		{
			for(int i : a)
				System.out.print(i+" ");
			System.out.println();
		}
		
	}

	private static int findMaxHG(int[][] ar) {
		int max=Integer.MIN_VALUE;
		for(int row=0; row<4; row++)
		{
			for(int col=0; col<4; col++)
			{
				int cur = getHGVal(row,col,ar);
				System.out.print(cur+" ");
				if(max<cur)
					max = cur;
				else
					continue;
			}
				
		}
		
		return max;
	}

	private static int getHGVal(int row, int col, int[][] ar) {
		int count =0;
		for(int c = col; c<col+3; c++)
			count+=ar[row][c];
		count+=ar[row+1][col+1];
		for(int c = col; c<col+3; c++)
			count+=ar[row+2][c];
		return count;
	}

}
