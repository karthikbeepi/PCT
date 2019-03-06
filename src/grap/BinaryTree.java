package grap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinaryTree {

	class Node{
		int data;
		Node left, right;
		public Node(int i) {	
			data = i;
			left = right = null;
		}
	}
	
	Node root;
	
	ArrayList<Integer> lis = new ArrayList<>();
	
	public void addNode(int i)
	{
		addNode(root, i);
	}
	
	private void addNode(Node r, int i) {
		if(r==null)
		{
			root = new Node(i);
		}
		else
		{
			if(r.data<i)
			{
				if(r.right==null)
				{
					r.right = new Node(i);
				}
				else
				{
					addNode(r.right, i);
				}
			}
			else
			{
				if(r.left==null)
				{
					r.left = new Node(i);
				}
				else
				{
					addNode(r.left, i);
				}
			}
		}
		
	}

	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		bt.getInput();
		bt.printSingleChild();
	}

	private void printSingleChild() {
		printSingleChild(root);
		Collections.sort(lis);
		for(int i=0; i<lis.size()-1; i++)
		{
			System.out.print(lis.get(i)+" ");
		}
		System.out.print(lis.get(lis.size()-1));
	}

	private void printSingleChild(Node r) {
		if(r==null)
			return ;
		else
		{
			if(r.left!=null)
				printSingleChild(r.left);
			if(r.right!=null)
				printSingleChild(r.right);
			if(r.right==null&&r.left!=null)
				lis.add(r.left.data);
			else if(r.right!=null&&r.left==null)
				lis.add(r.right.data);
		}
	}

	private void getInput() {
		
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String[] nums = scan.nextLine().split(" ");
		for(int i=0; i<nums.length; i++)
		{
			addNode(Integer.parseInt(nums[i]));
		}
		scan.close();
	}
	
}
