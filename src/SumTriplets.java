
public class SumTriplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] number = {1,2,3, 4, 5, 6, 7, 8, 9, 10};
		findTriplets(number, 10);
		
	}

	private static void findTriplets(int[] number, int num) {
		
		for(int i =0; i<number.length; i++)
			for(int j = i +1 ; j<number.length; j++)
				for(int k = j+1; k<number.length; k++)
					if(number[i]+number[j]+number[k]==num)
						System.out.println("{"+number[i]+number[j]+number[k]+"}");
		
	}

}
