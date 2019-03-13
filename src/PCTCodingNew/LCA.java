package PCTCodingNew;

import java.util.ArrayList;
import java.util.Scanner;


public class LCA {
	
	class Node{
		int data;
		Node left, right;
		
		public Node(int i) {
			data = i;
			left = right = null;
		}
	}
	
	Node root = null;	
	
	public static void main(String args[])
	{
		LCA obj = new LCA();
		obj.getInput();
		
	}

	private void getInput() {
		Scanner scan = new Scanner(System.in);
		int noOfNodes = Integer.parseInt(scan.nextLine());
		String[] sp = scan.nextLine().split(" ");
		root = new Node(Integer.parseInt(sp[0]));
		addNode(Integer.parseInt(sp[1]), sp[2].charAt(0));
		for(int j=3; j<sp.length; j+=3)
		{
			addNode(root, Integer.parseInt(sp[j]), Integer.parseInt(sp[j+1]), sp[j+2].charAt(0));
		}
		sp = scan.nextLine().split(" ");
		System.out.println(lca(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), root));
		
	}

	private int lca(int var1, int var2, Node r) {
		
		
		if(search(var1, r.left)&&search(var2, r.left))
			return lca(var1, var2, r.left);
		else if(search(var1, r.right)&&search(var2, r.right))
			return lca(var1, var2, r.right);
		else if(search(var1, r)&&search(var2, r))
			return r.data;
		else
			return -1;
		
	}

	private boolean search(int var, Node cur) {
		
		ArrayList<Node> ar = new ArrayList<>();
		ar.add(cur);
		while(!ar.isEmpty())
		{
			Node temp = ar.remove(0);
			if(temp.data==var)
				return true;
			else
			{
				if(temp.left!=null)
					ar.add(temp.left);
				if(temp.right!=null)
					ar.add(temp.right);
			}
		}
		
		return false;
		
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
			printNode(r.right);
		}
	}
	
	private void addNode(int parseInt, char charAt) {
		if(charAt == 'L')
			root.left = new Node(parseInt);
		else
			root.right = new Node(parseInt);
	}
	

}
