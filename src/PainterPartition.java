import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;


public class PainterPartition {
	
	int painter, board;
    int[] sizeOfBoards;
    
    public int getPlan()
    {
        int cost = 0;
        if(painter==1)
            for(int t: sizeOfBoards)
            {
                cost+=t;
            }
            
        else
        {
            int[] optima = findLocalOptima(painter, sizeOfBoards);
            int[] sum = new int[painter];
            for(int i=0; i<painter; i++)
            {
                for(int j=optima[i]; j<optima[i+1]; j++)
                {
                    sum[i]+=sizeOfBoards[j];
                }
            }
            Arrays.sort(sum);
            return sum[this.painter-1];
        }
        
        return cost;
    }
    
	private int[] findLocalOptima(int p, int[] sob) {
	
		HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
		int j=0;
		for(int i=1; i<board-1; i++)
		{
			if(sob[i-1]<sob[i]&&sob[i]>sob[i+1])
			{
				temp.put(i, sob[i]);
			}
		}

		
		
		return null;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner scan = new Scanner(System.in);
        int noOfTests = scan.nextInt();
        PainterPartition[] ob = new PainterPartition[noOfTests];
        for(int i=0; i<noOfTests; i++)
        {
            ob[i] = new PainterPartition();
            ob[i].painter = scan.nextInt();
            ob[i].board = scan.nextInt();
            ob[i].sizeOfBoards = new int[ob[i].board];
            for(int j=0; j<ob[i].board; j++)
            {
                ob[i].sizeOfBoards[j] = scan.nextInt();
            }
        }
        for(PainterPartition t: ob)
        {
            System.out.println(t.getPlan());
        }
	}
	
}
