
import java.util.Scanner;

public class singleNode {
    class Node {
        int key;
        Node left, right , parent;
 
        public Node(int item,Node pa) {
            key = item;
            left = right = null;
            parent = pa;
        }
    }	
    
    Node root;
    String output;
    
    // Constructor
    singleNode() { 
        root = null; 
        output = "";
    }
    
    // This method mainly calls insertRec()
    void insert(int key) {
       root = insertRec(root,null,key);
    }
    
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root,Node pa, int key) {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key,pa);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left,root, key);
        else if (key > root.key)
            root.right = insertRec(root.right,root, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
    // This method mainly calls InorderRec()
    void inorder()  {
       inorderRec(root);
    }
 
    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            if (root.parent!=null&&(root.parent.left==null||root.parent.right==null)){
            	output+=(output=="") ?root.key:" "+root.key;
            }
            inorderRec(root.right);
        }
    }
	
	public static void main(String[] args){
	     Scanner in = new Scanner(System.in);
	     int nodeNum = Integer.parseInt(in.nextLine());
	     singleNode tree = new singleNode();
	     for(int i=0;i<nodeNum;i++){
	    	 tree.insert(in.nextInt());
	     }	 
	     tree.inorder();
	     if (tree.output=="") System.out.println("NO");
	     else System.out.println(tree.output);
	}
}
