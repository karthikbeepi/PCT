import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MovieDataFrame {

	int numberOfDatasets;
	
	class Pair{
		String s1, s2;
		public Pair(String a, String b) {
			s1=a;
			s2 = b;
		}
	}

	HashMap<String, Integer> actorCount = new HashMap<String, Integer>();
	HashMap<String, Integer> dirCount = new HashMap<String, Integer>();
	HashMap<Pair, Integer> pairActorCount = new HashMap<Pair, Integer>();
	HashMap<Pair, Integer> dirActorCount = new HashMap<Pair, Integer>();
	
	
	class DataFrame
	{
		String title, director;
		ArrayList<String> actors;
		public DataFrame(String title, String director, ArrayList<String> actors) {
			
			this.title = title;
			this.director = director;
			this.actors = actors;
			Collections.sort(this.actors);
			
		}
	}
	
	DataFrame[] df;

	public static void main(String[] args) {
		MovieDataFrame obj = new MovieDataFrame();
		obj.getInput();
		obj.findPopActor();
		obj.findPopPair();
		obj.findDirActor();
	}

	public void findDirActor() {
		
		for(int i=0; i<numberOfDatasets; i++)
		{
			if(!dirCount.containsKey(df[i].director))
			{
				dirCount.put(df[i].director, 0);
			}
			else
			{
				int c = dirCount.get(df[i].director);
				dirCount.put(df[i].director, ++c);
			}
		}
		createDirPairs();
		ArrayList<String> movies = new ArrayList<String>();
		
		for(int i=0; i<numberOfDatasets; i++)
		{
			for(Pair p :dirActorCount.keySet())
			{
				if(df[i].director.equalsIgnoreCase(p.s2)&&df[i].actors.contains(p.s1))
				{
					int c = dirActorCount.get(p);
					dirActorCount.put(p, ++c);
				}
			}
		}
		Pair maxPair = findDirActCountPairs(dirActorCount);
		for(int i=0; i<numberOfDatasets; i++)
		{
			if(df[i].director.equalsIgnoreCase(maxPair.s2)&&df[i].actors.contains(maxPair.s1))
			{
				movies.add(df[i].title);
			}
		}

		//System.out.println(maxPair.s1+maxPair.s2);
		System.out.println();
//		if(maxPair.s1.compareToIgnoreCase(maxPair.s2)<0)
//			System.out.print("("+maxPair.s2+","+maxPair.s1+":");
//		else
//			System.out.print("("+maxPair.s1+","+maxPair.s2+":");
		System.out.print("("+maxPair.s2+","+maxPair.s1+":");
		Collections.sort(movies);
		int i;
		for(i=0; i<movies.size()-1; i++)
			System.out.print(movies.get(i)+",");
		System.out.print(movies.get(i)+")");
		
	}

	public Pair findDirActCountPairs(HashMap<Pair, Integer> da ) {
		int max = Integer.MIN_VALUE;
		Pair maxpair = null;
		for(Pair p : da.keySet())
		{
			if(max<da.get(p))
			{
				max = da.get(p);
				maxpair = p;
			}
		}
		return maxpair;
	}

	private void createDirPairs() {
		for(String i: actorCount.keySet())
			for(String j: dirCount.keySet())
			{
				Pair p = new Pair(i, j);
				Pair ip= new Pair(j, i);
				if(!dirActorCount.containsKey(ip))
					dirActorCount.put(p, 0);
			}
	}

	public void findPopPair() {
		int maxCountMovies=Integer.MIN_VALUE;
		Pair maxCountPair = null;
		
		createPairs();
		ArrayList<String> movies = new ArrayList<String>();
		Pair maxPair = findActCountPairs(pairActorCount);
		for(int i=0; i<numberOfDatasets; i++)
		{
			if(df[i].actors.contains(maxPair.s1)&&df[i].actors.contains(maxPair.s2))
			{
				movies.add(df[i].title);
			}
		}
		System.out.println();
		if(maxPair.s1.compareToIgnoreCase(maxPair.s2)<0)
			System.out.print("("+maxPair.s1+","+maxPair.s2+":");
		else
			System.out.print("("+maxPair.s2+","+maxPair.s1+":");
		Collections.sort(movies);
		int i;
		for(i=0; i<movies.size()-1; i++)
			System.out.print(movies.get(i)+",");
		System.out.print(movies.get(i)+")");
		
		
	}

	private Pair findActCountPairs(HashMap<Pair, Integer> pairCount) {
		for(int i=0; i<numberOfDatasets; i++)
		{
			for(Pair p: pairCount.keySet())
			{
				if(df[i].actors.contains(p.s1)&&df[i].actors.contains(p.s2))
				{
					int c = pairActorCount.get(p);
					pairActorCount.put(p, ++c);
				}
			}
		}
		
		ArrayList<String> maxMovies = new ArrayList<>();
		Pair maxPair = null;
		int maxPairCount=Integer.MIN_VALUE;
		for(Pair p: pairCount.keySet())
		{
			if(maxPairCount<pairCount.get(p))
			{
				maxPair = p;
				maxPairCount = pairCount.get(p);
			}
		}
		return maxPair;
	}

	private void createPairs() {
		
		for(String i: actorCount.keySet())
			for(String j: actorCount.keySet())
			{
				if(i==j)
					continue;
				Pair p = new Pair(i, j);
				Pair ip= new Pair(j, i);
				if(!pairActorCount.containsKey(ip))
					pairActorCount.put(p, 0);
			}
		
	}

	public void findPopActor() {
		int maxCountMovies=Integer.MIN_VALUE;
		String maxCountActor = null;
		for(int i=0; i<numberOfDatasets; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(!actorCount.containsKey(df[i].actors.get(j)))
				{
					actorCount.put(df[i].actors.get(j), 1);
				}
				else
				{
					int c = actorCount.get(df[i].actors.get(j));
					actorCount.put(df[i].actors.get(j), ++c);
				}
			}
		}
		
		for(String a : actorCount.keySet())
		{
			if(maxCountMovies<actorCount.get(a))
			{
				maxCountActor = a;
				maxCountMovies = actorCount.get(a);
			}
		}
		int numMoviesActed =0;
		ArrayList<String> movies = new ArrayList<>();
		for(int i=0; i<numberOfDatasets; i++)
		{
			if(df[i].actors.contains(maxCountActor))
			{
				numMoviesActed++;
				movies.add(df[i].title);
			}
		}
		Collections.sort(movies);
		System.out.print("("+maxCountActor+":");
		int i;
		for(i=0; i<numMoviesActed-1; i++)
		{
			System.out.print(movies.get(i)+",");
		}
		System.out.print(movies.get(i)+")");
	}

	private void getInput() {
		Scanner scan = new Scanner(System.in);
		numberOfDatasets = Integer.parseInt(scan.nextLine());
		df = new DataFrame[numberOfDatasets];
		for(int i=0; i<numberOfDatasets; i++)
		{
			String[] sp = scan.nextLine().split(" ");
			String title = sp[0];
			String director = sp[1];
			ArrayList<String> actors = new ArrayList<String>();
			actors.add(sp[2]);
			actors.add(sp[3]);
			actors.add(sp[4]);
			df[i] = new DataFrame(title, director, actors);
		}
	}

}