
public class CheckBST {

	 class Node {
		    int data;
		    Node left;
		    Node right;
		     }
	boolean checkBST(Node root) {
	
		if(root==null)
			return true;
		if(root.left!=null&&root.data<root.left.data)
			return false;
		if(root.right!=null&&root.data<root.right.data)
			return false;
		return checkBST(root.left) && checkBST(root.right);
		
	}
	public static void main(String[] args) {

		
		
	}

}
