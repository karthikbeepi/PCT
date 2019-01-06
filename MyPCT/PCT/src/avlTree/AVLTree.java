package avlTree;

import java.util.ArrayList;

/**
 * @author kings
 *
 */
public class AVLTree {

	public ArrayList<AVLNode> nodes = new ArrayList<AVLNode>();
	
	public static AVLNode findNode(AVLNode root,AVLNode node){
		if (node.value<=root.value) {
			if (root.leftNode == null){
				/*root.leftNode = node;
				root.leftDepth++;*/
				return root;
			}
			else {
				return findNode(root.leftNode,node);
			}
		}
		else {
			if (root.rightNode == null){
				/*root.rightNode = node;
				root.rightDepth++;*/
				return root;
			}
			else {
				return findNode(root.rightNode,node);			
			}
		}
	}
	
	public static boolean checkValid(AVLNode root,AVLNode node){
		if (root == null) return true;
		if (node.value<=root.value){
			if (root.leftDepth<root.rightDepth){
				root.leftDepth++;
				return true;
			}
			else if (root.leftDepth==root.rightDepth){
				if (checkValid(root.parentNode,node)){
					root.leftDepth++;
					return true;
				}
				else return false;
			}
			else return false;
		}
		else if (node.value>root.value){
			if (root.rightDepth<root.leftDepth){
				root.rightDepth++;
				return true;
			}
			else if (root.leftDepth==root.rightDepth){
				if (checkValid(root.parentNode,node)){
					root.rightDepth++;
					return true;
				}
				else return false;
			}
			else return false;
		}
		return true;
	};	
	

	public static void main(String[] args){
		int length = args.length;
		int i = 0;
		AVLNode root = null;
		AVLTree myTree = new AVLTree(); 
		ArrayList<Integer> result= new ArrayList<Integer>(); 
		while (i<length&&Integer.parseInt(args[i])!=-1){
			AVLNode newNode = new AVLNode(Integer.parseInt(args[i]));		
			if (myTree.nodes.size()==0){
				myTree.nodes.add(newNode);
				root = newNode;
			}
			else {
				AVLNode target = findNode(root,newNode);
				if (!(checkValid(target, newNode))) result.add(newNode.value);
				else {
					if (newNode.value<=target.value){
						target.leftNode = newNode;
						newNode.parentNode = target;
					}	
					else {
						target.rightNode = newNode;
						newNode.parentNode = target;
					}
				}
			}
			i++;
		}
		if (result.size()==0)
			System.out.println("0");
		else {
			for (i=0;i<result.size();i++){
				System.out.print(String.valueOf(result.get(i))+" ");				
			}
			System.out.println(result.size());
		}	
	}
}
						
class AVLNode {
	public int value;
	AVLNode leftNode;
	AVLNode rightNode;
	AVLNode parentNode;
	int leftDepth;
	int rightDepth;
	
	public AVLNode(int value){
		this.value = value;
		parentNode = null;
		leftNode = null;
		rightNode = null;
		leftDepth = 0;
		rightDepth = 0;
	}
}
				
						
						
						