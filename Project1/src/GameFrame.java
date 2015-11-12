import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
/**
 * Set the frame that the game runs on.
 * 
 */

public class GameFrame {
	public GameFrame(){
		final int WIDTH = 800;//height of the game's frame
    	final int HEIGHT = WIDTH / 16 * 9;//width of the games frame
    	final Dimension gameSize = new Dimension(WIDTH, HEIGHT);//set the dimensions of the game
        JFrame frame = new JFrame("Pong");
        frame.setMinimumSize(gameSize);//Set the minimum size of the game
		frame.setPreferredSize(gameSize);//set the preferred size of the game
		frame.setMaximumSize(gameSize);//set the maximum size of the game
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the game on clicking the X
        frame.setResizable(false);//can not resize the game
        frame.setLocationRelativeTo(null);//center the game frame
        frame.setVisible(true);//set it visable
        frame.setLayout(new BorderLayout());
        InputHandler ih = new InputHandler();//declare and initialize the input handler
        
        // bare bones: just add a panel where the game objects are drawn
        
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.pack();//pack everything in
        
        frame.setSize(WIDTH,HEIGHT);
        frame.addKeyListener(ih);//add the key listener
      
        // the game starts when the game panel animation begins
        
        gamePanel.go();
	}

}
