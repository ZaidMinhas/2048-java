import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		GameBoard board = new GameBoard();
	
		Scanner s = new Scanner(System.in);
	
		while (true) {
			System.out.println("Score: " + board.score);
			System.out.println(board);
			System.out.println("(W) for UP, (A) for LEFT, (S) for DOWN, (D) for RIGHT");
			
			String inputString = s.nextLine();
			if (inputString.compareToIgnoreCase("q") == 0) {
				s.close();
			}
			board.moveRequest(inputString);
			
		}

	}

}
