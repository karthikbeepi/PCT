import java.util.ArrayList;
import java.util.Scanner;

public class pathCheck {

	int n;
	int mat[][];
	Coordinates src;
	Coordinates dest;
	boolean vis[][];
	
	class Coordinates{
		int x, y;
		public Coordinates(int i, int j) {
			x = i;
			y = j;
		}
	}
	
	public static void main(String[] args) {

		pathCheck obj = new pathCheck();
		obj.getInput();
			
	}

	private void getInput() {
		
		Scanner scan = new Scanner(System.in);
		n = Integer.parseInt(scan.nextLine());
		String sp[] = scan.nextLine().split(" ");
		mat = new int[n][n];
		int k=0;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				mat[i][j] = Integer.parseInt(sp[k++]);
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		findSrc();
		findDest();
		findPath();
		
	}

	private void findPath() {
		
		ArrayList<Coordinates> q = new ArrayList<>();
		addNeighbours(q, src);
	vis = new boolean[n][n];
		while(!q.isEmpty())
		{
			Coordinates temp = q.remove(0);
			if(vis[temp.x][temp.y]==true)
			{
				continue;
			}
			vis[temp.x][temp.y] = true;
			if(mat[temp.x][temp.y]==2)
			{
				System.out.println(1);
				return;
			}
			addNeighbours(q, temp);
		}
		System.out.println(0);
	}

	private void addNeighbours(ArrayList<Coordinates> q, Coordinates t) {
		
		if(t.x>0)
		{
			if(mat[t.x-1][t.y]!=0) {

				Coordinates top = new Coordinates(t.x-1, t.y);
				q.add(top);	
			}
		}
		if(t.y>0)
		{
			if(mat[t.x][t.y-1]!=0) {

				Coordinates top = new Coordinates(t.x, t.y-1);
				q.add(top);	
			}
		}

		if(t.x+1<n)
		{
			if(mat[t.x+1][t.y]!=0) {

				Coordinates top = new Coordinates(t.x+1, t.y);
				q.add(top);	
			}
		}
		
		if(t.y+1<n)
		{
			if(mat[t.x][t.y+1]!=0) {

				Coordinates top = new Coordinates(t.x, t.y+1);
				q.add(top);	
			}
		}

		
	}

	private void findDest() {
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			{
				if(mat[i][j]==2)
				{
					dest = new Coordinates(i, j);
					return ;
				}
			}
	}

	private void findSrc() {
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			{
				if(mat[i][j]==1)
				{
					src = new Coordinates(i, j);
					return ;
				}
			}
	}

}
