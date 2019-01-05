
public class PagesInBook {

	static int pageCount(int n, int p) {
        
		if(n-p<=p)
		{
			if(p+1==n)
				return 1;
			
			if(n%2==0)
				return ((n-p)/2)+1;
			else
				return ((n-p)/2);
		}
		
		return (p)/2;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(pageCount(8, 7));
		
	}

}
