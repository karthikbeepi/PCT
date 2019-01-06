package basicproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HorizontalVerticalIntersections {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("x个数: ");
		int v = scan.nextInt();
		System.out.println("y个数: ");
		int h = scan.nextInt();
		
		int count = 0;
		ArrayList<int[]> vc = new ArrayList<int[]>();
		ArrayList<int[]> hc = new ArrayList<int[]>();
		
		for(int i = 0; i < v; i++) {
			Scanner scanv = new Scanner(System.in);
			String[] vstrArr = scanv.nextLine().split(" ");
			int[] temp = new int[3];
			for(int j = 0; j < 3; j++) {
				temp[j] = Integer.parseInt(vstrArr[j]);
			}
			vc.add(temp);
		}
		
		for(int i = 0; i < h; i++) {
			Scanner scanh = new Scanner(System.in);
			String[] hstrArr = scanh.nextLine().split(" ");
			int[] temp = new int[3];
			for(int j = 0; j < 3; j++) {
				temp[j] = Integer.parseInt(hstrArr[j]);
			}
			hc.add(temp);
		}
		
		for(int i = 0; i < v; i++) {
			for(int j = 0; j < h; j++) {
				if((vc.get(i)[0] >= hc.get(i)[1] && vc.get(i)[0] <= hc.get(i)[2]) && (hc.get(j)[0] >= vc.get(i)[1] && hc.get(j)[0] <= vc.get(i)[2])) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}

}
