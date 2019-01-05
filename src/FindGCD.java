
public class FindGCD {

	public static void main(String[] args) {

		findGCD(24,18);
		
	}

	private static void findGCD(int i, int j) {
		
		if(i==0)
		{
			System.out.println(j);
			return ;
		}
		
		findGCD(j%i, i);
		
	}

}
