import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * <h1>SetupScreen Object</h1>
 * Creates the screen layout for setting up the world game state.
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
public class SetupScreen extends JPanel{

	private ClickableCell[][] worldSetup;
	private JPanel worldView, footer;
	
	//Standard Constructor
	/**
	 * Creates the setup screen object
	 * 
	 * @param rows		The number of rows in the world
	 * @param columns	The number of columns in the world
	 * @param action	A button to be used on the screen
	 */
	public SetupScreen (int rows, int columns, JButton action) {		
		
		setLayout(new BorderLayout());
		
		//Create World View
		worldView = new JPanel();
		worldView.setLayout(new GridLayout(rows, columns));
		worldSetup = new ClickableCell[rows][columns];
		
		//Add ClickableCells
		for (int i=0; i<worldSetup.length; i++) {
			for (int j=0; j<worldSetup[i].length; j++) {
				worldSetup[i][j] = new ClickableCell();
				
				worldView.add(worldSetup[i][j]);
			}
		}
		
		add(worldView, BorderLayout.CENTER);
		
		//Add footer with controls
		footer = new JPanel();
		footer.add(action);
		add(footer, BorderLayout.SOUTH);
	}//end standard constructor
	
	/**
	 * Gives the selected starting state of the game world
	 * 
	 * @return	Returns a 2d boolean array representing the game state
	 */
	public boolean[][] getSetupState() {
		boolean[][] setupState = new boolean[worldSetup.length][worldSetup[0].length];
		
		for (int i=0; i<setupState.length; i++) {
			for (int j=0; j<setupState[i].length; j++) {
				setupState[i][j] = worldSetup[i][j].getState();
			}
		}
		
		return setupState;
	}//end getSetupState method
	
}//end SetupScreen class
