import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
public class LeaderBoard {

	public static void main(String[] args) {

		int[] lbVal = {100 ,100 ,50 ,40, 40, 20 ,10};
		int[] alVal = {5, 25, 50, 120};
		for(int i : climbingLeaderboard(lbVal, alVal))
			System.out.print(i+" ");
	}

	static int[] climbingLeaderboard(int[] scores, int[] alice) {

		int [] ranks = new int[alice.length];
		for(int j=0; j<alice.length; j++)
			ranks[j] = findAliceRank(scores, alice[j]);	
		return ranks;
    }

	private static int findAliceRank(int[] scores, int i) {
		TreeMap<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());
		Integer[] scoreInteger = Arrays.stream( scores ).boxed().toArray( Integer[]::new );
		Arrays.sort(scoreInteger, Collections.reverseOrder());
		int k=0;
		for(Integer t: scoreInteger)
		{
			if(tm.containsKey(t))
			{
				continue;
			}
			else
				tm.put(t, ++k);
		}
		
		for(Integer t : tm.keySet())
		{
			if(i>=t)
				return tm.get(t).intValue();
		}
		return tm.get(tm.lastKey())+1;
	}

}
