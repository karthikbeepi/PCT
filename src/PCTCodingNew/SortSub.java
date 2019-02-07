package PCTCodingNew;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class SortSub {

	StringBuilder op = new StringBuilder();
	
		
	
	public static void main(String[] args) {
		
		SortSub ob = new SortSub();
		ob.getInput();
		System.out.print(ob.op);
		
	}



	private void getInput() {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		for(int i=0; i<n; i++)
		{
			String[] sp = scan.nextLine().split(" ");
			op.append(sortedSub(sp[0], Integer.parseInt(sp[1]), Integer.parseInt(sp[2]))+"\n");
		}
	}



	public String sortedSub(String string, int from, int to) {
		
		char[] aa = string.substring(from, to+1).toCharArray();
		Character[] ar = new Character[aa.length]; 
		for(int i=0; i<aa.length; i++)
		{
			ar[i] = aa[i];
		}
		Arrays.sort(ar, Collections.reverseOrder());		
		StringBuilder toPrint = new StringBuilder();
		for(int i=0; i<string.length(); i++)
		{
			if(i<from||i>to)
				toPrint.append(string.charAt(i));
			else
			{
				toPrint.append(ar[i-from]);
			}
		}
		
 		return toPrint.toString();
	}

}
