/**
 * 
 */
package game.tictactoe;

import java.util.Scanner;

/**
 * This class is the one which instantiates the Tic Tac Toe game 
 * and wires all the classes together.
 * 
 * the methods of this class deals with the test cases
 * -wrong symbol input
 * -if user wants to play again
 * 
 * @author Harshita Rao
 *
 */
public class TicTacToe {
	
	

/**
 * @return the HumanPlayer object to Main()
 */
private HumanPlayer welcome()
{
	System.out.println("Welcome to the game of Tic Tac Toe.");
    System.out.print("Please enter your name: ");
    HumanPlayer player1 = new HumanPlayer();
    ComputerPlayer player2 = new ComputerPlayer();
   
    Scanner in = new Scanner(System.in);
    String name1 = in.next();;
    player1.setName(name1);
    System.out.println("Hello "+ name1 + " ! My name is " + player2.getName());
    return player1;
}

/**
 * @param player1 is the HumanPlayer object passed by Main()
 */
private void startgame(HumanPlayer player1)
{   
	ComputerPlayer player2 = new ComputerPlayer();
	char turn;
	int turncount = 0;
	char symbol = ' ';
	// this do-while loop is to get a valid input symbol from user
		   do{
		   System.out.println(" Choose a symbol X or O. Note that X always starts first");
		   Scanner input = new Scanner(System.in);
		   symbol = input.findInLine(".").charAt(0);
		   }while (symbol!='X' && symbol!='x' && symbol!='o' && symbol!='O');
		 
	// if the user enters a lower case x or o, this statement converts it to upper
	char H = Character.toUpperCase(symbol);
	char C = ' ';
	// instantiate Board Class and create an object	   
	Board b = new Board();
	char[] GameBoard;  
		 
	System.out.println(" Lets start playing...");
		
		  if(H == 'X') 
			{
		    C = 'O';
		    turn = H;    // Human starts first
		    }
		  else  
		    {
			C = 'X';
			turn = C; // Computer starts first
		    }
		
	player1.setSymbol(H);
	player2.setSymbol(C);	
	System.out.println("My symbol is " + C + " and your symbol is " + H);	
	int  result = 0;            // Set to 1, 2, or 3 when game gets over
	EvaluateGame e = new EvaluateGame();
	
	// loop until someone wins or a tie
		   while (result == 0)
		    {	
			   GameBoard = b.getmBoard();
			   b.DisplayBoard();
                  if (turn == H)
			         {
				        GameBoard = player1.getNextMove(b);	
				        b.setmBoard(GameBoard);
				        turn = C;
				        turncount++;
			         }
			      else
			         {
			         	GameBoard = player2.getNextMove(b);
			        	b.setmBoard(GameBoard);
				        turn = H;
				        turncount++;
			         }	

	            /*check if someone has won only if the turncount is 5 or higher
	             * because a player needs a minimum of 5(players + opponents) turns to win
	             */
                  if(turncount>=5)
	            result = e.checkForWinner(b,H,C);
		    }   //end of while
	b.DisplayBoard();	
	e.reportGameResult(result, player1, player2);
}
	
	
	public static void main(String args[])
	{
		char c =' ';
		
		TicTacToe game = new TicTacToe();
		HumanPlayer hp = game.welcome();
		 do {
		    game.startgame(hp);
		    //prompt the user if he wants to play again
	        System.out.println("Hey "+hp.getName()+"! Do you want to play again? Y/N");
			Scanner choice = new Scanner(System.in);
			c = choice.findInLine(".").charAt(0);
			} while(c=='y' || c =='Y');
		
		   //if the user does not want to play again
		   System.out.println("Thank you for playing Tic-Tac-Toe!");
	      }
	}
