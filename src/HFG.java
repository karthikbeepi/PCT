import java.util.Scanner;

public class HFG {
	
	class Player{
		int id;
		int x, y;
		public Player(int i, int x, int y) {
			id = i;
			this.x = x;
			this.y = y;
		}
		public boolean jump()
		{
			if(cells[x][y].c=='G')
			{
				op.append(id);
				return false;
			}
				
			else if(cells[x][y].c=='D')
			{
				x += cells[x][y].x;
				y += cells[x][y].y;
				if(x>row)
					x-=row;
				if(y>col)
					y-=col;
				if(x<0)
					x+=row;
				if(y<0)
					y+=col;
			}
				
			return true;
		}
	}
	
	class Cell{
		char c;
		int x, y;
		public Cell(char c) {
			this.c = c;
		}
		public Cell(char c ,int x, int y)
		{
			this.c = c;
			this.x = x;
			this.y = y;
		}
	}
	
	int row, col,noOfplayers;
	Player[] players;
	Cell[][] cells;
	public static void main(String args[])
	{
		HFG obj = new HFG();
		obj.getInput();
		obj.getWinner();
	}

	private void getWinner() {
		
		while(op.length()==0)
		{
			for(int i=0; i<players.length; i++)
			{
				if(!players[i].jump())
					break;
			}
		}
		System.out.print(op.toString());
		
	}

	StringBuilder op = new StringBuilder();
	
	private void getInput() {
		Scanner scan = new Scanner(System.in);
		String sp[] = scan.nextLine().split(" ");
		row = Integer.parseInt(sp[0]);
		col = Integer.parseInt(sp[1]);
		cells = new Cell[row][col];
		for(int i=0; i<row; i++)
		{
			int k=0;
			sp = scan.nextLine().split(" ");
			for(int j=0; j<sp.length; j++)
			{
				if(sp[j].equalsIgnoreCase("D"))
				{
					cells[i][k++] = new Cell('D',Integer.parseInt(sp[j+1]), Integer.parseInt(sp[j+2]));
					j+=2;
				}
				else if(sp[j].equalsIgnoreCase("T"))
				{
					cells[i][k++] = new Cell('T');
				}
				else
					cells[i][k++] = new Cell('G');
			}
		}
		noOfplayers = Integer.parseInt(scan.nextLine());
		players = new Player[noOfplayers];
		for(int i=0; i<noOfplayers; i++)
		{
			sp = scan.nextLine().split(" ");
			players[i] = new Player(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), Integer.parseInt(sp[2]));
		}
	}

}
