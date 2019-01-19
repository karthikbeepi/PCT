import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class PCT5Adv {

	class node{
		int data;
		node left, right;
		public node(int i)
		{
			data = i;
		}
	}
	
	node root;
	ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		PCT5Adv obj = new PCT5Adv();
		obj.getInput();
		obj.printSingle();
		
	}

	private void printSingle() {
		
		findNode(root);
		printNode();
		
	}

	private void printNode() {
		Collections.sort(list);
		for(int i: list)
		{
			System.out.print(i+" ");
		}
	}

	private void findNode(node root) {
		
		if(root==null)
			return ;
		else 
		{
			findNode(root.left);
			findNode(root.right);
		}
		if(root.left!=null&&root.right==null)
			list.add(root.left.data);
		else if(root.left==null&&root.right!=null)
			list.add(root.right.data);
		
	}

	private void getInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfNodes = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		insert(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
		{
			insert(Integer.parseInt(str[i]));
		}
	}

	private void insert(int parseInt) {
		
		if(root!=null)
			insert(parseInt, root);
		else
			{
				node obj = new node(parseInt);
				root = obj;
			}
	}

	private void insert(int parseInt, node root) {
		
		if(root.data>parseInt)
			{
				if(root.left!=null)
					insert(parseInt, root.left);
				else
				{
					node obj = new node(parseInt);
					root.left = obj;
				}
			}
			else
			{
				if(root.right!=null)
					insert(parseInt, root.right);
				else
				{
					node obj = new node(parseInt);
					root.right = obj;
				}
			}
		}
		
	

}
