
public class World {
	
	private Cell[][] world;

	//Constructor Methods
	public World(int rows, int columns) {
		world = new Cell[rows][columns];
		birthCells();
	}//end basic constructor
	
	public World(int rows, int columns, String worldState) {
		this(rows, columns);
		setWorldState(worldState);
	}//end standard constructor
	
	
	//Display Methods
	public void displayWorldState() {
		System.out.println();
		for(int i=0; i<world.length; i++) {
			for(int j=0; j<world.length; j++) {
				System.out.print(world[i][j].toString());
			}
			System.out.println();
		}
	}
	
	//Accessor Methods
	public int getRows() {
		return world.length;
	}//end getRows accessor method
	
	public int getColumns() {
		return world[0].length;
	}//end getColumns accessor method
	
	public boolean getElementState(int row, int column) {
		return world[row][column].getState();
	}//end getElementState accessor method
	
	
	//Transformer Methods
	public void nextGeneration(Generation newGen) {
		boolean state;
		
		for(int i=0; i<world.length; i++) {
			for(int j=0; j<world[i].length; j++) {
				state = newGen.getGenerationElement(i, j);
				setElementState(i, j, state);
			}//end columns loop
		}//end rows loop
		
	}//end nextGeneration transformer method
	
	public void setElementState(int row, int column, boolean state) {
		world[row][column].setState(state);
	}//end setElementState transformer method
	
	
	private void birthCells() {
		for(int i=0; i<world.length; i++) {
			for(int j=0; j<world[i].length; j++) {
				world[i][j] = new Cell();
			}//end column loop
		}//end row loop
	}//end birthCells method
	
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
	
}//end World class
