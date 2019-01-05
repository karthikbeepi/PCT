
public class InfinteString {

	public static void main(String[] args) {
		System.out.println(findOcc("abcac", 10));
		System.out.println(findOcc("aba", 10));
		System.out.println(findOcc("ababa", 3));
		
	}

	private static long findOcc(String string, long j) {
		StringBuilder b = new StringBuilder();
		long n = noOfRep(string, j);
		b.append(string);
		int k;
		if(n==0)
			k = (int) j;
		else
			k = (int) (j%n);
		long noOfA = findAOcc(string)*(n);
		noOfA += findAOcc(b.toString().substring(0,k));
		return noOfA;
	}

	private static int findAOcc(String string) {
		int count=0;
		for(int i=0; i<string.length(); i++)
			if(string.charAt(i)=='a')
				count++;
		return count;
	}

	private static long noOfRep(String string, long i) {
		return i/string.length();
	}

}
