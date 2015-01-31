import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * <h1>ClickableCell Object</h1>
 * Extends DisplayCell to create a cell which can be toggled by clicking
 * Allows the definition of a game state by clicking on cells to define 
 * whether their living status.
 * <p>Blank=Alive, White=Dead</p>
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
public class ClickableCell extends DisplayCell {

	/**
	 * Default constructor
	 */
	public ClickableCell() {
		//Uses DisplayCell constructor
		super();
		//Creates listener object for cell
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				toggleState();
			}
		});	
	}//end default constructor		
	
	//Toggle living state method for click event
	private void toggleState() {
		if(state) {
			state=false;
			setBackground(Color.white);
		} else {
			state=true;
			setBackground(Color.black);
		}
	}//end toggleState method
	
}//end ClickableCell class
