import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Models an 'object' that is rendered in the game display.
 * 
 * Each object has a "bounding box" defined by its top left and bottom right
 * corners. Each object has a speed in the x and y directions, which can be
 * changed the set and accel methods.
 * 
 * Subclasses may add additional behavior as necessary. Subclasses should NOT
 * implement rendering behavior; that is to be implemented by classes that use
 * GameObjects.
 * 
 * @author sdexter72
 *
 */

public class GameObject {
	protected Point topLeft; // initial coordinates of top left corner of object
	protected Point bottomRight; // initial coordinates of bottom left corner of
									// object
	protected static int speed = 4; //overall speed of the object
	protected static int xSpeed; 
	protected int ySpeed;
	static Rectangle boundingBox; //declare a rectangle object
	
	protected int size = 20;//size of the object

	/**
	 * 
	 * IMPLEMENT THIS! Should return true if object1 and object2 have collided.
	 * 
	 * @return The two objects have collided.
	 */

	public static boolean collide() {
			if(boundingBox.intersects(GamePanel.player.boundingBox)){//if the ball's bounding box intersects the players bounding box
				xSpeed = speed;//change the direction of the ball 
				return true;
			}else if(boundingBox.intersects(GamePanel.ai.boundingBox)){//if the ball's bounding box intersects the AI's bounding box
				xSpeed = -speed;//change the direction of the ball
				return true;
			}
			else
				return false;//no collision occurs
	}

	/**
	 * Initialize object with top and bottom corners and initial x- and y-speed
	 * 
	 */

	public GameObject(Point topLeft, Point bottomRight, int xSpeed, int ySpeed) {
		this.topLeft = topLeft; 	
		this.bottomRight = bottomRight;

		GameObject.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		boundingBox = new Rectangle(topLeft.x,bottomRight.y,getWidth(),getHeight());//initialize the rectangle object
		boundingBox.setBounds(topLeft.x,bottomRight.y,getWidth(),getHeight());//create a bounding box over the object
		
	
	}

	/**
	 * Initialize object with top corner, height, width, and initial x- and
	 * y-speed
	 * 
	 */

	public GameObject(int initX, int initY, int height, int width, int xSpeed, int ySpeed) {
		this(new Point(initX, initY), new Point(initX + width, initY + height), xSpeed, ySpeed);
	}

	/**
	 * Initialize object with top corner at (0,0), with given height and width,
	 * and initial speed 5 in the x-dimension
	 * 
	 */

	public GameObject(int height, int width) {
		this(0, 0, height, width, 5, 0);
	}

	/**
	 * Set the GameObject's speed in the x dimension
	 * 
	 * @param xSpeed
	 *            The desired x-speed.
	 */

	public void setXSpeed(int xSpeed) {
		GameObject.xSpeed = xSpeed;
	}

	/**
	 * Set the GameObject's speed in the x dimension
	 * 
	 * @param ySpeed
	 *            The desired y-speed.
	 */
	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	/**
	 * Increase the GameObject's speed in the x dimension
	 * 
	 * @param x
	 *            The amount of increase.
	 */

	public void accelX(int x) {
		xSpeed += x;
	}

	/**
	 * Increase the GameObject's speed in the y dimension
	 * 
	 * @param y
	 *            The amount of increase.
	 */

	public void accelY(int y) {
		ySpeed += y;
	}

	/**
	 *
	 * @return A Point representing the top-left corner of the GameObject's
	 *         bounding box
	 */
	public Point getTopLeft() {
		return topLeft;
	}

	/**
	 *
	 * @return A Point representing the bottom-right corner of the GameObject's
	 *         bounding box
	 */

	public Point getBottomRight() {
		return bottomRight;
	}

	/**
	 * 
	 * @return The height (in pixels) of the GameObject
	 */
	public int getHeight() {
		return bottomRight.y - topLeft.y;
	}

	/**
	 * 
	 * @return The width (in pixels) of the GameObject
	 */

	public int getWidth() {
		return bottomRight.x - topLeft.x;

	}

	/**
	 * Changes the location of the object for the next "animation frame"
	 * 
	 */

	public void step() {
		boundingBox.setBounds(topLeft.x,bottomRight.y, getWidth(), getHeight());//sets the box around the ball to bounce the ball off of the pads
		
		if(topLeft.x<=0){//if the ball hits the left wall
			GamePanel.p2score++;//player 2's score increases
			if(GamePanel.p2score>=3){
				GamePanel.stop();
			}
			xSpeed=speed;//change the direction of the ball
		}else if (topLeft.x + size>= GamePanel.WIDTH - size){//if the ball hits the right wall
			GamePanel.p1score++;//player 1's score increases
			if(GamePanel.p1score>=3){
				GamePanel.stop();
			}
			xSpeed = -speed;//change the direction of the ball
		}
		
		if(bottomRight.y <= 0){//if the ball hits the top of the screen
			ySpeed = speed;//change the direction of the ball
		}else if(bottomRight.y + size >= GamePanel.HEIGHT - (size * 3)){//if the ball hits the bottom of the screen
			ySpeed = -speed;//change the direction of the ball
		}
		
		topLeft.x += xSpeed;
		bottomRight.x += xSpeed;

		topLeft.y += ySpeed;
		
		bottomRight.y += ySpeed;
		
		collide();//handle a collision 
	}

	/**
	 * IMPLEMENT THIS: What should an object do if it reaches the boundary of
	 * the game space?
	 * 
	 * (Of course, you can override this implementation if your subclasses
	 * should behave differently)
	 */

	public void bounce() {
		boundingBox = new Rectangle(topLeft.x, bottomRight.y,getWidth(), getHeight());//initialize a boundingbox over the object to bounce
		boundingBox.setBounds(topLeft.x, bottomRight.y,getWidth(),getHeight());//set the bounds of the box
		
	}
	
	//creates the graphics of the ball
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(topLeft.x, bottomRight.y, getWidth(),getHeight());
	}
	
}
