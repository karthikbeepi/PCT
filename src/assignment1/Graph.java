package assignment1;

public class Graph {
		int V;
		int E[][];
		int path[][] = new int[10000][10000];
		int pathCount=0;
		
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
			int ar[] = new int[V];
			for(int i=0; i<V; i++)
				ar[i] =i;
			permutation(ar, 0, V-1);
			for(int i=0; i<pathCount; i++)
			{
				int cost = pathVal(path[i]); 
				if(cost<minCost)
					minCost=cost;
			}
			return minCost;
		}

		private int pathVal(int[] p) {
			int cost = 0;
			int temp ;
			for(int i=0; i<p.length-1; i++)
			{
				temp = E[p[i]][p[i+1]];
				if(temp==0)
				{
					return Integer.MAX_VALUE;
				}
				cost+=temp;
			}
			temp = E[p[0]][p[p.length-1]];
			if(temp==0)
				return Integer.MAX_VALUE;
			cost+= temp;
			return cost;
		}
		public void permutation(int ar[], int start, int end)
		{
			if(start==end)
				path[pathCount++] = ar.clone();
			else
			{
				for(int i=start; i<=end; i++)
				{
					swap(ar, start, i);
					permutation(ar, start+1, end);
					swap(ar, start, i);
				}
			}
		}
		
		private void swap(int[] ar, int start, int i) {
			int temp = ar[start];
			ar[start] = ar[i];
			ar[i] = temp;
		}
}
