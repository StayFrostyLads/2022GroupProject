package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import panel.GamePanel;

public class Character extends JLabel {
	static int posX;
	static int posY;
	boolean canUp;
	boolean canDown;
	boolean canLeft;
	boolean canRight;
	public static boolean lose, win;

	public Character(int X, int Y) {
		posX = X;
		posY = Y;
		setVisible(true);
		addKeyListener(this);
	}

	public void checkSurroundings() {
		String blockState;
        
        blockState = GamePanel.currentLevel[posY][posX];
        if (blockState.equals("end")) {
        	win = true;
        }
        
		// right
		try {
			blockState = GamePanel.currentLevel[posY][posX + 1];
			if (blockState.equals("wall") || blockState.equals("quick sand") || blockState.equals("start point")) {
				canRight = false;
			} else if (blockState.equals("sand") || blockState.equals("end point") || blockState.equals("wall")
					|| blockState.equals("money") || blockState.equals("portal") || blockState.equals("hard sand")
					|| blockState.equals("key")) {
				canRight = true;
			} else {
				canRight = false;
				System.out.println("Error: Unknown Block to the right of character");
				System.out.println("Instance: Character at position row = " + Integer.toString(posY) + " , columb = "
						+ Integer.toString(posX));
			}
		} catch (Exception e) {
			e.printStackTrace();
			blockState = "Edge";
			canRight = false;
		}

		// left
		try {
			blockState = GamePanel.currentLevel[posY][posX - 1];
			if (blockState.equals("wall") || blockState.equals("quick sand") || blockState.equals("start point")) {
				canLeft = false;
			} else if (blockState.equals("sand") || blockState.equals("end point") || blockState.equals("wall")
					|| blockState.equals("money") || blockState.equals("portal") || blockState.equals("hard sand")
					|| blockState.equals("key")) {
				canLeft = true;
			} else {
				canLeft = false;
				System.out.println("Error: Unknown Block to the left of character");
				System.out.println("Instance: Character at position row = " + Integer.toString(posY) + " , columb = "
						+ Integer.toString(posX));
			}
		} catch (Exception e) {
			e.printStackTrace();
			blockState = "Edge";
			canLeft = false;
		}

		// up
		try {
			blockState = GamePanel.currentLevel[posY + 1][posX];
			if (blockState.equals("wall") || blockState.equals("quick sand") || blockState.equals("start point")) {
				canUp = false;
			} else if (blockState.equals("sand") || blockState.equals("end point") || blockState.equals("wall")
					|| blockState.equals("money") || blockState.equals("portal") || blockState.equals("hard sand")
					|| blockState.equals("key")) {
				canUp = true;
			} else {
				canUp = false;
				System.out.println("Error: Unknown Block above of character");
				System.out.println("Instance: Character at position row = " + Integer.toString(posY) + " , columb = "
						+ Integer.toString(posX));
			}
		} catch (Exception e) {
			e.printStackTrace();
			blockState = "Edge";
			canUp = false;
		}

		// down
		try {
			blockState = GamePanel.currentLevel[posY - 1][posX];
			if (blockState.equals("wall") || blockState.equals("quick sand") || blockState.equals("start point")) {
				canDown = false;
			} else if (blockState.equals("sand") || blockState.equals("end point") || blockState.equals("wall")
					|| blockState.equals("money") || blockState.equals("portal") || blockState.equals("hard sand")
					|| blockState.equals("key")) {
				canDown = true;
			} else {
				canDown = false;
				System.out.println("Error: Unknown Block above of character");
				System.out.println("Instance: Character at position row = " + Integer.toString(posY) + " , columb = "
						+ Integer.toString(posX));
			}
		} catch (Exception e) {
			e.printStackTrace();
			blockState = "Edge";
			canDown = false;
		}
		
		if(!canUp && !canDown && !canLeft && !canRight) {
			lose = true;
		}
	}

	public void keyTyped(KeyEvent event) {
		checkSurroundings();
		if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W) {
			if (canUp) {
				posY = posY + 1;
				System.out.println(posY);
			}
		} else if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
			if (canDown) {
				posY = posY - 1;
				System.out.println(posY);
			}
		} else if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
			if (canLeft) {
				posX = posX - 1;
				System.out.println(posX);
			}
		} else if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
			if (canRight) {
				posX = posX + 1;
				System.out.println(posX);
			}
		}
	}

	public static void setPosX(int x) {
		posX = x;
	}

	public static void setPosY(int y) {
		posY = y;
	}

	public int getPosX() {
		int x = Character.posX;
		return x;
	}

	public int getPosY() {
		int y = Character.posY;
		return y;
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
		
	}

}
