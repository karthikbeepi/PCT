package advancedproblem;


import java.util.*;

public class SnakeAndLadder {
	
	public static void main(String[] args){
		
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

		Scanner scanner = new Scanner(System.in);
		
		String input1 = scanner.nextLine(); //
		int input11 = Integer.parseInt(input1.trim());
//		System.out.println(input1);

		while(input11>0){
			String input2 = scanner.nextLine();
			
			String[] path = input2.split(" ");
			
			int val1 = Integer.parseInt(path[0].trim());
			int val2 = Integer.parseInt(path[1].trim());
//			System.out.println(val1+"  "+val2);
			
			hash.put(val1, val2);
			
			input11--;
		}
		
//		System.out.println(hash);
	
		
		String input3 = scanner.nextLine();
		int input33 = Integer.parseInt(input3.trim());
//		System.out.println(input33);

	
		int[] dice = new int[input33];
		
		String input4 = scanner.nextLine();
		String[] thr = input4.split(" ");
		for(int i=0; i<thr.length;i++){
			dice[i] = Integer.parseInt(thr[i].trim());
		}
		scanner.close();
		
//		System.out.println(Arrays.toString(dice));
		
		int times = 1;
		int positionA = 1;
		int positionB = 1;
	
		
		while(times<=input33 && (dice[times-1]>=1&dice[times-1]<=6)){
//		while(times<=input33){
			if(times%2==1){ // A
				positionA += dice[times-1];
				while(hash.containsKey(positionA)){
						positionA = hash.get(positionA);
						if(positionA>=100){
							System.out.println("A "+100+"\n");
							return;
						}
						
					}
				if(positionA>=100){
					System.out.println("A "+100+"\n");
					return;
				}
			}else{ //B
				positionB +=dice[times-1];
				while(hash.containsKey(positionB)){
					positionB = hash.get(positionB);
					if(positionB>=100){
						System.out.println("B "+100+"\n");
						return;
					}
				}
				if(positionB>=100){
					System.out.println("B "+100+"\n");
					return;
				}
			}
			
//			if(positionA>=100){
//				System.out.println("A "+100+"\n\r");
//			}else if(positionB>=100){
//				System.out.println("B "+100+"\n\r");
//			}
				
			times++;
		}
		
		if(positionA >= positionB){
			System.out.println("A " +positionA+"\n");
		}else{
			System.out.println("B " +positionB+"\n");
		}
				
		
		
	}

}
