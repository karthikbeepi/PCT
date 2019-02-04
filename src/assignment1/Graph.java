package assignment1;

public class Graph {
		int V;
		int E[][];
		
		public Graph(int v) {
			V = v;
			E = new int[V][V];
		}
		public void addEdge(int u, int v, int w)
		{
			E[u][v] = w;
			E[v][u] = w;
		}
		public int findTSP() {
			
			int minCost = Integer.MAX_VALUE;
			int st = 0;
			
			while(true)
			{
				if(st==V)
					break;
				int[] ar = new int[V-1];
				int k = 0;
				for(int i=0; i<V; i++)
				{
					if(i == st)
						continue;
					else
					{
						ar[k] = i;
						if(k<V-1)
							k++;
					}
				}		
				int startVal = E[st][ar[0]];
				int endVal = E[ar[V-2]][st];
				int cost;
				if(startVal==0||endVal==0)
					cost = Integer.MAX_VALUE;
				else
				{
					cost = startVal+endVal;
					for(int j = 1; j<V-1; j++)
					{
						if(E[ar[j-1]][ar[j]]==0)
						{
							cost = Integer.MAX_VALUE;
							break;
						}
						else
							cost += E[ar[j-1]][ar[j]];
					}
				}
				if(minCost>cost)
					minCost = cost;
				st++;
			}
			return minCost;
		}

}
