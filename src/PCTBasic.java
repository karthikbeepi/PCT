import java.util.Scanner;

public class PCTBasic {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		
		String name[] = input.split(" ");
		
		if(name.length==3)
			System.out.println(name[2]+" "+name[0]+" "+name[1]);
		else if(name.length==2)
		{
			Boolean surBool = checkSoL(name[1]);
			if(surBool)
				System.out.println(name[1]+" "+name[0]);
			else
				System.out.println(name[0]+" "+name[1]);
		}
	}

	private static Boolean checkSoL(String string) {
		
		char c = string.charAt(string.length()-1);
		System.out.println(c);
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
					return true;
		default : return false;
		}
		
	}

}
