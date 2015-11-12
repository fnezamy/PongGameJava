import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * Animates a simple graphical game.
 * 
 * Uses a Swing Timer to advance the animation; keeps track of, and renders, all GameObjects. Handles all relevant game events.
 * 
 * @author sdexter72
 *
 */

public class GamePanel extends JPanel implements ActionListener {
	
   	/**
	 * 
	 */
	static boolean gameRunning = false;//if the game is running
	public static int WIDTH = 800;//the width of the game, needed so gameObject can access
	public static int HEIGHT = WIDTH / 16 * 9;//the height of the game, needed so gameObject can access
	private static final long serialVersionUID = 1L;
	static final int FRAME_RATE = 30; // animation proceeds at 30 frames per second
	Timer t;	// animation timer
	
	public static GameObject ball; // bare-bones animation: just a simple object that slides across the panel
    public static PlayerPaddle player;//player paddle object
    public static AIPaddle ai;//ai paddle object
    Thread thread;
    static int p1score;
	static int p2score;
	BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);//helps to buffer the image
	
	/**
	 * Sets up panel background, creates game Timer, creates initial GameObjects
	 * 
	 */
	
	GamePanel () {
		
		setBackground(Color.BLACK);
        t = new Timer(1000/FRAME_RATE, this);	
		ball = new GameObject(450,125,30,30,5,5);//set the ball to start here
		player = new PlayerPaddle(5,125);//set the paddle to start and move here
		ai = new AIPaddle(750,125);//set the ai paddle to start and move here
		
	}
	
	/**
	 * How to render one "frame" of the animation
	 */
	
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.drawImage(image, 0, 0, getWidth(), getHeight(),null);
		g.setColor(Color.WHITE);
		g.drawLine(WIDTH/2,0,WIDTH/2,0);
		super.paintComponent(g);//calls the super constructor
		setDoubleBuffered(true);//helps to reduce screen tearing
		g.setColor(Color.CYAN);//sets the color of the score
		g.drawString("Player 1: " + p1score,250,50);//draws player 1s score
		g.drawString("Player 2: "+ p2score, 500, 50);//draws player 2s score
		player.render(g);//draw the player one paddle
		ai.render(g);//draw the ai paddle
		ball.render(g);//draw the ball
		g.dispose();//dispose of the graphics
	

	}

	/**
	 * Responds to all actionPerformed events. In bare-bones implementation, these are just 'ticks' from the timer.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if this is an event from the Timer, call the method that advances the animation
		if (e.getSource() == t) {
			tick();
			
		}
	}


	/**
	 * Make sure all GameObjects are in the right place (do any need to be removed? do we need to create any new ones?), then redraw game
	 */
	
	private void tick() {
		ball.step();	// we just have the ball right now, so this is easy
		repaint();// ask to have the game redrawn (this will invoke paintComponent() when the system says the time is right)
		player.tick(this);//handle the player paddle's animation
		repaint();//repaint the paddle
		ai.tick(this);//handle the ai paddle's animation
		repaint();	//repaint the paddle
	}
	
	/**
	 * Start the Timer: this will cause events to be fired, and thus the animation to begin
	 */
	
	void go() {
		t.start();
		gameRunning = true;//the game is running
		thread = new Thread();//initialize thread
		thread.start();//start the thread
		try{
			Thread.sleep((long) 0.1);//sets how fast the game should run
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	static void stop(){//exits the game
		gameRunning = false;
		System.exit(0);
	}
	

}
