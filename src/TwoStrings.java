
public class TwoStrings {

	 static String twoStrings(String s1, String s2) {

		 for(char c : s1.toCharArray())
		 {
			 if(s2.contains(String.valueOf(c)))
				 return "YES";
		 }

		 return "NO";
	    }
	
	public static void main(String[] args) {

		System.out.println(twoStrings("hi", "world"));;
	}

}
