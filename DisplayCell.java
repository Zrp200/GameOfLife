import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * <h1>DisplayCell Object</h1>
 * Creates an object which can be used to display the state
 * of living and dead cells on screen.
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
public class DisplayCell extends JPanel{

	protected boolean state;
	
	/**
	 * Default constructor
	 */
	public DisplayCell() {
		
		state=false;
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.gray));
	}//end default constructor	
	
	/**
	 * Gives the state of the cell
	 * 
	 * @return	Returns the boolean state of the cell
	 */
	public boolean getState() {
		return state;
	}//end getState accessor method
	
	/**
	 * Sets the state of the cell
	 * 
	 * @param newState	The boolean state of the cell to be set
	 */
	public void setState(boolean newState) {
		if(newState) {
			state=true;
			setBackground(Color.black);
		} else {
			state=false;
			setBackground(Color.white);
		}
	}//end setState method

}//end DisplayCell class
