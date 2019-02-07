#include<iostream>
#include<fstream>
using namespace std;
class Graph {
		public:
		int V;
		int E[1000][1000];
		int path[1000][1000];
		int pathCount=0;

		Graph(int v) {
			V = v;
		}

		void addEdge(int u, int v, int w)
		{
			E[u][v] = w;
			E[v][u] = w;
		}

		int findTSP() {
			int minCost = 9999;
			int st = 0;
			int ar[10];
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

		int pathVal(int p[]) {
			int cost = 0;
			int temp ;
			for(int i=0; i<V-1; i++)
			{
				temp = E[p[i]][p[i+1]];
				if(temp==0)
				{
					return 9999;
				}
				cost+=temp;
			}
			temp = E[p[0]][p[V-1]];
			if(temp==0)
				return 9999;
			cost+= temp;
			return cost;
		}

		void permutation(int ar[], int start, int last)
		{
			if(start==last)
            {
                for(int i=0; i<V; i++)
                    path[pathCount][i]=ar[i];
                pathCount++;
			}
			else
			{
				for(int i=start; i<=last; i++)
				{
					swapNum(ar, start, i);
					permutation(ar, start+1, last);
					swapNum(ar, start, i);
				}
			}
		}

		void swapNum(int ar[], int start, int i) {
			int temp = ar[start];
			ar[start] = ar[i];
			ar[i] = temp;
		}
};

int main(int argc, char* argv[])
{
    Graph g1(4);
	g1.addEdge(0, 1, 2);
	g1.addEdge(0, 2, 1);
	g1.addEdge(0, 3, 2);
	g1.addEdge(1, 2, 2);
	g1.addEdge(3, 1, 1);
	g1.addEdge(2, 3, 2);
	cout<<g1.findTSP();
    return 0;
}
