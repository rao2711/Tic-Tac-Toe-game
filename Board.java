/**
 * 
 */
package game.tictactoe;


/**
 * This class holds the fields and methods associated with the Game Board
 * 
 * @author Harshita Rao
 *
 */
public class Board {

	
	public char GameBoard[] = {'1','2','3','4','5','6','7','8','9'};
	private final int BOARD_SIZE = 9;
	
	
	/**
	 * @return int boardsize
	 */
	public int getBoard_size() {
		return BOARD_SIZE;
	}
	/**
	 * @return the gameboard as a char srray
	 */
	public char[] getmBoard() {
		return GameBoard;
	}
	/**
	 * @param updateBoard the state of the game is saved by using this method
	 */
	public void setmBoard(char[] updateBoard) {
		this.GameBoard = updateBoard;
	}
	
	
	/**
	 * This method is to display the board in a 3x3 matrix format
	 */
	public void DisplayBoard(){
		System.out.println();
		System.out.println(GameBoard[0] + " | " + GameBoard[1] + " | " + GameBoard[2]);
		System.out.println("-----------");
		System.out.println(GameBoard[3] + " | " + GameBoard[4] + " | " + GameBoard[5]);
		System.out.println("-----------");
		System.out.println(GameBoard[6] + " | " + GameBoard[7] + " | " + GameBoard[8]);
		System.out.println();
	}
		
}
