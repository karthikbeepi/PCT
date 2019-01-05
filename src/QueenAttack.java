
public class QueenAttack {

	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

		int markedPlaces =0;
		int[][]  pos = new int [n+1][n+1];
		markHorizontally(r_q, c_q,k, obstacles,pos);
		markVertically(r_q, c_q,k, obstacles, pos);
		markDiagonally(r_q, c_q,k, obstacles, pos);
		
		return markedPlaces;
    }
	
	
	
	private static void markVertically(int r_q, int c_q, int k, int[][] obstacles, int[][] pos) {
		// TODO Auto-generated method stub
		
		for(int col=1; col<=pos.length; col++)
		{
			pos[r_q][col] = 1;
		}
		
		for(int i=0; i<k; i++)
		{
			if(obstacles[k][1] == r_q)
				unMarkVerticall()
		}
		
	}



	private static void markDiagonally(int r_q, int c_q, int k, int[][] obstacles, int[][] pos) {
		// TODO Auto-generated method stub
		
	}



	private static void markHorizontally(int r_q, int c_q, int k, int[][] obstacles, int[][] pos) {
		// TODO Auto-generated method stub
		
	}



	public static void main(String[] args) {

		int[] [] obstacles = new int[3][3];
		
		queensAttack(5, 3, 4, 3, obstacles);
		
	}

}
