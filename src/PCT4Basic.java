import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PCT4Basic {

	String[] string;
	int noOfString;
	
	public static void main(String[] args) {

		PCT4Basic obj = new PCT4Basic();
		obj.getInput();
		obj.check();
		
	}

	private void check() {
		for(int i =0; i<string.length; i++)
		{
			System.out.println(checkValidity(string[i]));
		}
	}

	private String checkValidity(String str) {
		
		boolean flag = true;
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<str.length(); i++)
		{
			char ch = str.charAt(i);
			switch(ch)
			{
			case '(': 
			case '{' : 
			case '[' : st.push(ch);
						break;
			case '}' :
				if(!st.isEmpty()&&st.peek()!='{')
				{
					return "FALSE";
				}
				else
				{
					st.pop();
				}
				break;			
			case ')' :
				if(!st.isEmpty()&&st.peek()!='(')
				{
					return "FALSE";
				}
				else
				{
					st.pop();
				}
				break;			
			case ']' :
				if(!st.isEmpty()&&st.peek()!='[')
				{
					return "FALSE";
				}
				else
				{
					st.pop();
				}
				break;						
			}
		}
		
		return "TRUE";
		
	}

	private void getInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			noOfString = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		string = new String[noOfString];
  		
		for(int i=0; i<noOfString; i++)
		{
			try {
				string[i] = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
