import java.util.Arrays;
import java.util.Scanner;

public class lca {
	
	class Node{
		int data;
		Node left, right;
		public Node(int i) {
			data = i;
		}
	}
	
	Node root;
	
	int ar[];

	public static void main(String[] args) {
		lca ob = new lca();
		ob.getInput();
		ob.printNode();
	}
	private void printNode() {
		printNode(root);
	}
	private void printNode(Node r) {
		if(r==null)
			return;
		
		System.out.println(r.data);
		printNode(r.left);
		printNode(r.right);
	}
	public void getInput()
	{
		Scanner scan = new Scanner(System.in);
		int no = Integer.parseInt(scan.nextLine());
		ar = new int[no];
		for(int i=0; i<no; i++)
			ar[i] = Integer.parseInt(scan.nextLine());
		Arrays.sort(ar);
		root = makeBT(ar, 0, ar.length-1, root);
//		for(int i=0; i<no; i++)
//			addNode(ar[i]);
//		findlca(5, 3, root);
	}
	private Node makeBT(int[] ar, int  start, int end, Node r) {
		
		if(start>end)
			return null;
		int mid = (start+end)/2;
		r=new Node(ar[mid]);
		r.left = makeBT(ar, start, mid-1, r);
		r.right = makeBT(ar, mid+1, end, r);
		return r;
		
		
	}
	private void findlca(int i, int j, Node r) {
		
		if(i>j)
		{
			findlca(j, i, r);
			return;
		}
		
		if(i<r.data&&j>r.data)
			System.out.println(r.data);
		else if(i<r.data&&j<r.data)
			findlca(i, j, r.left);
		else if(i>r.data&&j>r.data)
			findlca(i, j, r.right);
		else if(i==r.data||j==r.data)
		{
			System.out.println(r.data);
		}
		
		
	}
	private void addNode(int parseInt) {
		if(root==null)
			root = new Node(parseInt);
		else
		{
			addNode(root, parseInt);
		}
		
	}
	private void addNode(Node r, int parseInt) {
		
		if(r.data<parseInt)
		{
			if(r.right!=null)
				addNode(r.right, parseInt);
			else
				r.right = new Node(parseInt);
		}
		else
		{
			if(r.left!=null)
				addNode(r.left, parseInt);
			else
				r.left = new Node(parseInt);
		}
	}
}
