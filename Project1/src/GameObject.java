import java.awt.Point;

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

	protected int xSpeed;
	protected int ySpeed;

	/**
	 * 
	 * IMPLEMENT THIS! Should return true if object1 and object2 have collided.
	 * 
	 * @return The two objects have collided.
	 */

	public static boolean collide(GameObject object1, GameObject object2) {
		return true;
	}

	/**
	 * Initialize object with top and bottom corners and initial x- and y-speed
	 * 
	 */

	public GameObject(Point topLeft, Point bottomRight, int xSpeed, int ySpeed) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;

		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
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
		this.xSpeed = xSpeed;
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
		topLeft.x += xSpeed;
		bottomRight.x += xSpeed;

		topLeft.y += ySpeed;
		bottomRight.y += ySpeed;
	}

	/**
	 * IMPLEMENT THIS: What should an object do if it reaches the boundary of
	 * the game space?
	 * 
	 * (Of course, you can override this implementation if your subclasses
	 * should behave differently)
	 */

	public void bounce() {
	}
}
