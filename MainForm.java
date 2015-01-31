import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <h1>Mainform Object</h1>
 * Creates the main program window and controls
 * overall flow of the program.
 * 
 * @author <a href="mailto:dave@mrmanton.com">Dave Manton</a>
 * @see <a href="https://github.com/davemanton/GameOfLife">GitHub Project Repository</a>
 */
public class MainForm extends JFrame {

	//Main Screen Elements
	private JPanel mainContainer;
	private CardLayout mainWindow;
	
	//First Screen Elements
	private StartScreen firstScreen;
	private JButton startBtn;
	
	//Second Screen Elements
	private SetupScreen setupWorldScreen;
	private JButton createWorld;
	
	//Second Screen Elements
	private WorldScreen worldScreen;
	private JButton restart;	
	
	//Constructor
	/**
	 * Constructor for main program window
	 */
	public MainForm() {
		super("Conway's Game of Life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create Screens
		//First Screen
		startBtn = new JButton("Start Creating World");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startWorldSetup();
			}
		});
		firstScreen = new StartScreen(startBtn);
		
		
		//Add to Card Layout
		mainContainer = new JPanel();
		mainWindow = new CardLayout();
		mainContainer.setLayout(mainWindow);
		
		mainContainer.add(firstScreen, "firstScreen");
		
		mainWindow.show(mainContainer, "firstScreen");
		
		add(mainContainer);
		
	}
	
	//Starts second screen to allow set up of the world
	private void startWorldSetup() {
		//Checks input is valid
		if(firstScreen.validateInput()) {
			//Creates button for set up screen and creates action
			createWorld = new JButton("Create World");
			createWorld.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createWorld();					
				}
			});
			
			//Creates second screen and adds to program
			setupWorldScreen = new SetupScreen(firstScreen.getRows(), firstScreen.getColumns(), createWorld);
			mainContainer.add(setupWorldScreen, "secondScreen");
			mainWindow.show(mainContainer, "secondScreen");
		}
	}//end startWorldSetup method
	
	//Creates world for start of game
	private void createWorld() {
		//Creates button for returning to beginning of setuo
		restart = new JButton("New World");
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartScreens();
			}
		});
		worldScreen = new WorldScreen(firstScreen.getRows(), firstScreen.getColumns(), restart);
		
		//Set up game world based on input
		boolean[][] setupState = setupWorldScreen.getSetupState();
		worldScreen.setupWorld(setupState);
		
		//Add new screen for game world
		mainContainer.add(worldScreen, "thirdScreen");
		mainWindow.show(mainContainer, "thirdScreen");
	
	}//end createWorld method
	
	//Allows return to the beginning of set up.
	private void restartScreens() {
		mainWindow.show(mainContainer, "firstScreen");
	}//end restartScreens method	
	
}//end MainForm class
