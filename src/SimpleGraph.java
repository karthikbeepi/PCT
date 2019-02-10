import java.util.ArrayList;

public class SimpleGraph {
		int V;
		int E[][];
		
		public SimpleGraph(int v) {
			V = v+1;
			E = new int[V][V];
		}
		
		public void addEdge(int u, int v, int w)
		{
			E[u][v] = w;	
		}
		
		public void bfs()
		{
			int s = findStartNode();
			ArrayList<Integer> q = new ArrayList<Integer>();
			q.add(s);
			while(!q.isEmpty())
			{
				int temp = q.remove(0);
				if(!vis.contains(temp))
				{
					vis.add(temp);
					for(int i=1; i<V; i++)
						if(E[temp][i]!=0)
							q.add(i);
				}
			}
		}
		
		ArrayList<Integer> vis = new ArrayList<Integer>();
		
		void dfs()
		{
			vis = new ArrayList<Integer>();
			int s = findStartNode();
			dfs(s);
		}
		
		void dfs(int s)
		{
			for(int i=1; i<V; i++)
				if(E[s][i]!=0&&!vis.contains(i))
				{
					dfs(i);
				}
			vis.add(s);
		}

		private int findStartNode() {
			for(int i=1; i<V; i++)
				for(int j=1; j<V; j++)
					if(E[i][j]!=0)
						return i;
			return 0;
		}
}
