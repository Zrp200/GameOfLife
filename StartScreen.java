import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class StartScreen extends JPanel{


	private JTextField rows, columns;
	private JLabel textLb, rowsLb, colsLb, errorLb;
	
	public StartScreen(JButton action) {
		
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
		
		
		textLb.setAlignmentX(Component.CENTER_ALIGNMENT);
		rowsLb.setAlignmentX(Component.CENTER_ALIGNMENT);
		rows.setAlignmentX(Component.CENTER_ALIGNMENT);
		colsLb.setAlignmentX(Component.CENTER_ALIGNMENT);
		columns.setAlignmentX(Component.CENTER_ALIGNMENT);
		errorLb.setAlignmentX(Component.CENTER_ALIGNMENT);
		action.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(textLb);
		add(rowsLb);
		add(rows);
		add(colsLb);
		add(columns);
		add(errorLb);
		add(action);
	}
	
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
	}
	
	public int getRows() {
		return Integer.parseInt(rows.getText());
	}
	
	public int getColumns() {
		return Integer.parseInt(columns.getText());
	}
	
	private boolean onlyNumbers(String input) {
		char[] chars = input.toCharArray();
		
		for (char c: chars) {//check each number in array
			//return false if not number
			if(!Character.isDigit(c)) return false;
		}
		//else return true
		return true;
	}//end onlyNumbers accessor method
	
	private void setError() {
		errorLb.setText("You must input integer numbers");
	}
	
	private void clearError() {
		errorLb.setText("");
	}
	
	
	
}
