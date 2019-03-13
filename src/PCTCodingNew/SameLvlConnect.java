package PCTCodingNew;

import java.util.ArrayList;
import java.util.Scanner;


public class SameLvlConnect {

	class Node
	{
		int data, mark;
		Node left, right, nextRight;
		public Node(int i) {
			data = i;
			left = right = nextRight = null;
		}
	}
	
	Node root;
	
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
	
	public static void main(String[] args) {

		SameLvlConnect obj = new SameLvlConnect();
		obj.getInput();
		
	}

	int noOfNodes;
	
	private void getInput() {
		Scanner scan = new Scanner(System.in);
		noOfNodes = Integer.parseInt(scan.nextLine());
		String[] sp = scan.nextLine().split(" ");
		root = new Node(Integer.parseInt(sp[0]));
		addNode(Integer.parseInt(sp[1]), sp[2].charAt(0));
		for(int j=3; j<sp.length; j+=3)
		{
			addNode(root, Integer.parseInt(sp[j]), Integer.parseInt(sp[j+1]), sp[j+2].charAt(0));
		}
		establishConnection();
		
	}
	
	private void establishConnection() {
		dfsMark(root, 0);
		makeConnect();
	}

	private void makeConnect() {
		root.nextRight = null;
		ArrayList<Node> ar = new ArrayList<>();
		ar.add(root);
		int i=0;
		while(i<noOfNodes)
		{
			Node temp = ar.get(i++);
			if(temp.left!=null)
				ar.add(temp.left);
			if(temp.right!=null)
				ar.add(temp.right);
		}
		
		for(i=0; i<noOfNodes-1; i++)
		{
			Node temp = ar.get(i);
			Node next = ar.get(i+1);
			if(temp.mark==next.mark)
				temp.nextRight = next;
			else
				temp.nextRight=null;
		}
		Node temp = ar.get(i);
		temp.nextRight = null;
		for(i=0; i<noOfNodes-1; i++)
		{
			temp = ar.get(i);
			Node next = ar.get(i+1);
			if(temp.mark==next.mark)
				System.out.print(temp.data+" -> ");
			else
				System.out.println(temp.data+" -> "+"NULL");
		}
		 temp = ar.get(i);
		System.out.println(temp.data+" -> "+"NULL");
	}

	private void dfsMark(Node r, int i) {
		
		if(r==null)
			return ;
		r.mark = i;
		dfsMark(r.left, i+1);
		dfsMark(r.right, i+1);
				
	}

	private void addNode(int parseInt, char charAt) {
		if(charAt == 'L')
			root.left = new Node(parseInt);
		else
			root.right = new Node(parseInt);
	}
	

}
