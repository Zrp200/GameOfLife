
public class Evolution {
	
	private Generation original;
	private Generation evolution;

	public Evolution(Generation origins) {
		original = origins;
		evolution = new Generation(origins);
	}
	
	public Generation newEvolution() {
		boolean workingCellState, newCellState;
		Neighbours workingCellNeighbours;
		
		
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
	}
	
	private Neighbours calculateNeighbours(int rowRef, int colRef) {
		Neighbours temp = new Neighbours();
		
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
	}
	
	private boolean calculateStatus(boolean cell, int livingNeighbours) {
		
		if((livingNeighbours<2 || livingNeighbours>3) && cell==true) cell=false;
		else if(livingNeighbours==3 && cell==false) cell=true;
		
		return cell;
	}

}
