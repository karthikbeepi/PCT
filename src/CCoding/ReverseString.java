package CCoding;

public class ReverseString {

	public String revString(String str)
	{
		char[] b = str.toCharArray();
		int i=0, j=str.length()-1;
		while(i<j)
		{
			while(!Character.isAlphabetic(b[i]))
				i++;
			while(!Character.isAlphabetic(b[j]))
				j--;
			swap(i, j, b);
			i++;
			j--;
		}
		
		return String.valueOf(b);
	}

	private void swap(int i, int j, char[] b) {
	
		char temp = b[i];
		b[i] = b[j];
		b[j] = temp;
		
	}
	
	public static void main(String args[]) {
		
		ReverseString s = new ReverseString();
		System.out.println(s.revString("h&e!!llo"));
		
	}
	
}
