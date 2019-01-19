import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PCT5Basic {

	String[] str ;
	HashMap<Character, Integer> alphabet = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		PCT5Basic obj = new PCT5Basic();
		obj.getInput();
		obj.countAlphabets();
		obj.printAlphabets();
		
	}

	private void printAlphabets() {
		
		while(!alphabet.isEmpty())
		{
			char toRemove = 0;
			int maxCount =0;
			for(char c : alphabet.keySet())
			{
				int count = alphabet.get(c);
				if(count>maxCount)
				{
					maxCount= count;
					toRemove = c;
				}
			}
			alphabet.remove(toRemove);
			System.out.print(toRemove);
		}
		
	}

	private void countAlphabets() {
		
		for(int i=0; i<str.length; i++)
		{
			for(int j=0; j<str[i].length(); j++)
			{
				char c = str[i].charAt(j);
				if(Character.isAlphabetic(c))
				{
					if(alphabet.containsKey(c))
					{
						int curCount = alphabet.get(c);
						curCount++;
						alphabet.put(c, curCount);
					}
					else
						alphabet.put(c, 1);
				}
			}
		}
	}

	private void getInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noLines = Integer.parseInt(br.readLine());
		str = new String[noLines];
		for(int i=0; i<noLines; i++)
		{
			str[i] = br.readLine().toUpperCase();
		}
	}

}
