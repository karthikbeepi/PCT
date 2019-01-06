
import java.util.Scanner;

public class FreofLetter {
    class Letter {
    	char ch;
        int frequency;
        public Letter(int asc){
        	ch = (char)asc;
        	frequency = 0;
        }
    }	
    Letter[] letters = new Letter[26];
    Letter[] index = new Letter[26];
    
    public FreofLetter(){
	     for (int i =0;i<26;i++){
	    	 letters[i] = new Letter('A'+i);
	    	 index[i] = letters[i];
	     }	 
    }
    
    public void increseFre(char index){
    	letters[index-'A'].frequency++;
    }
    
   	public void Sort(){
   		Letter temp;
   		for(int i=0;i<index.length-1;i++){
    		for(int j=0;j<index.length-1-i;j++){
    			if(index[j].frequency>index[j+1].frequency){
    				temp=index[j];
    				index[j]=index[j+1];
    				index[j+1]=temp;
    			}
    		}
    	}
   	}	
   	
   	public void output(){
   		for(int i=0;i<index.length;i++){
   			if (index[i].frequency>0) System.out.print(index[i].ch);
    	}
   	}	
    
    
    public static void main(String[] args){
	     Scanner in = new Scanner(System.in);
	     FreofLetter frequency = new FreofLetter();
	     int letterNum = Integer.parseInt(in.nextLine());
	     for(int i=0;i<letterNum;i++){
	    	 String inputStr = in.nextLine().toUpperCase();
	    	 for (int j=0;j<inputStr.length();j++){
	    		char ch = inputStr.charAt(j);
	    		if (ch<='Z'&&ch>='A'){
	    			frequency.increseFre(ch);
	    		}
	    	 }
	     }
	     frequency.Sort();
	     frequency.output();
	}
}
