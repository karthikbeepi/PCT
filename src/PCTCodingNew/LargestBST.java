package PCTCodingNew;

import java.util.Scanner;

public class LargestBST {

	class Node{
		int data;
		Node left , right;
		public Node(int i) {
			data = i;
		}
	}
	
	Node root;
	
	public void addNode(int i)
	{
		Node temp = root;
		if(temp==null)
		{
			root = new Node(i);
			return ;
		}
		while(temp!=null)
		{
			if(temp.data>i)
			{
				if(temp.left==null){
					temp.left = new Node(i);
					return ;
				}
				else
					temp =temp.left;
			}
			else
			{
				if(temp.right==null)
				{

					temp.right = new Node(i);
					return ;
				}
				else
					temp = temp.right;
			}
		}
	}
	
	public static void main(String[] args) {

		LargestBST obj = new LargestBST();
		obj.getInput();
		
	}
	private void getInput() {
		
		Scanner scan = new Scanner(System.in);
		String sp[] = scan.nextLine().split(" ");
		for(String s: sp)
		{
			addNode(Integer.parseInt(s));
		}
		int num = Integer.parseInt(scan.nextLine());
		System.out.println(findNum(num));
	}

	private int findNum(int num) {
		Node temp = root;
		Node prev= temp;
		while(temp!=null)
		{
			if(temp.data<num)
			{
				prev = temp;
				temp = temp.right;
			}
			else if(temp.data>num)
			{
				prev = temp;
				temp = temp.left;
			}
			else
			{
				prev = temp;
				temp = temp.left;
			}
		}
		
		return prev.data;
	}

}
