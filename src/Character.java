import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Character extends JLabel {
	static int posX;
	static int posY;
	boolean canUp;
	boolean canDown;
	boolean canLeft;
	boolean canRight;
	public static boolean lose, win;

	public Character() {
		setVisible(true);
		ImageIcon a = new ImageIcon("./images/indybuff-r.png");
		setIcon(a);
	}
	
    public void changeDirection(boolean right) {
    	ImageIcon a;
    	if (right) {
    		a = new ImageIcon("./images/indybuff-r");
    	} else {
    		a = new ImageIcon("./images/indybuff-l");
    	}
    	setIcon(a);
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
			if (blockState.equals("wall") || blockState.equals("quickSand")) {
				canRight = false;
			} else if (blockState.equals("sand") || blockState.equals("end") || blockState.equals("wall")
					|| blockState.equals("money") || blockState.equals("portal") || blockState.equals("hardSand")
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
			if (blockState.equals("wall") || blockState.equals("quickSand")) {
				canLeft = false;
			} else if (blockState.equals("sand") || blockState.equals("end") || blockState.equals("wall")
					|| blockState.equals("money") || blockState.equals("portal") || blockState.equals("hardSand")
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
			blockState = GamePanel.currentLevel[posY - 1][posX];
			if (blockState.equals("wall") || blockState.equals("quickSand")) {
				canUp = false;
			} else if (blockState.equals("sand") || blockState.equals("end") || blockState.equals("wall")
					|| blockState.equals("money") || blockState.equals("portal") || blockState.equals("hardSand")
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
			blockState = GamePanel.currentLevel[posY + 1][posX];
			if (blockState.equals("wall") || blockState.equals("quickSand")) {
				canDown = false;
			} else if (blockState.equals("sand") || blockState.equals("end") || blockState.equals("wall")
					|| blockState.equals("money") || blockState.equals("portal") || blockState.equals("hardSand")
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


	public static void setPosX(int x) {
		posX = x;
	}

	public static void setPosY(int y) {
		posY = y;
	}

	public int getPosX() {
		int x = posX;
		return x;
	}

	public int getPosY() {
		int y = posY;
		return y;
	}

}
