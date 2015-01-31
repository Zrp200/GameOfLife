import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WorldScreen extends JPanel{
	
	private JPanel footer;
	private JPanel worldView;
	
	private DisplayCell[][] worldCells;
	
	private int genCount;
	private JLabel generationLb;
	
	private JButton nextGen;
	
	private World world;

	public WorldScreen (int rows, int columns, JButton restart) {
		
		setLayout(new BorderLayout());
		
		//Create World View
		worldView = new JPanel();
		worldView.setLayout(new GridLayout(rows, columns));
		worldCells = new DisplayCell[rows][columns];
		
		for (int i=0; i<worldCells.length; i++) {
			for (int j=0; j<worldCells[i].length; j++) {
				worldCells[i][j] = new DisplayCell();
				
				worldView.add(worldCells[i][j]);
			}
		}
		
		add(worldView, BorderLayout.CENTER);
		
		
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
		
		
		
	}
	
	public void setupWorld(boolean[][] worldState) {
		
		world = new World(worldCells.length, worldCells[0].length, worldState);
		
		updateDisplay(worldState);
	}
	
	private void updateDisplay(boolean[][] worldState) {
		for (int i=0; i<worldState.length; i++) {
			for (int j=0; j<worldState.length; j++) {
				worldCells[i][j].setState(worldState[i][j]);
			}
		}
		
		generationLb.setText("Generation: " + genCount);
	}
	
	private void nextGeneration() {
		Generation current = new Generation(world);
		
		Evolution nextGen = new Evolution(current);
		
		Generation future = nextGen.newEvolution();
		
		world.nextGeneration(future);
		
		genCount++;
		updateDisplay(future.getGeneration());
	}
	
	
}
