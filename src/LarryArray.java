import java.util.Arrays;

public class LarryArray {

	static String larrysArray(int[] a) {

        int n = a.length;
        bubleSort(a, n);
       return (a[n - 2] < a[n - 1] ? "YES" : "NO");

    }

    public static void bubleSort(int[] array, int n) {
        for (int i = 0; i < n - 2; i++) {
            for (int j = n - 2 - 1; j >= i; j--) {
                while (array[j] > array[j + 1] || array[j] > array[j + 2]) {
                    rotate(array, j);
                }
            }
        }
    }
	 
	
	private static void rotate(int[] a, int i) {
		
		int temp = a[i-1];
		a[i-1]= a[i];
		a[i] = a[i+1];
		a[i+1] = temp;
		
	}


	private static boolean sortedCheck(int[] a) {
		
		int[] p = a.clone();
		Arrays.sort(p);
		if(p==a)
			return true;
		else
			return false;
		
	}


	private static int findPos(int[] a, int j) {
		for(int i=0; i!=j; i++)
		{
			if(a[i-1]>a[i]&&a[i]>a[i+1])
				return i;
			if(i+1 == a.length)
				i =0;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
