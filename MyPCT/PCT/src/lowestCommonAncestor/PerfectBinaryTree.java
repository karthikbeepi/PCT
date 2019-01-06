package lowestCommonAncestor;

import java.util.Scanner;


public class PerfectBinaryTree {
	
	public PerfectBinaryTreeNode findNodeByValue(PerfectBinaryTreeNode root, int value){
		PerfectBinaryTreeNode tempNode=root;
		if(root==null){
			return root;
		}else if(root.value==value){
			return root;
		}else if(root.left!=null){
			findNodeByValue(root.left, value);
		}else{
			findNodeByValue(root.right, value);
		}
		return tempNode;
		
	}
	
	public boolean nodeValidation(PerfectBinaryTreeNode root, PerfectBinaryTreeNode node){
		if(root==null){
			return false;
		}else if(root==node){
			return true;
		}
		return nodeValidation(root.left, node)||nodeValidation(root.right, node);
	}
	
	public PerfectBinaryTreeNode locateCommonAncestor(PerfectBinaryTreeNode root,PerfectBinaryTreeNode node1,PerfectBinaryTreeNode node2){
		if(nodeValidation(root.left, node1)&&nodeValidation(root.left, node2)){
			return locateCommonAncestor(root.left, node1,node2);
		}else if(nodeValidation(root.right, node1)&&nodeValidation(root.right, node2)){
			return locateCommonAncestor(root.right, node1, node2);
		}
		return root;
	}
	
	public static void main(String[] args){
		
		PerfectBinaryTree pbt=new PerfectBinaryTree();
		PerfectBinaryTreeNode root=null;
		PerfectBinaryTreeNode resultRoot;
		
		Scanner scanner=new Scanner(System.in);
		String[] str=scanner.nextLine().trim().split(" ");
		int[] arrayNum=new int[str.length];
		for(int i=0;i<str.length;i++){
			arrayNum[i]=Integer.parseInt(str[i]);
		}
		
		if(arrayNum[0]>15){
			return;
		}else{
			PerfectBinaryTreeNode node1=pbt.findNodeByValue(root, arrayNum[1]);
			PerfectBinaryTreeNode node2=pbt.findNodeByValue(root, arrayNum[2]);
			resultRoot=pbt.locateCommonAncestor(root, node1, node2);
		}		
	}
}

class PerfectBinaryTreeNode{
	int value;
	int height;
	PerfectBinaryTreeNode left;
	PerfectBinaryTreeNode right;
	
	public PerfectBinaryTreeNode(int value,PerfectBinaryTreeNode left,PerfectBinaryTreeNode right){
		this.value=value;
		this.height=0;
		this.left=left;
		this.right=right;
	}
	
}
