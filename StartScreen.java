import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * <h1>StartScreen Object</h1>
 * The object which defines the start screen for the GUI
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
public class StartScreen extends JPanel{


	private JTextField rows, columns;
	private JLabel textLb, rowsLb, colsLb, errorLb;
	
	/**
	 * Standard constructor
	 * 
	 * @param action
	 */
	public StartScreen(JButton action) {
		
		//Defines layout
		LayoutManager layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		
		setLayout(layout);
		
		//Initialise elements
		textLb = new JLabel("Please input the world size");
		rowsLb = new JLabel("Rows:");
		rows = new JTextField("Number of Rows", 15);
		rows.setMaximumSize(rows.getPreferredSize());
		rows.setHorizontalAlignment(JTextField.CENTER);
		colsLb = new JLabel("Columns:");
		columns = new JTextField("Number of Columns", 15);
		columns.setMaximumSize(columns.getPreferredSize());
		columns.setHorizontalAlignment(JTextField.CENTER);
		errorLb = new JLabel();
		
		//Sets alignment for layout
		textLb.setAlignmentX(Component.CENTER_ALIGNMENT);
		rowsLb.setAlignmentX(Component.CENTER_ALIGNMENT);
		rows.setAlignmentX(Component.CENTER_ALIGNMENT);
		colsLb.setAlignmentX(Component.CENTER_ALIGNMENT);
		columns.setAlignmentX(Component.CENTER_ALIGNMENT);
		errorLb.setAlignmentX(Component.CENTER_ALIGNMENT);
		action.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Adds elements to layout
		add(textLb);
		add(rowsLb);
		add(rows);
		add(colsLb);
		add(columns);
		add(errorLb);
		add(action);
	}//end standard constructor
	
	/**
	 * Validates input from text fields.
	 * Should be used before input is taken.
	 * 
	 * @return	Returns true or false for valid input or not
	 */
	public boolean validateInput() {
		String input = "";
		input += rows.getText();
		input += columns.getText();
		
		if (!onlyNumbers(input) || rows.getText().equals("") || columns.getText().equals("")) {
			setError();
			return false;
		} else {
			clearError();
			return true;
		}
	}//end validateInput method
	
	/**
	 * Returns the rows input from the screen
	 * 
	 * @return		Returns an int number of rows
	 */
	public int getRows() {
		return Integer.parseInt(rows.getText());
	}
	
	/**
	 * Returns the columns input from the screen
	 * 
	 * @return		Returns an int number of columns
	 */
	public int getColumns() {
		return Integer.parseInt(columns.getText());
	}
	
	//Checks the input is only numerical
	private boolean onlyNumbers(String input) {
		char[] chars = input.toCharArray();
		
		for (char c: chars) {//check each number in array
			//return false if not number
			if(!Character.isDigit(c)) return false;
		}
		//else return true
		return true;
	}//end onlyNumbers accessor method
	
	//Sets an error on invalid input
	private void setError() {
		errorLb.setText("You must input integer numbers");
	}
	
	//Clears errors on valid input
	private void clearError() {
		errorLb.setText("");
	}	
	
}//end StartScreen class
