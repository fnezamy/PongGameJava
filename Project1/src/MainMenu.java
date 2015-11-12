import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
/**
 * Sets up the main menu screen using a JFrame.
 * 
 * Each button has shares the same width and height, the two player check box allows checks if it is selected
 * and if it is, changes the value of isTwoPlayers in AIPaddle to be true.
 */

public class MainMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	int screenWidth = 375;//Width of the mainmenu
	int screenHeight = 300;//Height of the mainmenu
	
	int buttonWidth = 100;//width of all the buttons
	int buttonHeight = 40;//height of all the buttons
	
	JButton Play,Quit;//declare two jbuttons, Play and Quit
	JCheckBox twoPlayer;//declare a jcheckbox, twoPlayer
	
	
	/**
	 * MainMenu constructor
	 * 
	 * Sets the bounds of the two buttons and the JCheckbox and adds all three to the frame
	 */
	public MainMenu(){
		addButtons();//add the buttons
		addActions();//add the button's actions
		
		getContentPane().setLayout(null);//set bounds of the button to be centered
		Play.setBounds((screenWidth - buttonWidth)/2,5,buttonWidth,buttonHeight);//Position the play button
		Quit.setBounds((screenWidth - buttonWidth)/2,50,buttonWidth,buttonHeight);//Position the quit button
		twoPlayer.setBounds((screenWidth - buttonWidth)/2,95,buttonWidth,buttonHeight);//Position the two player checkbox
		
		getContentPane().add(Play);//add the Play button to the JFrame
		getContentPane().add(Quit);//add the Quit button to the JFrame
		getContentPane().add(twoPlayer);//add the two player check box to the JFrame
		
		pack();//pack everything into the JFrame
		setVisible(true);//set the frame to be visible
		setLocationRelativeTo(null);//set the location to the center
		setSize(screenWidth,screenHeight);//set the size of the frame
		setTitle("Pong");//set the title of the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);//can not resize the frame
	}

	/**
	 * Initialize all the buttons
	 */
	private void addButtons() {
		System.out.println("To move up, use W. To move down, use S. Game will quit when the score of 3 is reached");
		Play = new JButton("Play");
		Quit = new JButton("Quit");
		twoPlayer = new JCheckBox("Two Players?");
		System.out.println("The second player uses the directional UP key to move up and the directional DOWN key to move down");
	}
	
	/**
	 * Declare the actions of each button
	 * 
	 * Checks to see if twoPlayer is selected and changes the AIPaddle's isTwoPlayer to true if selected
	 * and false if not.
	 * 
	 * Calls the GameFrame constructor and calls GamePanel's go method
	 * 
	 */
	private void addActions(){//add all the actions of the buttons
		Play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();//disposes of the JFrame
				GamePanel game = new GamePanel();//Creates a new game object
				if(twoPlayer.isSelected()){//if two player is checked
					GamePanel.ai.isTwoPlayer=true;//set the twoPlayer to true
				}
				else{
					GamePanel.ai.isTwoPlayer=false;
				}
				new GameFrame();//create the frame of the game
				game.go();//start the game
			}
		});
			Quit.addActionListener(new ActionListener(){//exits the game
				public void actionPerformed(ActionEvent e){
					GamePanel.stop();//calls GamePanel's stop method
				}
			});
		
	}
}

