/**
 * <h1>Evolution Object</h1>
 * Controls the evolution from one generation to another
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
public class Evolution {
	
	private Generation original;
	private Generation evolution;

	/**
	 * Constructor of evolution object
	 * 
	 * @param origins	The original generation state of the game
	 */
	public Evolution(Generation origins) {
		original = origins;
		evolution = new Generation(origins);
	}//end standard constructor method
	
	/**
	 * Causes evolution from one generation to another
	 * 
	 * @return		Returns the next evolution of the generation
	 */
	public Generation newEvolution() {
		boolean workingCellState, newCellState;
		Neighbours workingCellNeighbours;
		
		//Works through each cell of generation
		for(int i=0; i<original.getRowsNo(); i++) {
			for(int j=0; j<original.getColumnsNo(); j++) {
				
				//Copy original working cell state - correct
				workingCellState = original.getGenerationElement(i, j);
				
				//Work out the cells neighbours - correct;
				workingCellNeighbours = calculateNeighbours(i, j);
				
				//Calculate whether it should be alive or not
				newCellState = calculateStatus(workingCellState, workingCellNeighbours.liveCount());
				
				//Set element in new evolution
				evolution.setGenerationElement(i, j, newCellState);
				
			}
		}
		
		return evolution;
	}//end newEvolution method
	
	//Calculates neighbours of a given cell
	private Neighbours calculateNeighbours(int rowRef, int colRef) {
		Neighbours temp = new Neighbours();
		
		//Works out potential neighbours based on position in boolean array
		if(rowRef>0) {
			if(colRef>0) temp.addNeighbour(original.getGenerationElement(rowRef-1, colRef-1));
			temp.addNeighbour(original.getGenerationElement(rowRef-1, colRef));
			if(colRef<original.getColumnsNo()-1) temp.addNeighbour(original.getGenerationElement(rowRef-1, colRef+1));
		}
		
		if(colRef>0) temp.addNeighbour(original.getGenerationElement(rowRef, colRef-1));
		if(colRef<original.getColumnsNo()-1) temp.addNeighbour(original.getGenerationElement(rowRef, colRef+1));
		
		if(rowRef<original.getRowsNo()-1) {
			if(colRef>0) temp.addNeighbour(original.getGenerationElement(rowRef+1, colRef-1));
			temp.addNeighbour(original.getGenerationElement(rowRef+1, colRef));
			if(colRef<original.getColumnsNo()-1) temp.addNeighbour(original.getGenerationElement(rowRef+1, colRef+1));
		}
		
		return temp;
	}//end calculateNeighbours method
	
	//Calculates status of a given cell based on live numbers of cell
	private boolean calculateStatus(boolean cell, int livingNeighbours) {
		
		//Rules 1,2 and 3 covered by whether too many or too few neighbours
		if((livingNeighbours<2 || livingNeighbours>3) && cell==true) cell=false;
		//Rule 4 to bring cells back to life if exactly 3 neighborus
		else if(livingNeighbours==3 && cell==false) cell=true;
		
		return cell;
	}//end calculateStatus method

}//end Evolution class
