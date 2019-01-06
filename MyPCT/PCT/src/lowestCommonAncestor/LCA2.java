package lowestCommonAncestor;

import java.util.Scanner;

public class LCA2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner=new Scanner(System.in);
		String number=scanner.nextLine();
		String arr[]=number.split(" ");
		int firstLabel=Integer.parseInt(arr[1]);
		int secondLabel=Integer.parseInt(arr[2]);
		
		firstLabel = compareHeight(firstLabel, secondLabel);
		System.out.println(firstLabel+" "+getHeight(firstLabel));
		scanner.close();
		}

	public static int compareHeight(int firstLabel, int secondLabel) {
		int height1=getHeight(firstLabel);
		int height2=getHeight(secondLabel);
		
		while(height1>height2){
			firstLabel=getRoot(firstLabel);
			height1--;
		}
		while(height1<height2){
			secondLabel=getRoot(secondLabel);
			height2--;
		}
		while(firstLabel!=secondLabel){
			firstLabel=getRoot(firstLabel);
			secondLabel=getRoot(secondLabel);
		}
		
		return firstLabel;
	}

		
		public static int getHeight(int num) {
			
			// TODO Auto-generated method stub
			if(num==0){
				return 0;
			}
			int height=0;
			int currentNode=num;
			
			while(true){
				currentNode=getRoot(currentNode);
				height++;
				if(currentNode==0)
					break;
			}
			
			return height;
		}
		
		

		public static int getRoot(int des) {
			if(des%2!=0){
				int res=(des-1)/2;
				return res;
			}else
			return des/2-1;
			
		}
		
	}

