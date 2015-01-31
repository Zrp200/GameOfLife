
/**
 * <h1>World Object</h1>
 * Create a world state in which cells exist.
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
public class World {
	
	private Cell[][] world;

	//Constructor Methods
	/**
	 * Default world constructor for text controller
	 * 
	 * @param rows		Defines number of rows in array
	 * @param columns	Defines number of columns in array
	 */
	public World(int rows, int columns) {
		world = new Cell[rows][columns];
		birthCells();
	}//end basic constructor
	
	/**
	 * Standard world constructor for text controller
	 * 
	 * @param rows			Defines number of rows in array
	 * @param columns		Defines number of columns in array
	 * @param worldState	Defines world state through string of
	 * 						'X' for live cells and '.' for dead cells.
	 */
	public World(int rows, int columns, String worldState) {
		this(rows, columns);
		setWorldState(worldState);
	}//end standard constructor
	
	/**
	 * Standard world constructor for GUI controller
	 * 
	 * @param rows			Defines number of rows in array
	 * @param columns		Defines number of columns in array
	 * @param worldState	Defines world state as defined in setup screen
	 */
	public World(int rows, int columns, boolean[][] worldState) {
		this(rows, columns);
		setWorldState(worldState);
	}//end standard constructor
	
	
	//Display Methods
	/**
	 * Displays the state of the world in the console
	 */
	public void displayWorldState() {
		for(int i=0; i<world.length; i++) {
			for(int j=0; j<world[i].length; j++) {
				System.out.print(world[i][j].toString());
			}//end columns loop
			System.out.println();
		}//end rows loop
	}//end displayWorldState display method
	
	//Accessor Methods
	/**
	 * Get row count of the world
	 * @return	Returns int number of rows
	 */
	public int getRows() {
		return world.length;
	}//end getRows accessor method
	
	/**
	 * Get column count of the world
	 * @return	Returns int number of columns
	 */
	public int getColumns() {
		return world[0].length;
	}//end getColumns accessor method
	
	/**
	 * Gives the state of a given element in the world
	 * 
	 * @param row		Row index of cell
	 * @param column	Column index of cell
	 * @return			Returns true or fals state of the cell
	 */
	public boolean getElementState(int row, int column) {
		return world[row][column].getState();
	}//end getElementState accessor method
	
	
	//Transformer Methods
	/**
	 * Updates the world to the next generation
	 * 
	 * @param newGen 	Generation object to be updated to
	 */
	public void nextGeneration(Generation newGen) {
		boolean state;
		
		for(int i=0; i<world.length; i++) {
			for(int j=0; j<world[i].length; j++) {
				state = newGen.getGenerationElement(i, j);
				setElementState(i, j, state);
			}//end columns loop
		}//end rows loop
		
	}//end nextGeneration transformer method
	
	/**
	 * Sets the state of an individual element
	 * 
	 * @param row		Row index of cell
	 * @param column	Column index of cell
	 * @param state		The state to set the cell to
	 */
	public void setElementState(int row, int column, boolean state) {
		world[row][column].setState(state);
	}//end setElementState transformer method
	
	//Creates all cells in the world
	private void birthCells() {
		for(int i=0; i<world.length; i++) {
			for(int j=0; j<world[i].length; j++) {
				world[i][j] = new Cell();
			}//end column loop
		}//end row loop
	}//end birthCells method
	
	//sets state of all cells in the world from the text controller
	private void setWorldState(String state) {
		char[] worldState = state.toCharArray();
		
		int count=0;
		for(int i=0; i<world.length; i++) {
			for(int j=0; j<world[i].length; j++) {
				if(worldState[count]=='X') setElementState(i,j,true);
				else setElementState(i,j,false);
				count++;
			}//end column loop
		}//end row loop
	}
	
	//sets state of all cells in the world from the GUI controller
	private void setWorldState(boolean[][] state) {
		
		for(int i=0; i<world.length; i++) {
			for(int j=0; j<world[i].length; j++) {
				setElementState(i,j,state[i][j]);
			}//end column loop
		}//end row loop
	}
	
}//end World class
