import java.util.ArrayList;
import java.util.Arrays;

public class ZigzagArray {

	public static void main(String[] args) {

		int[] ar = {5, 3, 1, 2 ,4, 9, 7, 8};
		getZigzag(ar);
	}

	private static void getZigzag(int[] ar) {
		Arrays.sort(ar);
		ArrayList<Integer> li = new ArrayList<>();
		int i =0, j;
		if(ar.length%2==0)
			j = ar.length/2;
		else
			j = (ar.length/2)+1;
		while(i<(ar.length/2))
		{
			li.add(ar[i++]);
			li.add(ar[j++]);
		}
		
		System.out.println(li);
	}

}
