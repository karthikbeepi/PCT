import java.util.ArrayList;

public class FF {

	 class Graph{
		int V;
		int[][] E;
		int[] parent;
		ArrayList<Integer> path = new ArrayList<>();
		public Graph(int v) {
			V = v;
			E = new int[V][V];
		}
		public void addEdge(int u, int v, int w)
		{
			E[u][v] = w;
		}
		
		public boolean isPath(int src, int snk)
		{
			ArrayList<Integer> q = new ArrayList<>();
			q.add(src);
			ArrayList<Integer> vis = new ArrayList<>();
			parent = new int[V];
			parent[src] = -1;
			while(!q.isEmpty())
			{
				int temp = q.remove(0);
				if(vis.contains(temp))
					continue;
				else
				{
					vis.add(temp);
					for(int i=0; i<V; i++)
					{
						if(E[temp][i]!=0)
						{
							if(vis.contains(i))
								continue;
							parent[i] = temp;
							if(i==snk)
								return true;
							q.add(i);
						}
						
					}	
				}
				
			}
			return false;
		}
		
		public void findPath(int src, int snk)
		{
			int temp = parent[snk];
			path = new ArrayList<>();
			path.add(snk);
			while(temp!=-1)
			{
				path.add(temp);
				temp = parent[temp];
			}
		}
		
		public int  minCut(int src, int snk)
		{
			int flow = 0;
			while(isPath(src, snk))
			{
				findPath(src, snk);				
				int min = minEdge(path);
				for(int i=0; i<path.size()-1; i++)
				{
					E[path.get(i+1)][path.get(i)] -= min;
					E[path.get(i)][path.get(i+1)] += min;
				}
				flow+=min;
			}
			return flow;
		}
		private int minEdge(ArrayList<Integer> p) {
			int min = Integer.MAX_VALUE;
			for(int i=0; i<path.size()-1; i++)
			{
				int t = E[path.get(i+1)][path.get(i)];
				if(t<min)
					min = t;
			}
			return min;
		}
		
	}
	
	Graph g = new Graph(4);
	
	
	public static void main(String[] args) {

		FF ob = new FF();
		ob.g.addEdge(0, 1, 5);
		ob.g.addEdge(0, 2, 5);
		ob.g.addEdge(0, 3, 5);
		ob.g.addEdge(1, 2, 3);
		ob.g.addEdge(1, 3, 3);
		ob.g.addEdge(3, 2, 8);
		System.out.println(ob.g.minCut(0, 2));
		
	}

}
