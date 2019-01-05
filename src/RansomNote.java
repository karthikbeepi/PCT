import java.util.HashMap;

public class RansomNote {

	static void checkMagazine(String[] magazine, String[] note) {

		HashMap<String, Integer> mag = getHM(magazine);
		HashMap<String, Integer> n = getHM(note);
		if(checkIt(mag, n))
			System.out.println("YES");
		else
			System.out.println("NO");

    }
	
	private static boolean checkIt(HashMap<String, Integer> mag, HashMap<String, Integer> n) {
		
		for(String s: n.keySet())
		{
			if(mag.get(s)!=n.get(s))
				return false;
		}
		
		return true;
	}

	private static HashMap<String,Integer> getHM(String[] magazine) {
		
		HashMap<String, Integer> ht = new HashMap<String, Integer>();
		for(String s: magazine)
		{
			if(ht.put(s,1 )!=null)
			{
				int getVal = ht.get(s);
				ht.put(s, ++getVal);
			}
		}
		
		return ht;
		
	}

	public static void main(String[] args) {

		String s[] = new String[7];
		s[0]= "give";
		s[1] = "me";
		s[2] = "one";
		s[3]= "grand";
		s[4] = "today";
		s[5] = "night";
		s[6]= "world";
		String p[] = new String[5];
		p[0] = "give";
		p[1] = "one";
		p[2] = "grand";
		p[3]= "today";
		p[4] = "one";
		checkMagazine(s,p);
	}

}
