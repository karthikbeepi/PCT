public class AllSubarray {

	public static void main(String[] args) {

		findSubArray("ABCDEF".toCharArray(),"ABCDEF".length() );
	}

	private static void findSubArray(char[] s, int lengthString) {
		 for (int lenSub = 1; lenSub <= lengthString; lenSub++) { 
	            // Pick ending point 
	            for (int i = 0; i <= lengthString - lenSub; i++) { 
	                //  Print characters from current 
	                // starting point to current ending 
	                // point.   
	                int j = i + lenSub - 1; 
	                for (int k = i; k <= j; k++) { 
	                    System.out.print(s[k]); 
	                } 
	  
	                System.out.println(); 
	            } 
		 }
	}

}
