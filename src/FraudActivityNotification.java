import java.util.Arrays;

public class FraudActivityNotification {

	 static int activityNotifications(int[] expenditure, int d) {
		 float median;
		 int count=0;
		 for(int i=d; i<expenditure.length; i++)
		 {
			 median = findMedian(expenditure, i, d);
			 System.err.println(median+" "+expenditure[i]);
			 if((float)2 * median <= (float)(expenditure[i]))
				 count++;
		 }
		 return count;
	 }
	
	private static float findMedian(int[] expenditure, int i, int d) {
		int[] smallAr = new int[d];
		int j=0;
		for(int k = i-d; k<i; k++)
			smallAr[j++]= expenditure[k];
		Arrays.sort(smallAr);
		if(d%2==0)
			return (float)(smallAr[(d-1)/2] + smallAr[(d/2)])/2;
		else
			return (float)smallAr[(d/2)];
	}

	public static void main(String[] args) {

		int[] expenditure = {1 ,2 ,3 ,4 ,4};
		int[] e = {2 ,3 ,4 ,2 ,3 ,6 ,8 ,4 ,5};
		int[] e2 = {10, 20, 30, 40, 50};
		int d=4, d1=5, d2 = 3;
		System.out.println(activityNotifications(expenditure, d));
		System.out.println(activityNotifications(e, d1));
		System.out.println(activityNotifications(e2, d2));
		
	}

}
