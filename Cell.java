
public class Cell {

	private boolean living;
	
	//Constructor Methods
	public Cell() {
		living = false;
	}//end default constructor
	
	public Cell(boolean status) {
		living = status;
	}//end standard constructor
	
	public Cell(Cell other) {
		living = other.getState();
	}//end clone constructor
	
	
	//Accessor Methods
	public String toString() {
		if(living) return "X";
		else return ".";
	}
	
	public boolean getState() {
		return living;
	}
	
	//Transformer Methods
	public void setState(boolean status) {
		living = status;
	}
}//end Cell class
