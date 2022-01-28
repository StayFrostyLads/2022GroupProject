package main;

import java.awt.event.KeyEvent;
import panel.GamePanel;

public class Character {
	static int posX;
	static int posY;
	boolean canUp;
	boolean canDown;
	boolean canLeft;
	boolean canRight;
	boolean dead;

	Character() {

	}

	public void checkSurroundings() {
		String[][] currentLevel = new String[15][19];
		int level = GamePanel.level;
		String blockState;

		if (level == 1) {
			currentLevel = GamePanel.level1;
		} else if (level == 2) {
			currentLevel = GamePanel.level2;
		} else if (level == 3) {
			currentLevel = GamePanel.level3;
		} else if (level == 4) {
			currentLevel = GamePanel.level4;
		} else if (level == 5) {
			currentLevel = GamePanel.level5;
		} else if (level == 6) {
			currentLevel = GamePanel.level6;
		} else if (level == 7) {
			currentLevel = GamePanel.level7;
		} else if (level == 8) {
			currentLevel = GamePanel.level8;
		} else if (level == 9) {
			currentLevel = GamePanel.level9;
		} else if (level == 10) {
			currentLevel = GamePanel.level10;
		}

		// right
		try {
			blockState = currentLevel[posX + 1][posY];
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
			blockState = currentLevel[posX - 1][posY];
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
			blockState = currentLevel[posX][posY + 1];
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
			blockState = currentLevel[posX][posY - 1];
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
	}

	public void keyTyped(KeyEvent event) {
		checkSurroundings();
		if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W) {
			if (canUp) {
				posY = posY + 1;
			}
		} else if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S) {
			if (canDown) {
				posY = posY - 1;
			}
		} else if (event.getKeyCode() == KeyEvent.VK_LEFT || event.getKeyCode() == KeyEvent.VK_A) {
			if (canLeft) {
				posX = posX - 1;
			}
		} else if (event.getKeyCode() == KeyEvent.VK_RIGHT || event.getKeyCode() == KeyEvent.VK_D) {
			if (canRight) {
				posX = posX + 1;
			}
		}
	}

	public void setPosX(int x) {

	}

	public void setPosY(int y) {

	}

	public int getPosX() {
		int x = Character.posX;
		return x;
	}

	public int getPosY() {
		int y = Character.posY;
		return y;
	}

}
