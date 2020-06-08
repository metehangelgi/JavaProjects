/*
 * File: Tictactoe.java
 * --------------------------
 */
import acm.program.*;

public class TicTacToe extends ConsoleProgram{

	public void run(){
		char[][] board = new char[3][3];
		displayBoard(board);

		while (true) {
			// Prompt the first player
			makeAMove(board, 'X');
			displayBoard(board);
			if (isWon('X', board)) {
				println("X player won");
				break;
			}
			else if (isDraw(board)) {
				println("No winner");
				break;
			}

			// Prompt the second player
			makeAMove(board, 'O');
			displayBoard(board);
			if (isWon('O', board)) {
				println("O player won");
				break;
			}
			else if (isDraw(board)) {
				println("No winner");
				break;
			}
		}
	}


	public void makeAMove(char[][] board, char player) { 
		// Your code starts here
		while (true) {
			int row = readInt("Enter a row (0, 1, 2) for player " + player + ": ");
			int column = readInt("Enter a column (0, 1, 2) for player " + player + ": ");
			if (board[row][column] == '\000') { // an empty cell
				board[row][column] = player;
				break;
			} else {
				println("This cell is already occupied. Try a different cell");
			}
		}
		// Your code ends here
	}

	public static boolean isWon(char ch, char[][] board) {
		// Your code starts here
		// Check rows
		for (int i = 0; i < 3; i++)
			if (ch == board[i][0] && ch == board[i][1] && ch == board[i][2]) return true;

		// Check columns
		for (int j = 0; j < 3; j++)
			if (ch == board[0][j] && ch == board[1][j] && ch == board[2][j]) return true;

		// Check major diagonal
		if (ch == board[0][0] && ch == board[1][1] && ch == board[2][2]) return true;

		// Check sub diagonal
		if (ch == board[0][2] && ch == board[1][1] && ch == board[2][0]) return true;

		// Your code ends here
		return false;
	}

	public static boolean isDraw(char[][] board) {
		// Your code starts here
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[i][j] == '\000') return false;
		// Your code ends here
		return true;
	}

	public void displayBoard(char[][] board) {
		println("\n-------------");
		for (int i = 0; i < 3; i++) {
			print("| ");
			for (int j = 0; j < 3; j++)
				print(board[i][j] != '\u0000' ?  board[i][j] + " | ": "  | ");
			println("\n-------------");
		}
	}
}
