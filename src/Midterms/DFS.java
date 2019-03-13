package Midterms;

import java.util.ArrayList;

public class DFS {

	class Graph{
		int V;
		int[][] adj;
		int vis[];
		public Graph(int i) {
			
			V = i;
			adj = new int[i][i];
			
		}
		public void addEdge(int u, int v)
		{
			adj[u][v] = 1 ;
			adj[v][u] = 1 ;
		}
		public void dfs(int s)
		{
			vis[s]=1;
			for(int i=0; i<V; i++)
			{
				if(adj[s][i]==1&&i!=s&&vis[i]==0)
					dfs(i);
			}
			System.out.println(s);
		}
		
		public void bfs(int s)
		{
			ArrayList<Integer> q = new ArrayList<>();
			q.add(s);
			while(!q.isEmpty())
			{
				int t = q.remove(0);
				if(vis[t]==1)
					continue;
				vis[t] = 1;
				System.out.println(t);
				for(int i =0; i<V; i++)
				{
					if(adj[t][i]!=0)
						q.add(i);
				}
			}
		}
		
		public void bfs()
		{
			vis = new int[V];
			bfs(0);
		}
		
		public void dfs() {
			vis = new int[V];
			dfs(0);
		}
	}
	
	Graph g = new Graph(5);
	
	public static void main(String[] args) {

		DFS ob = new DFS();
		ob.g.addEdge(2, 1);
		ob.g.addEdge(2, 0);
		ob.g.addEdge(3, 0);
		ob.g.dfs();
		ob.g.bfs();
	}

}
