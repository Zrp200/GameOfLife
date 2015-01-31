import java.util.Arrays;

/**
 * <h1>Generation Object</h1>
 * Creates a boolean array that stores the boolean state
 * of all cells in the world.
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
public class Generation {
	
	private boolean[][] generation;
	
	//Constructor Methods
	/**
	 * Standard constructor for Generation object.
	 * Creates a generation state from the world state.
	 * 
	 * @param world		Input of the current world state
	 */
	public Generation(World world) {
		generation = new boolean[world.getRows()][world.getColumns()];
		setGeneration(world);
	}//end standard constructor
	
	/**
	 * Clone constructor creates a deep copy of another generation object.
	 * 
	 * @param other		The Generation object to be cloned
	 */
	public Generation(Generation other) {
		generation = new boolean[other.getRowsNo()][other.getColumnsNo()];
		for (int i=0; i<generation.length; i++) {
			generation[i] = Arrays.copyOf(other.getRow(i), other.getColumnsNo());
		}
	}
	
	
	//Accessor Methods
	/**
	 * Gives the row size of the generation
	 * 
	 * @return	Returns the int number of rows
	 */
	public int getRowsNo() {
		return generation.length;
	}//end getRowsNo accessor method
	
	/**
	 * Gives the column size of the generation
	 * 
	 * @return	Returns the int number of columns
	 */
	public int getColumnsNo() {
		return generation[0].length;
	}//end getColumnsNo accessor method
	
	/**
	 * Gives the state of the generation in a boolean 2d array
	 * 
	 * @return	Returns the boolean 2d array state of the generation
	 */
	public boolean[][] getGeneration() {
		return generation;
	}//end getGeneration accessor method
	
	/**
	 * Gives an entire row of the generation object
	 * 
	 * @param row	The index of the row to be returned
	 * @return		Returns the boolean[] state of a row
	 */
	public boolean[] getRow(int row) {
		return generation[row];
	}//end getRow method
	
	/**
	 * Gives the state of an element in a generation
	 * 
	 * @param row		The row index of the cell
	 * @param column	The column index of the cell
	 * @return			Returns the boolean state of the cell
	 */
	public boolean getGenerationElement(int row, int column) {
		return generation[row][column];
	}//end getGenerationElement accessor method
	
	//Transformer Methods
	/**
	 * Sets the state of a generation based on a world object input
	 * 
	 * @param world		The world state being used currently
	 */
	public void setGeneration(World world) {
		
		for(int i=0; i<generation.length; i++) {
			for(int j=0; j<generation[i].length; j++) {
				
				generation[i][j] = world.getElementState(i, j);
				
			}//end columns loop
		}//end rows loop
		
	}//end setGeneration transformer method
	
	/**
	 * Sets the state of the generation object based on copying another.
	 * 
	 * @param other		The generation object to be copied
	 */
	public void setGeneration(Generation other) {
		
		for(int i=0; i<generation.length; i++) {
			for(int j=0; j<generation[i].length; i++) {
				
				generation[i][j] = other.getGenerationElement(i, j);
				
			}//end columns loop
		}//end rows loop
		
	}//end setGeneration transformer method
	
	/**
	 * Sets an individual element state
	 * 
	 * @param row		The row index of the cell
	 * @param column	The column index of the cell
	 * @param state		The boolean state the cell is to hold
	 */
	public void setGenerationElement(int row, int column, boolean state) {
		generation[row][column] = state;
	}//end setGenerationElement transformer method
	
}//end Generation class
