import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//player 1 controls
		if(keyCode== KeyEvent.VK_W){//Whenever W is pressed, move upwards
			GamePanel.player.goingUp=true;
		}
		if(keyCode==KeyEvent.VK_S){//Whenever S is pressed, move downwards
			GamePanel.player.goingDown=true;
		}
		//player 2 controls
		if(keyCode==KeyEvent.VK_UP){//Whenever Up is pressed, move upwards
			GamePanel.ai.goingUp = true;
		}
		if(keyCode==KeyEvent.VK_DOWN){//Whenver Down is pressed, move downards
			GamePanel.ai.goingDown = true;
		}
	}

	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//Player 1 controls
		if(keyCode== KeyEvent.VK_W){//Whenever W is released, stop moving
			GamePanel.player.goingUp=false;
			
		}
		if(keyCode==KeyEvent.VK_S){//Whenever S is released, stop moving
			GamePanel.player.goingDown=false;
		}
		//Player 2 controls
		if(keyCode==KeyEvent.VK_UP){//Whenever Up is released, stop moving
			GamePanel.ai.goingUp=false;
		}
		if(keyCode==KeyEvent.VK_DOWN){//Whenever Down is released, stop moving
			GamePanel.ai.goingDown=false;
		}
	}


	//Auto generated because of implementing keylistener
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

