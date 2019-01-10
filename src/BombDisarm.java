import java.util.Scanner;

public class BombDisarm {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        int W = in.nextInt(); // width of the building.
	        int H = in.nextInt(); // height of the building.
	        int N = in.nextInt(); // maximum number of turns before game over.
	        int X0 = in.nextInt();
	        int Y0 = in.nextInt();

	        // game loop
	        while (true) {
	            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

	            // Write an action using System.out.println()
	            // To debug: System.err.println("Debug messages...");

	            if(bombDir.contains("U"))
	            	Y0+=(H-Y0)/2;
	            if(bombDir.contains("D"))
	            	Y0-=(Y0)/2;
	            if(bombDir.contains("L"))
	            	X0-=(X0)/2;
	            if(bombDir.contains("R"))
	            	X0+=(W-X0)/2;
	            
	            // the location of the next window Batman should jump to.
	            System.out.println(X0+" "+Y0);
	        }
	}

}
