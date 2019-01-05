
public class SubstringofString {

	public static void main(String[] args) {

		findAllSubstrings("abc".toCharArray());
		
	}

	private static void findAllSubstrings(char[] string) {
		findAllSubstrings(string, 0);
	}

	static void swap(int i, int j, char[] ar)
	{
		char temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
	
	private static void findAllSubstrings(char[] string, int i) {
		if(i==string.length-1)
			return ;
		else
		{
			swap(i,i+1, string);
			findAllSubstrings(string, i+1);
			System.out.println(string);
			swap(i,i+1, string);
		}
	}

}
