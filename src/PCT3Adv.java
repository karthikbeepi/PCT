import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class PCT3Adv {

	HashSet<Integer> t ;
	ArrayList<Integer> items;
	int N;
	
	public static void main(String[] args) {
		PCT3Adv ob = new PCT3Adv();
		ob.readInput();
		ob.findPlace();
	}

	private void findPlace() {
		t = new HashSet<Integer>();
		for(int i : items)
		{
			int j = computeJ(i);
			System.out.print(j+" ");
			while(true)
			{
				if(!t.contains(j))
				{
					t.add(j);
					break;
				}
				int remainder = i%10;
				i = i/10;
				if(i==0)
				{
					System.out.print(remainder+" ");
					while(t.contains(remainder))
					{
						remainder--;
						System.out.print(remainder+" ");
					}
					t.add(remainder);
					break;
				}
				if(remainder%2!=0)
					j+= computeJ(i);
				else
					j-= computeJ(i);
				if(j>6)
					j-=7;
				if(j<0)
					j+=7;
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

	private int computeJ(int i) {
		return  i % N;
	}

	private void readInput() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = null;
		try {
			N = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			s = br.readLine().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		items = new ArrayList<Integer>();
		
		for(int i=0; i<s.length; i++)
		{
			int temp = Integer.parseInt(s[i]);
			if(temp!=-1)
				items.add(temp);
			else
				break;
		}
	}

}
