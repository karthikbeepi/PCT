package assignment1;

import java.util.ArrayList;

class sub { 

	class Combo{
		int[] ar;
		Combo(int[] a)
		{
			ar = a;
		}
		void printCombo(int amt){
			for(int i: ar)
				System.out.print(i+amt+" ");
			System.out.println();
		}
	}
	
	ArrayList<Combo> c = new ArrayList<>();
	
	public void CombinationRepetitionUtil(int chosen[], int arr[], int index, int r, int start, int end) { 
		int sum=0;
		for(int i=0; i<index; i++)
		{
			sum+=arr[chosen[i]];
			if(sum<0)
				return;
		}
		if (index == r ) { 
			if(sum==0)
			{
				int temp[] = new int[r];
				if(arr[chosen[0]]==arr[0]||arr[chosen[r-1]]==arr[arr.length-1]) 
				{
					for (int i = 0; i < r; i++) { 
						temp[i] = arr[chosen[i]];						
					} 
					c.add(new Combo(temp));
				}
			}
			return; 
		} 

		// One by one choose all elements (without considering 
		// the fact whether element is already chosen or not) 
		// and recur 
		for (int i = start; i <= end; i++) { 
			chosen[index] = i; 
			CombinationRepetitionUtil(chosen, arr, index + 1,r, i, end); 
		} 
		return; 
	} 

//The main function that prints all combinations of size r 
//in arr[] of size n with repitions. This function mainly 
//uses CombinationRepetitionUtil() 
	public void CombinationRepetition(int arr[], int n, int r) { 
		int chosen[] = new int[r + 1]; 
		CombinationRepetitionUtil(chosen, arr, 0, r, 0, n - 1); 
	} 

//Driver program to test above functions 
	public static void main(String[] args) { 
		int arr[] = {2, 1,0, -1, -2};  //Array from b to -b
		int n = arr.length; 
		int r = 3; 			//Number of periods p
		sub obj = new sub();
		obj.CombinationRepetition(arr, n, r); 
		for(Combo i : obj.c)
		{
			i.printCombo(5);
		}
	} 
} 
