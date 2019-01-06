package basicproblem;

import java.util.*;

public class TranscriptNamePrinting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Pls enter the name: ");
		String[] name = scan.nextLine().split(" ");
		String space = " ";
		if (name.length == 3) {
			System.out.println(name[2] + space + name[0] + space + name[1]);
		} else if (name.length == 1) {
			System.out.println(name[0]);
		} else if (name.length == 2) {
			String s = "aeiouAEIOU";
			int n = name[1].length()-1;
			String a = name[1].charAt(n) + "";
			if(s.contains(a)) {
				System.out.println(name[1] + space + name[0]);
			} else {
				System.out.println(Arrays.toString(name));
			}
		} else {
			System.out.println("Fuck you!");
		}
		scan.close();
	}

}
