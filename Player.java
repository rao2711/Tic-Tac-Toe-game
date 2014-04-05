/**
 * 
 */
package game.tictactoe;

/**
 * Interface which is implemented by human and computer
 * 
 * @author Harshita Rao
 *
 */
public interface Player {
	
/**
 * @return the name
 */
public String getName();

/**
 * @param Board object
 * @return the board represented by char array
 */
public char[] getNextMove(Board B);

/**
 * @return the symbol character
 */
public char getSymbol(); 

}
