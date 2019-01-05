package TreeK;

import java.util.ArrayList;

public class TreeK {

	NodeK root;
	
	public void insert(NodeK newNode, NodeK r)
	{
		if(r==null)
		{
			r = newNode;
			return ;
		}
		
		if(r.data>newNode.data) {
			if(r.left!=null)
				insert(newNode, r.left);
			else
				r.left = newNode;
		}
		else
		{
			if(r.right!=null)
				insert(newNode, r.right);
			else
				r.right = newNode;
		}
	}
	
	public void insert(int t) {
		NodeK newNode = new NodeK(t);
		if(root==null)
			root= newNode;
		else
			insert(newNode, this.root);
	}
	
	public void printNode()
	{
		printNode(this.root);
	}
	
	private void printNode(NodeK r) {
		
		if(r==null)
			return;
		if(r.left!=null)
			printNode(r.left);
		System.out.println(r.data);
		if(r.right!=null)
			printNode(r.right);
		
	}
	
	public void printNodeBFS()
	{
		ArrayList<NodeK> q = new ArrayList<>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			NodeK curNode = q.remove(0);
			System.out.println(curNode.data);
			if(curNode==null)
				return;
			if(curNode.left!=null)
				q.add(curNode.left);
			if(curNode.right!=null)
				q.add(curNode.right);	
			}
			
		}
		
	

	public static void main(String args[]) {
		
		TreeK t = new TreeK();
		
		t.insert(4);
		t.insert(7);
		t.insert(3);
		t.insert(2);
		t.insert(9);
		t.insert(6);
		t.insert(8);
		t.insert(10);
		t.insert(1);
		
		t.printNode();
		//t.printNodeBFS();
	//	t.findMinimumHeight();
	//	t.findMaximumHeight();
	//	t.findMaxPathSum();
	//	t.removeMinNode(4);
		t.findAncestor( 6, 10);
	}

	private void findAncestor(int i, int j) {
		System.out.println(findAncestor(root, i, j).data);
	}

	private NodeK findAncestor(NodeK r ,int i, int j)
	{
		if(r==null)
			return null;
		if(r.data<i&&r.data<j)
			return findAncestor(r.right, i, j);
		else if(r.data>i&&r.data>j)
			return findAncestor(r.left, i, j);
		else
			return r;
			
	}

	private void findMaxPathSum() {
		System.out.println(findMaxPathsum(root));
	}

	private int findMaxPathsum(NodeK r) {
		if(r.left==null&&r.right==null)
			return r.data;
		else if(r.left==null&&r.right!=null)
			return r.data + findMaxPathsum(r.right);
		else if(r.left!=null&&r.right==null)
			return r.data + findMaxPathsum(r.left);
		else
			return r.data + findMax(findMaxPathsum(r.left), findMaxPathsum(r.right));
			
	}

	private void findMaximumHeight() {
		System.out.println(findMaximumHeight(root));
	}

	private void findMinimumHeight() {
		System.out.println(findMinimumHeight(root));
		
	}

	int findMax(int a , int b)
	{
		if(a>b)
			return a;
		else
			return b;
	}
	
	int findMin(int a , int b)
	{
		if(a>b)
			return b;
		else
			return a;
	}
	private int findMaximumHeight(NodeK r) {
		if(r.left==null&&r.right==null)
			return 1;
		else if(r.left==null&&r.right!=null)
			return 1 + findMaximumHeight(r.right);
		else if(r.left!=null&&r.right==null)
			return 1 + findMaximumHeight(r.left);
		else
			return 1 + findMax(findMaximumHeight(r.left), findMaximumHeight(r.right));
			
	}
	private int findMinimumHeight(NodeK r) {
		if(r.left==null&&r.right==null)
			return 1;
		else if(r.left==null&&r.right!=null)
			return 1 + findMinimumHeight(r.right);
		else if(r.left!=null&&r.right==null)
			return 1 + findMinimumHeight(r.left);
		else
			return 1 + findMin(findMinimumHeight(r.left), findMinimumHeight(r.right));
			
	}
	
	
}
