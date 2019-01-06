package lowestCommonAncestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * start of each line num=2^h-1
 * end of each line num=2^(h+1)-2
 * the k th element value=k leftChild=2*k+1 rightChild=2*k+2
 */
public class CommonAncestor {

	public static int treeHeight;
	
	public static void main(String[] args) {
		
		List<Integer> listNum1=new ArrayList<>();
		List<Integer> listNum2=new ArrayList<>();
		int commonAncestor;
		int ancestorHeight;
		
		Scanner scanner=new Scanner(System.in);
		String tempStr=scanner.nextLine();
		String[] str=tempStr.split(" ");
		scanner.close();
		int[] arrayNum=new int[3];
		for(int i=0;i<3;i++){
			arrayNum[i]=Integer.parseInt(str[i]);
		}
		treeHeight=arrayNum[0];
		
		//get array of ancestor

		if (arrayNum[1] <= Math.pow(2, treeHeight + 1) - 2) {
			if (arrayNum[1] == 0) {
				System.out.println(0 + " " + 0);
				return;
			} else {
				listNum1=getAncestors(arrayNum[1]);
			}
		}
		
		if (arrayNum[2] <= Math.pow(2, treeHeight + 1) - 2) {
			if (arrayNum[2] == 0) {
				System.out.println(0 + " " + 0);
				return;
			} else {
				listNum2=getAncestors(arrayNum[2]);
			}
		}
		
		commonAncestor=getCommonAncestor(listNum1,listNum2);
		ancestorHeight=getHeight(commonAncestor);
		
		System.out.println(commonAncestor+" "+ancestorHeight);

	}

	/**
	 * @param commonAncestor
	 * @return
	 */
	public static int getHeight(int commonAncestor) {
		int tempHeight=0;
		int tempCommonAncestor=commonAncestor;
		if(commonAncestor==0){
			return 0;
		}else{
			while(true){
				if(tempCommonAncestor%2==0){
					tempCommonAncestor=(tempCommonAncestor-2)/2;
					tempHeight++;
				}else if(tempCommonAncestor%2==1){
					tempCommonAncestor=(tempCommonAncestor-1)/2;
					tempHeight++;
				}else if(tempCommonAncestor==0){
					break;
				}
			}
		}
		return tempHeight;
	}

	/**
	 * @param listNum1
	 * @param listNum2
	 * @return
	 */
	public static int getCommonAncestor(List<Integer> listNum1, List<Integer> listNum2) {
		int tempLength=listNum1.size()<listNum2.size()?listNum1.size():listNum2.size();
		int commonAncestor = 0;
		for(int i=0;i<tempLength;i++){
			int temp1=listNum1.get(i);
			for(int j=0;j<tempLength;j++){
				int temp2=listNum2.get(j);
				if(temp1==temp2){
					commonAncestor=temp1;
				}
			}
		}
		return commonAncestor;
	}

	/**
	 * @param i
	 */
	public static List<Integer> getAncestors(int i) {
		List<Integer> list=new ArrayList<>();
		while(i-2>0){
			if(i%2==0){
				int tempR=(i-2)/2;
				list.add(tempR);
				getAncestors(tempR);
			}else{
				int tempL=(i-1)/2;
				list.add(tempL);
				getAncestors(tempL);
			}
		}
		return list;
	}

	
	
}
