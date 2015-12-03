import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Sets up the play paddle of the game
 * 
 * Creates a bounding box around the player paddle and declares movement for the player paddle.
 * 
 */

//!! shouldn't this extend GameObject?

public class PlayerPaddle {
	
	int x;//left and right
	int y;//up and down
	int width = 30;//width of the paddle
	int height = 100;//height of the paddle
	
	int speed = 6;//speed at which player paddle will go
	
	Rectangle boundingBox;
	boolean goingUp = false;
	boolean goingDown = false;
	
	/**
	 * constructor that GamePanel calls, the width and height are the parameters passed in
	 */
	public PlayerPaddle(int x, int y){
		this.x = x;
		this.y = y;
		
		boundingBox = new Rectangle(x,y,width,height);//initalizes the bounding box

		
		
	}

		/**
		 * calls updates to the player's paddle. 
		 * Moves the player paddle up and down
		 * 
		 */
	public void tick(GamePanel game){
		boundingBox.setBounds(x,y,width,height);//sets the bounds of the box
	
		if(goingUp && y>=0){//if the paddle is moving up AND the height is not less than the screen
			y-=speed;//player paddle moves up 
		}	
		if(goingDown &&y + height < game.getHeight() ){//if the paddle is moving down AND the height is not greater than the game frame's height
			y+=speed;//player paddle moves down
		}
		
	}
	
	
	
	/**
	 * Called from the GamePanel's paintCompnenet method.
	 * 
	 * Draws the player paddle
	 * 
	 */
	public void render(Graphics g){//draws player paddle
		g.setColor(Color.WHITE);//set color
		g.fillRect(x, y, width, height);//fill the object
	}
}
