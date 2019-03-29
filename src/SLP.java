import java.util.ArrayList;
import java.util.Scanner;

public class SLP {

	boolean board[] = new boolean[31];
	int jumps;
	int jump[][];
	boolean flag = false;
	public static void main(String[] args) {
		
		SLP obj = new SLP();
		//obj.getInput();
		obj.play(1);
		
	}


	private void play(int start) {

		if(start==30)
		
		for(int i=6; i>0; i--)
			play(start+i);
		
	}


	private void getInput() {
		
		Scanner scan = new Scanner(System.in);
		jumps = Integer.parseInt(scan.nextLine());
		jump = new int[jumps][2];
		String[] sp = scan.nextLine().split(" ");
		for(int i=0; i<sp.length; i+=2)
		{
			jump[i][0] = Integer.parseInt(sp[i]);
			jump[i][1] = Integer.parseInt(sp[i+1]);
		}
		
	}

}
