package PCTCodingNew;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxPro {
	
	ArrayList<Integer> ar = new ArrayList<>();

	public static void main(String[] args) {
		MaxPro obj = new MaxPro();
		obj.getInput();
	}

	private void getInput() {
		Scanner scan = new Scanner(System.in);
		String sp[] = scan.nextLine().split(" ");
		for(String s : sp)
			ar.add(Integer.parseInt(s));
		System.out.println(findMax());
	}

	private int findMax() {
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<ar.size()-2; i++)
			for(int j=i+1; j<ar.size()-1; j++)
				for(int k=j+1; k<ar.size(); k++)
				{
					int temp = ar.get(i)*ar.get(j)*ar.get(k);
					if(temp > max)
						max = temp;
				}
		return max;
		
	}

}
