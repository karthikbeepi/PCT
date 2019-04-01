import java.util.Scanner;

public class SLP {

	int board[] = new int[31];
	int jumps;
	int jump[][];
	boolean flag = false;
	
	public static void main(String[] args) {
		
		SLP obj = new SLP();
		obj.getInput();
		obj.play();
	}
	
	private void play() {
		
		int start = 1;
		board[start] = 0;
		for(int i=2; i<=30; i++)
			board[i]= Integer.MAX_VALUE;
		for(int i=2; i<=30; i++)
		{
			for(int j=6; j>0; j--)
			{
				int temp = i-j;
				if(temp>0)
					if(board[i]>board[temp]+1)
						board[i]=board[temp]+1;
			}
			for(int k=0; k<jumps; k++)
			{
				int s1 = jump[k][0];
				int s2 = jump[k][1];

				if(s1>s2)
				{
					board[s2] = Integer.MAX_VALUE;
					continue;
				}
				if(i==s1)
					board[s2]=board[i];
			}
		}
		System.out.println(board[30]);
		
	}

	private void getInput() {
		
		Scanner scan = new Scanner(System.in);
		jumps = Integer.parseInt(scan.nextLine());
		jump = new int[jumps][2];
		String[] sp = scan.nextLine().split(" ");
		int k=0;
		for(int i=0; i<sp.length-2; i+=2)
		{
			jump[k][0] = Integer.parseInt(sp[i]);
			jump[k][1] = Integer.parseInt(sp[i+1]);
			k++;
		}
		
	}

}
