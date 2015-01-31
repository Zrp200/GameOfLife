import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * <h1>WorldScreen Object</h1>
 * Defines the display of the cellular world defined in the game.
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
public class WorldScreen extends JPanel{
	
	private JPanel footer;
	private JPanel worldView;
	
	private DisplayCell[][] worldCells;
	
	private int genCount;
	private JLabel generationLb;
	
	private JButton nextGen;
	
	private World world;

	//Constructor method
	/**
	 * Standard constructor for the WorldScreen display panel.
	 * 
	 * @param rows		The number of rows of cells to be displayed
	 * @param columns	The number of columns of cells to be displayed
	 * @param restart	A button for placement on screen
	 */
	public WorldScreen (int rows, int columns, JButton restart) {
		
		setLayout(new BorderLayout());
		
		//Create World View
		worldView = new JPanel();
		worldView.setLayout(new GridLayout(rows, columns));
		worldCells = new DisplayCell[rows][columns];
		
		//Create cells on screen
		for (int i=0; i<worldCells.length; i++) {
			for (int j=0; j<worldCells[i].length; j++) {
				worldCells[i][j] = new DisplayCell();
				
				worldView.add(worldCells[i][j]);
			}//end columns loop
		}//end rows loop
		
		add(worldView, BorderLayout.CENTER);
		
		//Create footer with controls
		footer = new JPanel();
		footer.add(restart);
		
		nextGen = new JButton("Next Generation");
		nextGen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextGeneration();
			}
		});
		footer.add(nextGen);
		
		genCount = 1;
		generationLb = new JLabel("Generation: " + genCount);
		footer.add(generationLb);
		
		
		add(footer, BorderLayout.SOUTH);		
	}//end standard constructor
	
	//Transformer Methods
	/**
	 * Creates the world based on the input from setup screen
	 * 
	 * @param worldState	A 2D boolean array
	 */
	public void setupWorld(boolean[][] worldState) {
		
		world = new World(worldCells.length, worldCells[0].length, worldState);
		
		updateDisplay(worldState);
	}//end setupWorld transformer method
	
	//Update display based on 2d boolean array
	private void updateDisplay(boolean[][] worldState) {
		for (int i=0; i<worldState.length; i++) {
			for (int j=0; j<worldState.length; j++) {
				worldCells[i][j].setState(worldState[i][j]);
			}//end columns loop
		}//end rows loop
		
		generationLb.setText("Generation: " + genCount);
	}//end updateDisplay method
	
	//Create next generation
	private void nextGeneration() {
		//Create a generation based on world status
		Generation current = new Generation(world);
		//Create an evolution
		Evolution nextGen = new Evolution(current);
		//Create the next generation
		Generation future = nextGen.newEvolution();
		//Update the world state
		world.nextGeneration(future);
		//Update the display
		genCount++;
		updateDisplay(future.getGeneration());
	}//end nextGeneration method
		
}//end WorldScreen class
