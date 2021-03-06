/**
 * <h1>GUIController</h1>
 * 
 * Starts GUI for game world
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
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

}//end GUIController
