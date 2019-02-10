import java.util.Scanner;

public class Names {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] sp = scan.nextLine().split(" ");
		StringBuilder op = new StringBuilder();
		if(sp.length==3)
		{
			op.append(sp[2]+" "+sp[0]+" "+sp[1]);
		}
		
		else if(sp.length==1)
		{
			op.append(sp[0]);
		}
		
		else if(sp.length==2)
		{
			char c = sp[1].charAt(sp[1].length()-1);
			switch(c)
			{
			case 'a':
			case 'A':
			case 'e':
			case 'E':
			case 'i':
			case 'I':
			case 'o':
			case 'O':
			case 'u':
			case 'U':
				op.append(sp[1]+" "+sp[0]);
				break;
				default:
					op.append(sp[0]+" "+sp[1]);
			}
		}
		
		System.out.print(op.toString());
		
	}

}
