import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class DisplayCell extends JPanel{

	protected boolean state;
	
	public DisplayCell() {
		
		state=false;
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.gray));

	}	
	
	public boolean getState() {
		return state;
	}
	
	public void setState(boolean newState) {
		if(newState) {
			state=true;
			setBackground(Color.black);
		} else {
			state=false;
			setBackground(Color.white);
		}
	}
}
