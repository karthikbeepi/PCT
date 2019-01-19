import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PCT6Adv {

	class Node
	{
		int data;
		Node left, right;
		Node(int i)
		{
			data = i;
		}
	}
	
	ArrayList<String> toPrint = new ArrayList<>();
	Node mainRoot;
	Node tempRoot;
	int noOfTrees;
	
	public static void main(String[] args) throws Exception{

		PCT6Adv obj = new PCT6Adv();
		obj.getInput();
		for(String t : obj.toPrint)
			System.out.println(t);
	}

	private void getInput() throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		noOfTrees = Integer.parseInt(br.readLine());
		makeMainTree(br.readLine().split(" "));
		for(int i=0; i<noOfTrees-1; i++)
		{
			makeTempTree(br.readLine().split(" "));
			String s = compareTree(mainRoot, tempRoot);
			if(s.compareTo("YES")==0)
				toPrint.add(s+" "+0);
			else
			{
				int deptDiff = depthCheck(mainRoot, tempRoot);
				toPrint.add(s+" "+deptDiff);
			}
			
		}
		
	}

	private int depthCheck(Node mainRoot2, Node tempRoot2) {
		int m = findHeight(mainRoot2);
		int t = findHeight(tempRoot2);
		return (m>=t)?(m-t):(t-m);
	}

	private int findHeight(Node mainRoot2) {
		if(mainRoot2==null)
			return 0;
		else
		{
			return 1+max(findHeight(mainRoot2.left),findHeight( mainRoot2.right));
		}
	}
	
	private int max(int findHeight, int findHeight2) {
		return (findHeight-findHeight2>=0)?(findHeight-findHeight2):(findHeight2-findHeight);
	}

	private String compareTree(Node mainRoot2, Node tempRoot2) {
		if(mainRoot2==null&&tempRoot2==null)
			return "YES";
		if(cmpTree(mainRoot2.left, tempRoot2.left)&&cmpTree(mainRoot2.right, tempRoot2.right))
			return "YES";
		else
			return "NO";
	}

	private boolean cmpTree(Node left, Node left2) {
		if(left==null && left2==null)
			return true;
		else if(left==null&& left2!=null || left!=null & left2==null)
			return false;
		else
			return cmpTree(left.left, left2.left) && cmpTree(left.right, left2.right);
	}

	private void makeTempTree(String[] split) {
	
			tempRoot = new Node(Integer.parseInt(split[0]));
		{
			for(int i=1; i<split.length-1; i++)
			{
				insert(tempRoot, Integer.parseInt(split[i]));
			}
		}
	}

	private void makeMainTree(String[] split) {
			mainRoot = new Node(Integer.parseInt(split[0]));
		
		{
			for(int i=1; i<split.length-1; i++)
			{
				insert(mainRoot, Integer.parseInt(split[i]));
			}
		}
	}

	private void insert(Node r, int data) {
		
			if(data<r.data)
			{
				if(r.left!=null)
					insert(r.left, data);
				else
					r.left = new Node(data);
			}
			if(data>r.data)
			{
				if(r.right!=null)
					insert(r.right, data);
				else
					r.right = new Node(data);
			}
	}

}
