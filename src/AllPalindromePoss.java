
public class AllPalindromePoss {

	public AllPalindromePoss(String string) {
		findPart(string, 0);
	}

	private void findPart(String string, int p) {
		p++;
		if(pali(string))
			System.out.print(" "+string);
		if(string.length()-p>=p)
		{
			findPart(string.substring(p-1, p), p);
			findPart(string.substring(p, string.length()-p), p);
			findPart(string.substring(string.length()-p, string.length()-1), p);
		}
			
		
	}

	private boolean pali(String string) {
		int i=0, j=string.length()-1;
		while(i<j)
		{
			if(string.charAt(i)!=string.charAt(j))
				return false;
			else
			{
				i++;
				j--;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {

		AllPalindromePoss ob = new AllPalindromePoss("MALAYALAM");
		
	}

}
