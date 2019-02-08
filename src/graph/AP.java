package graph;

import java.util.ArrayList;
import java.util.HashSet;

public class AP {

		
		int V;
		int[][] E;
		int minEdge[];
		
		public AP(int v)
		{
			V = v;
			E = new int [V][V];
		}
		
		public void addEdge(int u, int v, int w)
		{
			E[u][v] = w;
			E[v][u] = w;
		}
		
		public ArrayList<Integer> ap()
		{
			ArrayList<Integer> a = new ArrayList<>();
			int[][]	cl = giveClone(E);
			
			for(int k=0; k<V; k++)
			{
				for(int i=0; i<V; i++)
					for(int j=0; j<V; j++)
					{
						if(i==k||j==k)
						{
							cl[i][j]=0;
						}
					}
				if(!connected(cl, k))
					a.add(k);
				cl = giveClone(E);
			}
			return a;
		}
		
		private int[][] giveClone(int[][] cl) {
			int[][] c = new int[cl.length][cl.length];
			for(int i=0; i<cl.length; i++)
				for(int j=0; j<cl.length; j++)
					c[i][j]=cl[i][j];
			return c;
		}

		private boolean connected(int[][] cl, int k) {
			ArrayList<Integer> q = new ArrayList<>();
			HashSet<Integer> vis = new HashSet<>();
			int t = findNonZero(cl);
			q.add(t);
			vis.add(t);
			while(!q.isEmpty())
			{
				int temp = q.remove(0);
				for(int i=0; i<V; i++)
					if(cl[temp][i]!=0&&!vis.contains((Object)i)&&i!=k)
					{
						q.add(i);
						vis.add(i);
					}
			}
			if(vis.size()<V-1)
				return false;
			else 
				return true;
		}

		private int findNonZero(int[][] cl) {
			
			for(int i=0; i<V; i++)
				for(int j=0; j<V; j++)
					if(cl[i][j]!=0)
						return i;
			return 0;
		}

		public int[] findMinNoEdge(int u)
		{
			minEdge = new int[V];
			
			ArrayList<Integer> q = new ArrayList<>();
			ArrayList<Integer> set = new ArrayList<>();
			q.add(u);
			set.add(u);
			int k = 1, j=1;
			minEdge[u] = 0;
			while(!q.isEmpty())
			{
				int temp = q.remove(0);
				for(int i=0; i<V; i++)
				{
					if(E[temp][i]!=0&&!set.contains((Object)i))
					{
						q.add(i);
						minEdge[i]=minEdge[temp]+1;
						set.add(i);
					}
				}
			}	
			return minEdge;
			
		}

}
