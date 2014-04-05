/**
 * 
 */
package game.tictactoe;

import java.util.Random;

/**
 * This class implements Player class. It has methods 
 * which implement the behavior of an automated Computer Player
 * 
 * @author Harshita Rao
 *
 */

public class ComputerPlayer implements Player{
	
	private char comp_play;

	
	public String getName() {
		return "COMPUTER";
	}


	public void setSymbol(char symbol) {
		comp_play = symbol;
	}



	public char getSymbol() {
		
		return comp_play;
	}
	

	public char[] getNextMove(Board b) {
		int move;
        
		char[] Board = b.getmBoard();
			
		EvaluateGame e = new EvaluateGame();

		char human_play=' ';
		if(comp_play == 'X') { 
			human_play = 'O';
		}
		else {
			human_play = 'X';
		}
		
        // first priority is to check if there is a winning move
		for (int i = 0; i < b.getBoard_size(); i++) {
			if (Board[i] != human_play && Board[i] != comp_play) {
				char curr = Board[i];
				Board[i] = comp_play;
				if (e.checkForWinner(b,human_play,comp_play) == 3) {
					System.out.println("Computer is moving to " + (i + 1));
					return Board;
				}
				else
					Board[i] = curr;
			}
		}

		// second priority is to block the opponent from winning
		for (int i = 0; i < b.getBoard_size(); i++) {
			if (Board[i] != human_play && Board[i] != comp_play) {
				char curr = Board[i];   // Save the current number
				Board[i] = human_play;
				if (e.checkForWinner(b,human_play,comp_play) == 2) {
					Board[i] = comp_play;
					System.out.println("Computer is moving to " + (i + 1));
					return Board;
					
				}
				else
					Board[i] = curr;
			}
		}
		// If center square is available, the computer should take it
		if (Board[4] != human_play && Board[4] != comp_play)
			{
				Board[4] = comp_play;
				System.out.println("Computer is moving to " + 5);
				return Board;
			}
								
		// Generate random move
				
		do
			{
				Random rand = new Random();
				move = rand.nextInt(b.getBoard_size() - 1) + 1;
			}   while (Board[move] == human_play || Board[move] == comp_play);
					
		System.out.println("Computer is moving to " + (move + 1));
        Board[move] = comp_play;
		return Board;
	}	

}
