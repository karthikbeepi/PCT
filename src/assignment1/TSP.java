package assignment1;

import java.util.Scanner;

public class TSP {
	
	Graph g;
	StringBuilder op = new StringBuilder();
	
	public static void main(String[] args) {
		
		TSP obj = new TSP();
		obj.getInput();
		
	}

	private void getInput() {

		Scanner scan = new Scanner(System.in);
		int noOfDataSets = Integer.parseInt(scan.nextLine());
		for(int i=0; i<noOfDataSets; i++)
		{
			String line[] = scan.nextLine().split(" ");
			int v = Integer.parseInt(line[0]);
			int e = Integer.parseInt(line[1]);
			g = new Graph(v);
			for(int j=0; j<e; j++)
			{
				line = scan.nextLine().split(" ");
				int u = Integer.parseInt(line[0]);
				int v1 = Integer.parseInt(line[1]);
				int w = Integer.parseInt(line[2]);
				g.addEdge(u, v1, w);
			}
			g.findTSP();
		}
		
	}

}
