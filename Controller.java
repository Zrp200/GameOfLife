import java.util.Scanner;


public class Controller {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//Variable declarations
		int rows, columns;
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
		
		World newWorld = new World(rows, columns, startState);
		
		System.out.println("Your new world:");
		newWorld.displayWorldState();
		
		Generation current = new Generation(newWorld);
		
		Evolution nextGen = new Evolution(current);
		
		Generation future = nextGen.newEvolution();
		
		newWorld.nextGeneration(future);
		
		System.out.println("The next generation");		
		newWorld.displayWorldState();
		

	}
	
	private static boolean checkStateSize(int rows, int columns, String state) {
		char[] check = state.toCharArray();
		if (check.length==rows*columns) return true;
		else {
			System.out.println("Sorry that input did not have the right number of elements");
			return false;
		}
	}//end checkStateSize static method

}
