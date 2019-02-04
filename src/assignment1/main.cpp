#include<iostream>
#include<fstream>

using namespace std;

class Graph {
		int V;
		int E[10000][10000];
		int** path;
		int pathCount=0;
		
		public:
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
			int ar[V];
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
		void permutation(int ar[], int start, int end)
		{
			if(start==end)
				path[pathCount++] = ar;
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
		
		void swap(int ar[], int start, int i) {
			int temp = ar[start];
			ar[start] = ar[i];
			ar[i] = temp;
		}
};


int main(int argc, char * argv[])
{
	fstream fout;
	ifstream fin;
	fin.open(argv[1]);
	if(!fin.good())
		throw "Bad Input File!";
	if(argc!=3)
		throw "Bad arguments given";
	int noOfDatasets;
	fin>>noOfDatasets;
	for(int i=0; i<noOfDatasets; i++)
	{
		int v, e;
		fin>>v>>e;
		
		for(int j=0; j<e; j++)
		{
			
		}
	}	

	while(true)
	{
		if(!fin.good())
			break;
		string lineFromFile;
	    	getline(fin, lineFromFile);
    		cout << lineFromFile << endl;
	}
	fin.close();
	return 0;
}
