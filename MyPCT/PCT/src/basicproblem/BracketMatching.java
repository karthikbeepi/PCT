package basicproblem;

import java.util.Scanner;
import java.util.Stack;

public class BracketMatching {

	public static void main(String[] args) {
		Scanner scanNum = new Scanner(System.in);
		int strNum = scanNum.nextInt();
		int count = 0;
		String pattern = "^[a-zA-Z0-9\\(\\)\\[\\]\\{\\}\\s]+$";
		String[] strArray = new String[strNum];
		
		while (count < strNum) {
			Scanner scanStr = new Scanner(System.in);
			String str = scanStr.nextLine();
			if(str.matches(pattern)) {
				strArray[count] = str;
				count++;
			}
		}
		
		for(String str : strArray) {
			Stack<Character> stack = new Stack<Character>();
			
			for(int i = 0; i < str.length(); i++) {
				char current = str.charAt(i);
				
				if(current == '{' || current == '(' || current == '[') {
					stack.push(current);
				}
				
				if(current == '}' || current == ')' || current == ']') {
					if(stack.isEmpty()) {
						System.out.println("false");
					}
					
					char last = stack.peek();
					
					if(current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[') {
						stack.pop();
					}
				}
			}
			
			System.out.println(stack.isEmpty());
		}
	
		
	}

}
