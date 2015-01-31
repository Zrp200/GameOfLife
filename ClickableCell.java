import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class ClickableCell extends DisplayCell {

	
	public ClickableCell() {
		
		super();
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				toggleState();
			}
		});
		
	}		
	
	public void toggleState() {
		if(state) {
			state=false;
			setBackground(Color.white);
		} else {
			state=true;
			setBackground(Color.black);
		}
	}
	
}//end ClickableCell class
