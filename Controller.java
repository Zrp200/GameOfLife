import java.util.Scanner;

/**
 * <h1>Text Controller</h1>
 * Controller for creating a game world based on text input.
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
public class Controller {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//Variable declarations
		int rows, columns, gens;
		String startState;
		
		//Collect starting state input
		System.out.print("How many rows are in your world: ");
		rows = in.nextInt();
		System.out.print("How many columns are in your world: ");
		columns = in.nextInt();
		
		System.out.println();
		System.out.println("Please input the starting state of your world");
		System.out.println("You must use 'X' for living cells and '.' for dead cells"); 
		System.out.println("don't seperate them with any demarcation");
		
		do {
			startState = in.next();
		} while	(!checkStateSize(rows, columns, startState)); 

		System.out.print("How many generations would you like to see ");
		gens = in.nextInt();
		
		in.close();
		World newWorld = new World(rows, columns, startState);
		
		//Display state of world
		System.out.println("Your new world:");
		newWorld.displayWorldState();
		
		//Creates next generation
		for(int i=1; i<gens+1; i++) {
			//Create generation object
			Generation current = new Generation(newWorld);
			//Create evolution object
			Evolution nextGen = new Evolution(current);
			//Creates next generation based on evolution
			Generation future = nextGen.newEvolution();
			//Apply next generation to game world
			newWorld.nextGeneration(future);
			//Display the new game world state
			System.out.println("Generation: " + i);		
			newWorld.displayWorldState();
		}

	}//end main
	
	//Basic error checking of the world state input size
	private static boolean checkStateSize(int rows, int columns, String state) {
		char[] check = state.toCharArray();
		if (check.length==rows*columns) return true;
		else {
			System.out.println("Sorry that input did not have the right number of elements");
			return false;
		}
	}//end checkStateSize static method

}//end Controller
