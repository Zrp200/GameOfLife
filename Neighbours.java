import java.util.ArrayList;

/**
 * <h1>Neighbours object</h1>
 * Lists cell states next to a cell whose state is to be defined
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
public class Neighbours {

	private ArrayList<Boolean> neighbours;
	
	//Constructor Methods
	/**
	 * Default constructor for a neighbour object
	 */
	public Neighbours() {
		neighbours = new ArrayList<Boolean>();
	}//end default constructor
	
	//Accessor Methods
	/**
	 * Gives the count of live cells neighbouring
	 * the cell in question
	 * 
	 * @return	Returns an int number of live neighbouring cells
	 */
	public int liveCount() {
		int count=0;
		
		for(boolean b: neighbours) {
			if(b) count++;
		}
		
		return count;
	}//end liveCount accessor method
	
	/**
	 * Gives the total number of neighbours for a cell
	 * 
	 * @return	Returns an int number of neighbours
	 */
	public int getNeighboursNo() {
		return neighbours.size();
	}//end getNeighboursNo accessor method
	
	//Transformer Methods
	/**
	 * Adds a neighbour to the list
	 * 
	 * @param state		The state of the cell being added to the list
	 */
	public void addNeighbour(Boolean state) {
		neighbours.add(state);
	}//end addNeighbour transformer method
	
	/**
	 * Clears the list ready for a new cell
	 */
	public void clear() {
		neighbours.removeAll(neighbours);
	}//end clear transformer method
	
}//end Neighbours class
