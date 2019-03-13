package grap;

import java.util.Scanner;

public class LeftView {
	
	class Node{
		int data;
		Node left, right;
		
		public Node(int i) {
			
			data = i;
			left = right = null;
			
		}
	}
	
	Node root = null;	
	
	public static void main(String args[]) {
		
		LeftView ob = new LeftView();
		ob.getInput();
		
	}
	
	public void addNode(Node r, int val, int i, char c)
	{
		if(r==null)
			return ;
		else
		{
			if(r.data==val)
			{
				if(c == 'L')
					r.left = new Node(i);
				else
					r.right = new Node(i);
			}
			
			else
			{
				addNode(r.left, val, i, c);
				addNode(r.right, val, i, c);
			}
		}
	}
	
	public void printNode(Node r)
	{
		if(r==null)
			return ;
		else
		{
			System.out.println(r.data);
			printNode(r.left);
			//printNode(r.right);
		}
	}
	

	private void getInput() {
	
		Scanner scan = new Scanner(System.in);
		int T = Integer.parseInt(scan.nextLine());	
		for(int i=0; i<T; i++)
		{
			int noOfNodes = Integer.parseInt(scan.nextLine());
			String[] sp = scan.nextLine().split(" ");
			root = new Node(Integer.parseInt(sp[0]));
			addNode(Integer.parseInt(sp[1]), sp[2].charAt(0));
			for(int j=3; j<sp.length; j+=3)
			{
				addNode(root, Integer.parseInt(sp[j]), Integer.parseInt(sp[j+1]), sp[j+2].charAt(0));
			}
			printNode(root);
		}
		
	}

	private void addNode(int parseInt, char charAt) {
		if(charAt == 'L')
			root.left = new Node(parseInt);
		else
			root.right = new Node(parseInt);
	}
}
