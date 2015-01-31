import java.util.ArrayList;


public class Neighbours {

	private ArrayList<Boolean> neighbours;
	
	//Constructor Methods
	public Neighbours() {
		neighbours = new ArrayList<Boolean>();
	}
	
	//Accessor Methods
	public int liveCount() {
		int count=0;
		
		for(boolean b: neighbours) {
			if(b) count++;
		}
		
		return count;
	}
	
	public int getNeighboursNo() {
		return neighbours.size();
	}
	
	//Transformer Methods
	public void addNeighbour(Boolean state) {
		neighbours.add(state);
	}//end addNeighbour transformer method
	
	public void clear() {
		neighbours.removeAll(neighbours);
	}//end clear transformer method
	
}//end Neighbours class
