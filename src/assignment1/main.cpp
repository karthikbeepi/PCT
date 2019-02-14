#include<iostream>
#include<fstream>

using namespace std;

class Graph
{
		int V;
		int E[11][11]; 
		unsigned int minCost;

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
                int temp = pathVal(ar);
				if(minCost>temp)
					minCost = temp;
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

		public:

		Graph(int v) {
			V = v;
		}

		void addEdge(int u, int v, int w)
		{
			E[u][v] = w;
			E[v][u] = w;
		}

		unsigned int findTSP() {
			minCost = 60000;
			int st = 0;
			int ar[10];
			for(int i=0; i<V; i++)
				ar[i] =i;
			permutation(ar, 0, V-1);
			cout<<minCost<<'\n';
			return minCost;
		}

};

int main(int argc, char* argv[])
{
    ifstream fin;
    ofstream fout;

    if(argc!=3)
    {
        cout<<"Error";
        return -1;
    }

	fin.open(argv[1]);
    fout.open(argv[2]);

    int v, n;
    fin>>n;
    for(int i=0; i<n; i++)
    {
        fin>>v;
        Graph* g;
        g = new Graph(v);
        int queries;
        fin>>queries;
        for(int j=0; j<queries; j++)
        {
            int u, v, w;
            fin>>u>>v>>w;
            g->addEdge(u, v, w);
        }
        fout<<g->findTSP();
        if(i!=n-1)
            fout<<"\n";
        delete g;
    }

    return 0;
}
