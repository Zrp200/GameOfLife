
public class GUIController {

public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainForm f = new MainForm();
				f.setSize(600,600);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		
	}//end main method
}
