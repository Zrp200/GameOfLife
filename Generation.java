import java.util.Arrays;


public class Generation {
	
	private boolean[][] generation;
	
	public Generation(World world) {
		generation = new boolean[world.getRows()][world.getColumns()];
		setGeneration(world);
	}//end standard constructor
	
	public Generation(Generation other) {
		generation = new boolean[other.getRowsNo()][other.getColumnsNo()];
		for (int i=0; i<generation.length; i++) {
			generation[i] = Arrays.copyOf(other.getRow(i), other.getColumnsNo());
		}
	}
	
	
	//Accessor Methods
	public int getRowsNo() {
		return generation.length;
	}
	
	public int getColumnsNo() {
		return generation[0].length;
	}
	
	public boolean[] getRow(int row) {
		return generation[row];
	}
	
	public boolean getGenerationElement(int row, int column) {
		return generation[row][column];
	}//end getGenerationElement accessor method
	
	//Transformer Methods
	public void setGeneration(World world) {
		
		for(int i=0; i<generation.length; i++) {
			for(int j=0; j<generation[i].length; j++) {
				
				generation[i][j] = world.getElementState(i, j);
				
			}//end columns loop
		}//end rows loop
		
	}//end setGeneration transformer method
	
	public void setGeneration(Generation other) {
		
		for(int i=0; i<generation.length; i++) {
			for(int j=0; j<generation[i].length; i++) {
				
				generation[i][j] = other.getGenerationElement(i, j);
				
			}//end columns loop
		}//end rows loop
		
	}//end setGeneration transformer method
	
	public void setGenerationElement(int row, int column, boolean state) {
		generation[row][column] = state;
	}//end setGenerationElement transformer method
	
}//end Generation class
