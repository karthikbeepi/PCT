import java.io.BufferedReader;
import java.io.InputStreamReader;

5 4
D 2 0 D 0 2 T D 3 0
T D 6 0 D 0 3 D 2 0
D 0 -1 D 1 0 G D 0 -1
D 0 3 D 0 2 D 0 2 D 0 3
D -1 0 T D 0 -3 T
4
1 4 2
2 2 0
3 0 3
4 2 3


public class PCT6Bas {

	class Cell{
		char typeOfCell;
		int disp[] = new int[2];
		public Cell(char c, int i, int j)
		{
			typeOfCell = c;
			disp[0] = i;
			disp[1] = j;
		}
		public Cell(char c)
		{
			typeOfCell = c;
		}
		public Cell()
		{
			
		}
		
		char get() {
			return this.typeOfCell;
		}
		int[] getDisp()
		{
			return this.disp;
		}
	}	
	
	int nor, noc, nop;
	Cell[][] table;
	int playerPos[][];
	
	public static void main(String[] args) throws Exception {

		PCT6Bas obj = new PCT6Bas();
		obj.getInput();
		System.out.println(obj.play());
	}

	private int play() {
while(true){
	for(int i=0; i<nop; i++)
	{
		int r = playerPos[i][1];
		int c = playerPos[i][2];
		
		
		if(table[r][c].get()=='G')
		{
			return playerPos[i][0];
		}
		else if (table[r][c].get()=='T')
			continue;
		else if(table[r][c].get()=='D')
		{
			playerPos[i][0] += table[r][c].getDisp()[0];
			playerPos[i][1] += table[r][c].getDisp()[1];

			if(playerPos[i][1]<0)
				playerPos[i][1]+=nor;
			if(playerPos[i][1]>nor)
				playerPos[i][1]-=nor;
			if(playerPos[i][2]<0)
				playerPos[i][2]+=noc;
			if(playerPos[i][2]>noc)
				playerPos[i][2]-=noc;
		}
	}
}
	}

	private void getInput() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		nor = Integer.parseInt(str[0]);
		noc = Integer.parseInt(str[1]);
		table = new Cell[nor][noc];
		for(int i=0; i<nor; i++)
		{
			str = br.readLine().split(" ");
			codeIntoRow(i, str);
		}
		
		nop = Integer.parseInt(br.readLine());
		playerPos = new int[nop][3];
		
		for(int i=0; i<nop; i++)
		{
			str = br.readLine().split(" ");
			codeIntoPlayer(i, str);
		}
	}

	private void codeIntoPlayer(int i, String[] str) {
		playerPos[i][0] = Integer.parseInt(str[0]);
		playerPos[i][1] = Integer.parseInt(str[1]);
		playerPos[i][2] = Integer.parseInt(str[2]);
	}

	private void codeIntoRow(int j, String[] str) {
		
		int c=0;
		for(int i=0; i<str.length; i++)
		{
			if(str[i].compareToIgnoreCase("D")==0)
			{
				table[j][c] = new Cell(str[i].charAt(0), Integer.parseInt(str[i+1]), Integer.parseInt(str[i+2]) );
				i=i+2;
			}
			else if(str[i].compareToIgnoreCase("T")==0)
			{
				table[j][c] = new Cell(str[i].charAt(0));
			}
			else if(str[i].compareToIgnoreCase("G")==0)
			{
				table[j][c] = new Cell(str[i].charAt(0));
			}	
			
			if(c<noc)
				c++;
		}
		
	}

}
