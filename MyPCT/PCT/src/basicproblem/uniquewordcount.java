package basicproblem;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class uniquewordcount {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String[] name = str.toLowerCase().split(" ");
		HashSet<String> set = new HashSet<String>();
		
		for(int i = 0; i < name.length; i++) {
			set.add(name[i]);
		}
		set.remove("");
		
		System.out.println(set.size());
	}

}
