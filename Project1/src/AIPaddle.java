import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * 
 * AI paddle class
 *
 */
public class AIPaddle {
	int x;//left and right
	int y;//up and down
	int width = 30;
	int height = 100;
	
	int speed = 6;
	
	Rectangle boundingBox;
	boolean goingUp = false;
	boolean goingDown = false;
	boolean isTwoPlayer = false;
	public AIPaddle(int x, int y){
		this.x = x;
		this.y = y;
		boundingBox = new Rectangle(x,y,width,height);
		boundingBox.setBounds(x,y,width,height);
	    boundingBox = new Rectangle(x,y,width,height);//creates rectangle around object
		boundingBox.setBounds(x,y,width,height);// sets the bounds
		
		
	}

	public void tick(GamePanel game){//primitive sensor AI
		boundingBox.setBounds(x, y, width, height);//set the bounds of the ai paddle
		
		if(isTwoPlayer = false){//if not two players
			if(GamePanel.ball.topLeft.y < y - height && y >= 0)//set the ai to track the ball's height
			y -= speed;//move up
		else if(GamePanel.ball.bottomRight.y > y && y + height <= game.getHeight())//set the ai to track the ball's height
			y += speed;//move down
		}else{//if not two player
			if(goingUp){//and going up is true
				y-=speed;//move up
			}else if(goingDown){//else if going down
				y+=speed;//move down
			}
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.WHITE);//set color
		g.fillRect(x, y, width, height);//
	}
}

