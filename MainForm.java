import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	
	
	
	private ClickableCell[][] test;
	
	
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
	
	private void startWorldSetup() {
		if(firstScreen.validateInput()) {
			createWorld = new JButton("Create World");
			createWorld.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createWorld();					
				}
			});
			
			setupWorldScreen = new SetupScreen(firstScreen.getRows(), firstScreen.getColumns(), createWorld);
			mainContainer.add(setupWorldScreen, "secondScreen");
			mainWindow.show(mainContainer, "secondScreen");
		}
	}
	
	private void createWorld() {
		restart = new JButton("New World");
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartScreens();
			}
		});
		worldScreen = new WorldScreen(firstScreen.getRows(), firstScreen.getColumns(), restart);
		
		
		
		boolean[][] setupState = setupWorldScreen.getSetupState();
		
		worldScreen.setupWorld(setupState);
		
		mainContainer.add(worldScreen, "thirdScreen");
		mainWindow.show(mainContainer, "thirdScreen");
	}
	
	private void restartScreens() {
		mainWindow.show(mainContainer, "firstScreen");
	}
	
	
	
}
