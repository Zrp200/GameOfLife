import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class SetupScreen extends JPanel{

	private ClickableCell[][] worldSetup;
	private JPanel worldView, header;
	
	public SetupScreen (int rows, int columns, JButton action) {
		
		setLayout(new BorderLayout());
		header = new JPanel();
		header.add(action);
		add(header, BorderLayout.SOUTH);
		
		
		//Create World View
		worldView = new JPanel();
		worldView.setLayout(new GridLayout(rows, columns));
		worldSetup = new ClickableCell[rows][columns];
		
		for (int i=0; i<worldSetup.length; i++) {
			for (int j=0; j<worldSetup[i].length; j++) {
				worldSetup[i][j] = new ClickableCell();
				
				worldView.add(worldSetup[i][j]);
			}
		}
		
		add(worldView, BorderLayout.CENTER);
	}
	
	public boolean[][] getSetupState() {
		boolean[][] setupState = new boolean[worldSetup.length][worldSetup[0].length];
		
		for (int i=0; i<setupState.length; i++) {
			for (int j=0; j<setupState[i].length; j++) {
				setupState[i][j] = worldSetup[i][j].getState();
			}
		}
		
		return setupState;
	}
}
