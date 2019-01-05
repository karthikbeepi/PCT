import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class PCTAdv {

	public class Node{
		String data;
		Node left , right;
		public Node(String s) {
			data = s;
		}
	}
	
	Node root;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfNodes = Integer.parseInt(br.readLine());
		String parent[] = new String[noOfNodes];
		String child[] = new String[noOfNodes];
		String temp[] = new String[2];
 		for(int i=0; i<noOfNodes; i++)
		{
			String t = br.readLine();
			temp = t.split(" ");
			parent[i] = temp[0];
			child[i] = temp[1];
		}
 		int noOfTest = Integer.parseInt(br.readLine());
 		String[] tests= new String[noOfTest];
 		for(int i=0; i<noOfTest; i++)
		{
			tests[i] = br.readLine();
			
		}
 		PCTAdv ob = new PCTAdv();
 		ob.createTree(parent, child);
 		System.out.println();
 		for(int i=0; i<noOfTest; i++)
 		{
 			System.out.print(ob.checkAss(tests[i])+" ");
 		}
 		System.out.println();
		ob.preorder();
	}

	private char checkAss(String string) {
		String[] str = string.split(" ");
		if(str[1].compareToIgnoreCase("child")==0)
			return checkChild(str[0], str[2]);
		else if(str[1].compareToIgnoreCase("parent")==0)
			return checkParent(str[0], str[2]);
		else if(str[1].compareToIgnoreCase("sibling")==0)
			return checkSibling(str[0], str[2]);
		else if(str[1].compareToIgnoreCase("ancestor")==0)
			return checkAncestor(str[0], str[2]);
		else if(str[1].compareToIgnoreCase("descendant")==0)
			return checkDesc(str[0], str[2]);
		return 'F';
	}

	private char checkDesc(String string, String string2) {
		Node anc = search(string2);
		if(anc==null)
			return 'F';
		else 
		{
			if (anc.right!=null)
			{
				if(search(anc.right, string)!=null)
						return 'T';
			}
			
			if( anc.left!=null)
			{
				if(search(anc.left, string)!=null)
					return 'T';
			}
			
		return 'F';
		}
	}

	private char checkAncestor(String string, String string2) {
		return checkDesc(string2, string);
	}

	private char checkSibling(String string, String string2) {
		Node parent = search(this.root, string);
		if(parent == null)
			return 'F';
		else
		{
		
			if(parent.right!=null)
			{
				if(parent.right.data.compareToIgnoreCase(string2)==0)
					return 'T';
			}
			if(parent.left!=null)
			{
				if(parent.left.data.compareToIgnoreCase(string2)==0)
					return 'T';
			}
			
			return 'F';
		}
	}

	private char checkParent(String string, String string2) {
		return checkChild(string2, string);
	}

	private char checkChild(String string, String string2) {
		Node parent = search(this.root, string2);
		if(parent == null)
			return 'F';
		else
		{
			if(parent.right!=null)
			{
				if(parent.right.data.compareToIgnoreCase(string)==0)
					return 'T';
			}
			if(parent.left!=null)
			{
				if(parent.left.data.compareToIgnoreCase(string)==0)
					return 'T';
			}
			
			return 'F';
		}
		
		
	}

	private void preorder() {
		preorder(this.root);
	}

	private void preorder(Node r) {
		
		if(r==null)
			return;
		System.out.print(r.data+" ");
		preorder(r.left);
		preorder(r.right);
		
	}

	private void createTree(String[] parent, String[] child) {
		for(int i=0; i<parent.length; i++)
		{
			addNode(parent[i], child[i]);
		}
	}

	private void addNode(String parent, String child) {
		
		if(root==null)
		{
			Node newNode = new Node(parent);
			root = newNode;
			newNode = new Node(child);
			root.left = newNode;
		}
		else
		{
			Node toAdd = search(parent);
			Node newNode = new Node(child);
			if(toAdd.left==null)
				toAdd.left = newNode;
			else
				toAdd.right = newNode;
		}
		
	}

	private Node search(String parent) {
		return search(this.root, parent);
	}

	private Node search(Node root, String parent) {
	
		if(root==null)
			return null;
		else
		{
			if(root.data.compareTo(parent)==0)
				return root;
			else
			{
				Node check = search(root.left, parent);
				if(check!=null)
					return check;
				else
				{
					check = search(root.right, parent);
					if(check!=null)
						return check;
				}
					
			}
		}
		return null;
	
	}

	

}
