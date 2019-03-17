package PCTCodingNew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class AlienDict {

	class Graph{
		int V;
		int E[][];
		public Graph(int v) {
			V = v;
			E = new int[V][V];
		}
		public void addEdge(int u, int v)
		{
			E[u][v] = 1;
		}
		public int bfs(int i) {
			
			int nodesReached = 0;
			ArrayList<Integer> q = new ArrayList<>();
			q.add(i);
			HashSet<Integer> vis = new HashSet<>();
			while(!q.isEmpty())
			{
				int temp = q.remove(0);
				nodesReached++;
				for(int j=0; j<V; j++)
					if(E[temp][j]==1)
					{
						if(!vis.contains(j))
						{
							q.add(j);
							vis.add(j);
						}
					}
			}	
			return nodesReached;
		}
		public void changeAdjMat(int i) {
		
			for(int j=0; j<V; j++)
			{
				E[i][j] =0;
				E[j][i] =0;
			}
			
		}
	}
	
	HashMap<Character, Integer> m;
	Graph g;
	public static void main(String[] args) {
		AlienDict obj = new AlienDict();
		obj.getInput();
		
	}

	private void getInput() {
		Scanner scan = new Scanner(System.in);
		String[] sp = scan.nextLine().split(" ");
		int n = Integer.parseInt(sp[0]); //number of words
		int k = Integer.parseInt(sp[1]); //number of characters
		g = new Graph(k);
		String s = scan.nextLine();
		sp = s.split(" ");
		int n1 = maxString(sp);
		makeMapChar(s);
		for(int i=0; i<n-1; i++)
		{
			for(int j=0; j<sp[i].length()&&j<sp[i+1].length(); j++)
			{
				char c1 = sp[i].charAt(j);
				int val1 = m.get(c1);
				char c2 = sp[i+1].charAt(j);
				int val2 = m.get(c2);
				if(val1!=val2)
				{
					g.addEdge(val1, val2);
					break;
				}
			}
		}
		printGraph();
		printTopSort();
	}

	private void printTopSort() {
		
		HashSet<Integer> vis = new HashSet<>();
		for(int k=0; k<g.V; k++)
		{
			for(int i=0; i<g.V; i++)
			{
				int size = g.bfs(i);
				int v = g.V-k;
				if(size==v&&!vis.contains(i))
				{
					
					System.out.print(findKey(i));
					g.changeAdjMat(i);
					vis.add(i);
					break;
				}
			}
		}
		
	}

	private char findKey(int val) {
		for(char c : m.keySet())
		{
			int val1 = m.get(c);
			if(val1==val)
				return c;
		}
		return ' ';
	}

	private void printGraph() {
		for(int i=0; i<g.V; i++)
		{
			for(int j=0; j<g.V-1; j++)
				System.out.print(g.E[i][j]+" ");
			System.out.print(g.E[i][g.V-1]);
			System.out.println();
		}
	}

	private void makeMapChar(String s) {
		
		int i=0;
		m = new HashMap<>();
		for(char c : s.toCharArray())
		{
			if(c==' ')
				continue;
			if(!m.containsKey(c))
				m.put(c, i++);
			else
				continue;
		}
		
	}

	private int maxString(String[] sp) {
		
		int max = 0;
		for(String s: sp)
		{
			if(max<s.length())
				max = s.length();
		}
		return max;
	}

}
