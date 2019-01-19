package CCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class NodeHC{
	char data;
	NodeHC left, right;
	public NodeHC(char c) {
		data =c;
		left = right = null;
	}
}

public class HuffmanCoding {
	
	String s, code;
	HashMap<Character, Integer> charCount = new HashMap<>();
	NodeHC root;

	ArrayList<Character> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {

		HuffmanCoding obj = new HuffmanCoding();
		obj.getInput();
		obj.countCharacters();
		obj.makeTree();
		obj.printTree();
		
	}

	private void printTree() {
		
		NodeHC curNode = root;
		for(int i=0; i<code.length(); i++)
		{
			if(code.charAt(i)=='0')
			{
				curNode = curNode.right;
				if(curNode.data!=' ')
					System.out.print(curNode.data+" ");
			}
			else
			{
				curNode = curNode.left;
				if(curNode.data!=' ')
					System.out.print(curNode.data+" ");
			}
		}
		
	}

	private void makeTree() {
		root = new NodeHC(' ');
		NodeHC curNode = root;
		for(int i=0; i<list.size()-2; i++)
		{
			char c = list.get(i);
			curNode.left = new NodeHC(c);
			curNode.right = new NodeHC(' ');
			curNode = curNode.right;
		}
		curNode.left = new NodeHC(list.get(list.size()-2));
		curNode.right = new NodeHC(list.get(list.size()-1));
	}

	private void countCharacters() {
		
		for(int i=0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			if(charCount.containsKey(c))
			{
				int val = charCount.get(c);
				val++;
				charCount.put(c, val);
			}
			else
				charCount.put(c, 1);
		}		
		
		while(!charCount.isEmpty())
		{
			int max = Integer.MIN_VALUE;
			char toRemove=' ';
			for(char c : charCount.keySet())
			{
				int temp = charCount.get(c);
				if(temp>max)
				{
					toRemove=c;
					max = temp;
				}
			}
			list.add(toRemove);
			charCount.remove(toRemove);
		}
		
		System.out.println(list);
		
	}

	private void getInput() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		code = br.readLine();
	}

}
