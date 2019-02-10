import java.util.ArrayList;
import java.util.Random;

public class HashStruct {
	
	boolean flag = true;
	
	int val;
	
	ArrayList<Integer> values = null;
	
	public void insert(int i)
	{
		if(flag)
		{
			val = i;
			flag = false;
		}
		
		else
		{
			if(values==null)
			{
				values = new ArrayList<Integer>();
				values.add(val);
			}
			values.add(i);			
		}
	}
	
	public ArrayList<Integer> getVal()
	{
		if(flag)
		{
			return null;
		}
		else if(values==null)
		{
			ArrayList<Integer> r = new ArrayList<>();
			r.add(val);
			return r;
		}
		else
			return values;
	}
	
	public static int key(int k)
	{
		return k%151;
	}
	
	public static void main(String[] args)
	{
		HashStruct[] h = new HashStruct[151];
		for(int i=0; i<151; i++)
			h[i] = new HashStruct();
		for(int i =0; i<100; i++)
		{
			Random rand = new Random();
			int r = rand.nextInt(1500);
			int k = HashStruct.key(r);
			h[k].insert(r);
		}
		StringBuilder op = new StringBuilder();
		for(HashStruct i : h)
		{
			ArrayList<Integer> t = i.getVal();
			if(t==null)
			{
				op.append("EMPTY\n");
				continue;
			}
			for(int p : t)
				op.append(p+" "+i+"\n");
		}
		System.out.print(op.substring(0, op.length()-1));
	}

}
