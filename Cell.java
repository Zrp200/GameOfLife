/**
 * <h1>Cell Object</h1>
 * This class defines a basic cell in Conway's game of life.
 * <p>Used to define all cell's in the game world.</p>
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
public class Cell {

	private boolean living;
	
	//Constructor Methods
	/**
	 * Default constructor creates a basic cell.
	 */
	public Cell() {
		living = false;
	}//end default constructor
	
	/**
	 * Standard constructor creates a cell and defines
	 * whether it is alive or dead.
	 * 
	 * @param status 	The true/false state of the cell
	 */
	public Cell(boolean status) {
		living = status;
	}//end standard constructor
	
	/**
	 * Clone constructor for creating a cell copy.
	 * 
	 * @param other		The cell to be cloned
	 */
	public Cell(Cell other) {
		living = other.getState();
	}//end clone constructor
	
	
	//Accessor Methods
	/**
	 * The toString method for the cell used for display in console
	 * 
	 * @return		Returns a string with 'X' to denote a living cell
	 */
	public String toString() {
		if(living) return "X";
		else return ".";
	}//end toString accessor method
	
	/**
	 * Gives the living state of the cell
	 * 
	 * @return 		Returns true or false
	 */
	public boolean getState() {
		return living;
	}//end getState accessor method
	
	//Transformer Methods
	/**
	 * Sets the living state of the cell
	 * 
	 * @param status	True or false
	 */
	public void setState(boolean status) {
		living = status;
	}
}//end Cell class
