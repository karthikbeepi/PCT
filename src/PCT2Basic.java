import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PCT2Basic {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		PCT2Basic obj = new PCT2Basic();
		int uw = obj.findUniqueWords(input);
		System.out.println("\n"+uw);
		
	}

	private int findUniqueWords(String input) {
		String[] splitWords = input.split("[\\s\\n]+");
		ArrayList<String> uniqueWords = new ArrayList<String>();
		uniqueWords.add(splitWords[0]);
		Boolean b ;
		for(String t : splitWords)
		{
			b = true;
			for(String g : uniqueWords)
			{
				if(g.equalsIgnoreCase(t))
				{
					b = false;
					break;
				}
			}
			
			if(b)
				uniqueWords.add(t);
		}
		for(String t : uniqueWords)
			System.out.print(t+" ");
		return uniqueWords.size();
	}

}
