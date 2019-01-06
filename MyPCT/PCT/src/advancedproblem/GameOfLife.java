package advancedproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameOfLife {
	
	private static char[][] board;
	private final static char BLANK = '#';
	private final static char ORGANISM = '@';
	
	private static List<XandY> updateList = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// get data size
		String[] arr = scanner.nextLine().trim().split(" ");
		int rowNum = Integer.parseInt(arr[0]);
		int colNum = Integer.parseInt(arr[1]);
		
		board = new char[rowNum + 2][colNum + 2];
		
		for (int i = 0; i < rowNum + 2; i++) {
			for (int j = 0; j < colNum + 2; j++) {
				board[i][j] = BLANK;
			}
		}
		
		
		// read data into memory
		for (int i = 0; i < rowNum; i++) {	
			String cells = scanner.nextLine().trim();
			for	(int j = 0; j < colNum; j++) {				
				if ("#".equals(String.valueOf(cells.charAt(j)))) {
					board[i + 1][j + 1] = BLANK;
				} else {
					board[i + 1][j + 1] = ORGANISM;
				}		
			}		
		}
		
		// get the number of generation
		int generationNum = Integer.parseInt(scanner.nextLine());
		
		// doing the generation
		while (generationNum != 0) {
			// loop all cells one by one
			for (int i = 1; i <= board.length - 2; i++) {
//				for (int j = 1; j <= board.length - 2; j++) { !!!!!!! the mistake is here !!!!!!
				for (int j = 1; j <= board[0].length - 2; j++) {
					
					int neigNum = getNeighbourNum(i, j);
					
					if (board[i][j] == ORGANISM) {
						if (neigNum == 0 || neigNum == 1 || neigNum >= 4) {
							XandY xy = new XandY(i, j, BLANK);
							updateList.add(xy);
						}

					} else {
						if (neigNum == 3) {
							XandY xy = new XandY(i, j, ORGANISM);
							updateList.add(xy);
						}
					}
				}
			}
			
			if (!updateList.isEmpty()) {
				updateBoard();
			}
			updateList.clear();;
			
//			printBoard();
			
			generationNum--;
		}
		
		// output the result
		int resultNum = countOrganism();
		System.out.println(resultNum);
		
		scanner.close();
	}
	
	
	private static void updateBoard() {
		for (XandY xy : updateList) {
			if (xy.flag == BLANK) {
				board[xy.x][xy.y] = BLANK;
			}
			else {
				board[xy.x][xy.y] = ORGANISM;
			}
		}
	}


	private static int countOrganism() {
		int counter = 0;
		for (int i = 1; i <= board.length - 2; i++) {
			for (int j = 1; j <= board.length - 2; j++) {
				if (board[i][j] == ORGANISM) counter++;
			}
		}
		return counter;
	}


	private static int getNeighbourNum(int i, int j) {
		int counter = 0;
		for (int row = i - 1; row <= i + 1; row++) {
			for (int col = j - 1; col <= j + 1; col++) {
				if (board[row][col] == ORGANISM) {
					counter++;
				}
			}
		}
		
		if (board[i][j] == ORGANISM) {
			counter--;
		}
		
		return counter;
	}


	private static void printBoard() {
		System.out.println("\n" + "==================================");
		for	(char[] arr : board) {
			for (char ch : arr) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	
}

class XandY {
	int x;
	int y;
	char flag;
	
	public XandY(int x, int y, char f) {
		this.x = x;
		this.y = y;
		this.flag = f;
	}
}